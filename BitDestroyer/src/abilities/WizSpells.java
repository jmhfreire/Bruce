package abilities;
import skeleton.*;
import javax.swing.ImageIcon;

public class WizSpells extends Spells{
	
	public WizSpells(){
	}
	
	public class FrostBolt extends WizSpells{
		public FrostBolt(int x, int y) {
			super.buttonName = "FrostBolt";
			super.snare_effect = EffectsDatabase.snareTypes.FROSTBOLT;
			super.setDamage(10);
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			ImageIcon ii = new ImageIcon(cl.getResource(
					"frostboltimgUP.png"));
			super.image = ii.getImage();
			super.visible = true;
			super.x = x;
			super.y = y;
			height = image.getHeight(null);
			width = image.getWidth(null);
		}
		
		public FrostBolt(int x, int y, String any){
			super.snare_effect = EffectsDatabase.snareTypes.FROSTBOLT;
			super.setDamage(20);
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			ImageIcon ii = new ImageIcon(cl.getResource(
					"frostboltimgDOWN.png"));
			super.image = ii.getImage();
			super.visible = true;
			super.x = x;
			super.y = y;
			height = image.getHeight(null);
			width = image.getWidth(null);
		}
		public void moveDown() {
			y -= MISSILE_SPEED;
			if (y > Skeleton.height)
				visible = false;
		}
		public void moveUp() {
			y += MISSILE_SPEED;
			if (y > Skeleton.height)
				visible = false;
		}	
	}
}
