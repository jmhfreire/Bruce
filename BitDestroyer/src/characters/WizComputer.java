package characters;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import abilities.WizSpells;
import abilities.WizSpells.FrostBolt;

public class WizComputer extends Unit{
	WizSpells rofl = new WizSpells();
	ArrayList<FrostBolt> frostbolts = new ArrayList<FrostBolt>();
	private Image image;
	int maxHealth = 1000;
	int health = maxHealth;
	private int width;
	private int height;
	double healthPercent = (double) health/maxHealth;
	double healthFillConversion = (100*healthPercent);
	int healthFill_UI = (int) healthFillConversion;
	private String wizComputer = "wizurd.png";
	private int baseMoveSpeed = 2;
	private int movement_speed = 2;
	private int x;
	private int y;
	private int posdx;
	private int posdy;
	private int negdx;
	private int negdy;
	
	
	public WizComputer(){
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		ImageIcon ii = new ImageIcon(cl.getResource(wizComputer));
		image = ii.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		x = 400;
		y = 30;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getPosDX(){
		return posdx;
	}
	public int getPosDY(){
		return posdy;
	}
	public void setPosDX(int dx){
		this.posdx = dx;
	}
	public void setPosDY(int dy){
		this.posdy = dy;
	}
	public void setNegDX(int dx){
		this.negdx = dx;
	}
	public void setNegDY(int dy){
		this.negdy = dy;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void Cast(){
		frostbolts.add(rofl.new FrostBolt(x+50, y+50, "Down"));
	}
	public ArrayList<FrostBolt> getMissiles(){
		return frostbolts;
	}
	public int getHealth(){
		return health;
	}
	public int getMaxHealth(){
		return maxHealth;
	}
	public int getHealthFill(){
		return healthFill_UI;
	}
	public double getHealthPercent(){
		return healthPercent;
	}
	public double getHealthFillConversion(){
		return healthFillConversion;
	}
	public void updateHealth(int health){
		this.health = health;
		this.healthPercent = (double) health/maxHealth;
		this.healthFillConversion = (100*healthPercent);
		this.healthFill_UI = (int) healthFillConversion;
	}
	public int getMoveSpeed(){
		return movement_speed;
	}
	public int getBaseMoveSpeed(){
		return baseMoveSpeed;
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,width,height);
	}

	
	public void moveChar() {
		
		if(x>=this.screenSize.getWidth() - this.width)
			posdx = -1;
		else if (x < width)
			negdx = 1;
		
		x +=posdx;
		y +=posdy;
		x +=negdx;
		y +=negdy;
	}
}
