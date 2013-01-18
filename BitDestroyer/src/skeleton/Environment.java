package skeleton;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import abilities.SpellEffects;
import abilities.WizSpells;
import abilities.WizSpells.FrostBolt;
import characters.WizComputer;
import characters.Wizard;

public class Environment extends JPanel{
	private Skeleton mainFrame;
	private int ENVIRONMENT_WIDTH;
	private int ENVIRONMENT_HEIGHT;
	private PlayerUI playerUI;
	private Clock clockimg;
	private int clock = 0;
	private double clockCounter;
	private int trueClock;
	private int timeCounter = 0;
	public static int drawTimer;
	private double trueTime;
	private int realTime;
	private DeathScreen deadHero;
	private WinScreen GameWon;
	private WizComputer computer;
	private Wizard mage;
	private Timer timer;
	ArrayList<WizComputer> ms;
	 //private FrostBolt frostbolt = wiz.new FrostBolt();
	
	public Environment(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ENVIRONMENT_WIDTH = screenSize.width;
		ENVIRONMENT_HEIGHT = screenSize.height;
		mage = new Wizard();
		clockimg = new Clock();
		deadHero = new DeathScreen();
		GameWon = new WinScreen();
		playerUI = new PlayerUI(mage);
		computer = new WizComputer();
		addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        timer = new Timer();
        //timer for computer casting
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 1000);
        //timer for the game's actions
        timer.scheduleAtFixedRate(new ActionTask(), 3, 5);
        //timer for animating mage (just increases drawTimer).
        timer.scheduleAtFixedRate(new AnimateCharTask(), 0, 500);
        add(clockimg);
        
	}
	
	public void paint(Graphics g){
		super.paint(g);
	
		
		Graphics2D g2 = (Graphics2D)g;
		//makes the images less sprite-looking.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawImage(computer.getImage(), computer.getX(), computer.getY(), this);
		// does the drawings for the following objects. Might make a package called "draw" that contains all the drawing for all types of classes.
		// For example, Wizard_Draw class will have a method drawWizard, which will take a wizard's images and draw it. Alternatively could mount
		// all the images in the game in the "draw" package class path, and just directly reference them / initiate them in draw (which would process faster
		// I would think).
		mage.drawWizard(g2);
		playerUI.drawPlayerUI(g2);
		deadHero.drawDeathScreen(g2, mage);
		
		//gameWon screen.
		if(computer.getHealth() <= 0){
			g2.drawImage(GameWon.getImage(), GameWon.getX(), GameWon.getY(), this);
		}
		
       //draws the frostbolts for computer.
       ArrayList<FrostBolt> cs = computer.getMissiles();
       for(int i=0;i<cs.size();i++){
    	   FrostBolt enemyFrost = cs.get(i);
    	   g2.drawImage(enemyFrost.getImage(), enemyFrost.getX(), enemyFrost.getY(), this);
       }
       
       // HealthBar will be its own class with this method inside it;
       Rectangle2D healthBarComputer = new Rectangle2D.Double(computer.getX(), computer.getY()-30, 100, 10);
	      g2.setStroke(new BasicStroke(1));
	      g2.setColor(Color.red);
	      g2.fillRect(computer.getX(), computer.getY()-30, computer.getHealthFill(), 10);
	      g2.draw(healthBarComputer);
		
	}
	
	//This is the timer for animating the mage.
	public class AnimateCharTask extends TimerTask{

		public void run() {
			drawTimer = drawTimer+1;
			
		}
		
	}
	//This is the timer that gets checked every 5 milliseconds. Gotta change to 1 ms. These are the actions for the
	//game.
public class ActionTask extends TimerTask{ 	
	public void run() {
		 	mage.moveChar();
	        computer.moveChar();
			repaint();
		
			//Makes the computer get a random dx and dy so that it moves randomly.
		Random xr = new Random();
		if(realTime%2 == 0){
			computer.setPosDX(xr.nextInt(3));
			if(computer.getX()>Skeleton.width-computer.getImage().getWidth(null)-Skeleton.width/15){
				computer.setX(Skeleton.width-computer.getImage().getWidth(null)-Skeleton.width/15);
				computer.setNegDX(-(xr.nextInt(2)));
			}
		}else{
			computer.setNegDX(-(xr.nextInt(3)));
			if(computer.getX()<computer.getImage().getWidth(null)+Skeleton.width/15){
				computer.setX(computer.getImage().getWidth(null)+Skeleton.width/15);
				computer.setPosDX(xr.nextInt(3));
			}
		}
		
		// this is just the game's visual timer graphic. The reason timeCounter (the time tracker below this one) is not used
		// is because it gets reset every time the mage gets snared. The reason it does this is to count the duration 
		// of the snare. Will change its name to "SnareTimer" so not as confusing.
		clock = clock + 5;
		clockCounter = clock/1000;
		trueClock = (int)clockCounter;
		clockimg.setText("Timer:  "+String.valueOf(trueClock));
		
		
		//converts millisecond time to real time (seconds).
		timeCounter = timeCounter + 5;
		trueTime = timeCounter/1000;
		realTime = (int)trueTime;
		ArrayList<FrostBolt> ms = mage.getMissiles();
		ArrayList<FrostBolt> cs = computer.getMissiles();
		
		
		
		if(mage.getHealth() == 0){
			timer.cancel();
		}
		if(computer.getHealth() <= 0){
			timer.cancel();
		}
		
		if(mage.getMovementSpeed() < mage.getBaseSpeed() && realTime == 2){
			mage.setMovementSpeed(mage.getBaseSpeed());
		}
		
	        for (int i = 0; i < mage.getMissiles().size(); i++) {
	            FrostBolt shot_Frostbolt = mage.getMissiles().get(i);
	            if (shot_Frostbolt.isVisible()){ 
	                shot_Frostbolt.moveDown();
	            if(computer.getBounds().intersects(shot_Frostbolt.getBounds())){
                	int newHealth = computer.getHealth() - shot_Frostbolt.getDamage();
                	computer.updateHealth(newHealth);
                	mage.getMissiles().remove(i);
                	}}
	            else ms.remove(i);
	        	}	
	        for (int i = 0; i < cs.size(); i++) {
	            FrostBolt shot_Frostbolt = cs.get(i);
	            if (shot_Frostbolt.isVisible()){
	                shot_Frostbolt.moveUp();
	                // make a function, spellHit, that basically does all of the below. Put the function in 
	                // the Spells class. spellHit will check what spell it is, how much damage it does, and what
	                // type of effect to apply.
	                
	                //Also, perhaps make a class that contains the functions that handle real-time actions, such
	                //as this one and all the other ones in this environment.
	                if(mage.getBounds().intersects(shot_Frostbolt.getBounds())){
	                	int newHealth = mage.getHealth() - shot_Frostbolt.getDamage();
	                	mage.updateHealth(newHealth);
	                	shot_Frostbolt.getSnare().snare(mage);
	                	cs.remove(i);
	                	timeCounter = 0;
	                	}
	                
	            }else cs.remove(i);
	        }
	       
			}
	
}
	// The timer for the computer casting frostbolt (which is every 1 second).
	  class ScheduleTask extends TimerTask {

	            public void run() {
	            	computer.Cast();     	
	                repaint();
	            }
	        }
		 	
		 	
		
	 
	    private class TAdapter extends KeyAdapter {

	        public void keyPressed(KeyEvent e) {
	        	mage.keyPressed(e);
	        }
	        public void keyReleased(KeyEvent e) {
	            mage.keyReleased(e);
	        }        
	    }

}