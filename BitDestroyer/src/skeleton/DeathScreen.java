package skeleton;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import characters.Unit;
import characters.Wizard;

public class DeathScreen {
	private Unit unit;
	private Environment environment;
	private int x;
	private int y;
	static private Image image;
	
	public DeathScreen(){
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		ImageIcon death = new ImageIcon(cl.getResource("deathscreen.png"));
		image = death.getImage();
		x = 325;
		y = 325;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	static public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		DeathScreen.image = image;
	}
	
	// Replace Wizard parameter with Unit once Unit is implemented;
	public void drawDeathScreen(Graphics2D g2, Wizard wiz){
		if(wiz.getHealth() == 0){
			g2.drawImage(image, x, y, environment);
		}
	}
}
