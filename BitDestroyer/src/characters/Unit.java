package characters;

import java.awt.Rectangle;

public abstract class Unit {

		protected int x;
		protected int y;
		protected int width;
		protected int height;
		
		double baseMoveSpeed = 2;
		double movement_speed = 2;
		int maxHealth = 100;
		int health = maxHealth;
		double healthPercent = (double) health/maxHealth;
		double healthFillConversion = (300*healthPercent);
		int healthFill_UI = (int) healthFillConversion;
		
		protected double posdx;
		protected double posdy;
		protected double negdx;
		protected double negdy;
		//to improve make direction an enum instead of hard_coding string values.
		protected String direction;
		
		public Unit(){   
		}
		
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
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
		public double getMovementSpeed(){
			return movement_speed;
		}
		public double getBaseSpeed(){
			return baseMoveSpeed;
		}
		public void updateHealth(int health){
			this.health = health;
			this.healthPercent = (double) health/maxHealth;
			this.healthFillConversion = (300*healthPercent);
			this.healthFill_UI = (int) healthFillConversion;
		}
		public void setMovementSpeed(double speed){
			this.movement_speed = speed;
		}
		
		public Rectangle getBounds(){
			return new Rectangle(x,y,width,height);
		}
		
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
}
