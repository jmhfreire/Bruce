package abilities;

import java.awt.Image;
import java.awt.Rectangle;

import abilities.EffectsDatabase;
import characters.Wizard;
import skeleton.*;

public class Spells{
	
	/* TO DO:
	 * Make a design template for creating subclasses of Spells such as FrostBolt.
	 */
	protected String damageType;
	protected String buttonName;
	// Modifier numbers for non-effects (damage, projectile speed, etc).
	protected int damage;
	protected int healing;
	protected int cast_time;
	protected int height;
	protected int width;
	protected double	MISSILE_SPEED = 2;
	protected int	ENVIRONMENT_WIDTH = 700;
	protected int ENVIRONMENT_HEIGHT = 800;
	protected int x, y;
	
	// The spell's image (will be many images).
	protected Image image;
	protected Image button;
	
	protected boolean visible;
	
	// The spell's effect.
	protected EffectsDatabase.snareTypes snare_effect;
	protected EffectsDatabase.rootTypes root_effect;
	protected EffectsDatabase stun_effect;
	
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public String getDamageType() {
		return damageType;
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
	public Rectangle getBounds(){
		return new Rectangle(x,y,width,height);
	}
	public boolean isVisible() {
		return visible;
	}
	public void setHealing(int healing) {
		this.healing = healing;
	}
	public int getCast_time() {
		return cast_time;
	}
	public void setCast_time(int cast_time) {
		this.cast_time = cast_time;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getButtonName(){
		return buttonName;
	}
	public EffectsDatabase.snareTypes getSnare() {
			return this.snare_effect;
	}
	public void setSnare(EffectsDatabase.snareTypes snare) {
			this.snare_effect = snare;
	}
	public EffectsDatabase.rootTypes getRoot() {
			return this.root_effect;
	}
	public void setRoot(EffectsDatabase.rootTypes root) {
			this.root_effect = root;
	}
}

