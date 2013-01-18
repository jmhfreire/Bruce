package skeleton;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import characters.Wizard;

import abilities.Spells;

public class PlayerUI extends Component{
	private Environment environment;
	private int height;
	
	private Spells ability_one;
	
	public Image SKILL_BAR;
	public Image skill_one;
	// This will take a UNIT, rather than a WIZARD.
	public Wizard mage;
	
	// The button images wont be in the class path of abilities but rather here, in skeleton class path. 
	// Don't need to make a field for button image in Spell class, just a field for the name of
	// the button.
	public PlayerUI(Wizard wiz){
		mage = wiz;
		ImageIcon SB = new ImageIcon(this.getClass().getResource("SKILL_BAR.png"));
		SKILL_BAR = SB.getImage();
		
		
		
	/*ImageIcon s1 = new ImageIcon(this.getClass().getResource(ability_one.getButtonName()));
	skill_one = s1.getImage();*/

	}
	
	public void drawPlayerUI(Graphics2D g2){
		
		g2.drawImage(SKILL_BAR, 0, Skeleton.height-2*SKILL_BAR.getHeight(null), environment);
		Rectangle2D healthBar = new Rectangle2D.Double(0, 900, 300, 50);
	      g2.setStroke(new BasicStroke(1));
	      g2.setColor(Color.red);
	      g2.fillRect(0, 900, mage.getHealthFill(), 50);
	      g2.draw(healthBar);
	}
	
	public Image getSKILL_BAR(){
		return SKILL_BAR;
	}
	
}
