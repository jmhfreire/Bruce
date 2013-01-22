package skeleton;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import characters.Wizard;

public class PlayerUI extends Component{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Environment environment;
	private int healthBar_width = 300;
	private int healthBar_height = 50;
	
	public Image SKILL_BAR;
	public Image skill_one;
	// This(PlayerUI) will have a field UNIT, rather than a WIZARD.
	public Wizard mage;
 
	// Don't need to make a field for button image in Spell class, just a field for the name of
	// the button.
	
	// The UI will take in a Unit, not wizard, once Unit class is fully implemented / fleshed out.
	public PlayerUI(Wizard wiz){
		mage = wiz;
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		ImageIcon SB = new ImageIcon(cl.getResource("SKILL_BAR.png"));
		SKILL_BAR = SB.getImage();
		
		
		
	/*ImageIcon s1 = new ImageIcon(this.getClass().getResource(ability_one.getButtonName()));
	skill_one = s1.getImage();*/

	}
	
	public void drawPlayerUI(Graphics2D g2){
		
		g2.drawImage(SKILL_BAR, 0, Skeleton.height-2*SKILL_BAR.getHeight(null), environment);
		Rectangle2D healthBar = new Rectangle2D.Double(0, Skeleton.height-200, healthBar_width, healthBar_height);
	      g2.setStroke(new BasicStroke(1));
	      g2.setColor(Color.red);
	      g2.fillRect(0, Skeleton.height-200, mage.getHealthFill(), healthBar_height);
	      g2.draw(healthBar);
	}
	
	public Image getSKILL_BAR(){
		return SKILL_BAR;
	}
	
}
