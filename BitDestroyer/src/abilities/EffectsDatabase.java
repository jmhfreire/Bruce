package abilities;

import characters.Wizard;

public class EffectsDatabase {
	// These enums must be instantiated within the constructor(s) of a specific spell such as FrostBolt.
	// For example, FrostBolt will have (super.snare_effect = EffectsDatabase.snareTypes.FROSTBOLT);
	// And Hamstring will have (super.snare_effect = EffectsDatabase.snareTypes.HAMSTRING); etc.
	
	public enum snareTypes{
		FROSTBOLT(0.5,2),
		HAMSTRING(1,5);
		
		private double snareModifier;
		private int duration;
		
		private snareTypes(double slowModifier, int duration){
			this.snareModifier = slowModifier;
			this.duration = duration;
		}
		
		public double getModifier(){
			return snareModifier;
		}
		public int getDuration(){
			return duration;
		}
		public void snare(Wizard unit){
			unit.setMovementSpeed(snareModifier*unit.getBaseSpeed());
		}
	}
	
	public enum rootTypes{
		FROSTNOVA(0,2);
		
		// rootModifier stops movement speed (sets it equal to zero)
		private double rootModifier;
		private int duration;
		
		private rootTypes(double rootModifier, int duration){
			this.rootModifier = rootModifier;
			this.duration = duration;
		}
		
		public double getNovaMod(){
			return FROSTNOVA.rootModifier;
		}
		
		public int getNovaDuration(){
			return FROSTNOVA.duration;
		}
		public void root(Wizard unit){
			unit.setMovementSpeed(rootModifier);
		}
	}
}
