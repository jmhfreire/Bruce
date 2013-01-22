package characters;
import abilities.WizSpells;
import abilities.WizSpells.FrostBolt;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import skeleton.*;

import javax.swing.ImageIcon;

public class Wizard extends Unit{
	// The spells that a wizard can cast;
	public WizSpells spellBook = new WizSpells();
	private Environment environment;
	
	private Image image;
	private Image frostbolt_snared; // image that gets drawn when Wizard's movement speed is decreased.
	private Image image1;
	private ArrayList<FrostBolt>  FrostBolts;
	//to improve make direction an enum instead of hard_coding string values.
	
	public Wizard(){
		 	ClassLoader cl = Thread.currentThread().getContextClassLoader();
		 	ImageIcon ii = new ImageIcon(cl.getResource("wizard.png"));
		 	FrostBolts = new ArrayList<FrostBolt>();
	        image = ii.getImage();
	        ImageIcon ff = new ImageIcon(cl.getResource("wizardcool.png"));
	        frostbolt_snared = ff.getImage();
	        ImageIcon gg = new ImageIcon(cl.getResource("wizard1.png"));
	        image1 = gg.getImage();
	        width = image.getWidth(null);
	        height = image.getHeight(null);
	        x = Skeleton.width/2 - image.getWidth(null);
	        y = Skeleton.height - (image.getHeight(null));       
	}
	
	public Image getImage(){
		return image;
	}
	public Image getFrostboltSnaredImg(){
		return frostbolt_snared;
	}
	public Image getImage1(){
		return image1;
	}
	@Override
	public void updateHealth(int health){
		this.health = health;
		this.healthPercent = (double) health/maxHealth;
		this.healthFillConversion = (300*healthPercent);
		this.healthFill_UI = (int) healthFillConversion;
	}
	
	@Override
	public void moveChar(){
		if(direction == "LEFT"){
			x += negdx;
			}
		if(direction == "RIGHT"){
			x += posdx;
			}
		if(direction == "UP"){
			y += negdy;
			}
		if(direction == "DOWN"){
			y += posdy;
			}
	}
	
	public void castFrostbolt(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_1){		
		}
	}
	
	public ArrayList<FrostBolt> getMissiles() {
		return FrostBolts;
    }
	
	// These methods for actions should probably be implemented elsewhere, not in the individual classes.
	
	public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            Cast(); //action that shoots a FrostBolt. 
        }
        if (key == KeyEvent.VK_LEFT) {
        	if(x <= 0+image.getWidth(null)){
        		x = 0;
    			keyReleasedLeft(e);
    		}else{
        	negdx = -movement_speed;
            this.direction = "LEFT";
    		}
        }
        
        if(key == KeyEvent.VK_RIGHT) {
        	if(x >= Skeleton.width-image.getWidth(null)){
        		x = Skeleton.width-image.getWidth(null);
        		keyReleasedRight(e);
        	}else{
            posdx = movement_speed;}
            this.direction = "RIGHT";
        }

        if (key == KeyEvent.VK_UP) {
        	if(y <= 0+image.getHeight(null)){
        		y = 0+image.getHeight(null);
        		keyReleasedUp(e);
        	}else{
            negdy = -movement_speed;
            this.direction = "UP";
        	}
        }

        if (key == KeyEvent.VK_DOWN) {
        	if(y >= Skeleton.height-image.getHeight(null)){
        		y = Skeleton.height-image.getHeight(null);
    			keyReleasedDown(e);
    		}else{
            posdy = movement_speed;
            this.direction = "DOWN";
    		}
        }
	}
	public void Cast() {
        FrostBolts.add(spellBook.new FrostBolt(x+20, y-80));
    }
	
	public void keyReleasedLeft(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT);
		negdx = 0;
	}
	
	public void keyReleasedRight(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT);
		posdx = 0;
	}
	
	public void keyReleasedUp(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP);
		negdy = 0;
	}
	
	public void keyReleasedDown(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN);
		posdy = 0;
	}

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE){
        	
        }
        if (key == KeyEvent.VK_LEFT) {
            negdx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            posdx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            negdy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            posdy = 0;
        }
    }
	
	public void drawWizard(Graphics2D g2){
		for (int i = 0; i < FrostBolts.size(); i++ ) {
            FrostBolt m = FrostBolts.get(i);
		    g2.drawImage(m.getImage(), m.getX(), m.getY(), environment);
		        }
		{if(Environment.drawTimer%2 == 0){
			g2.drawImage(image, x, y, environment);}
		else{
			g2.drawImage(image1, x, y, environment);}}
		//draws image for snared mage.
		if(baseMoveSpeed > movement_speed){
			g2.drawImage(frostbolt_snared, x, y, environment);	
		}
	}
	
}