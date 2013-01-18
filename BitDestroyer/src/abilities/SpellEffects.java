package abilities;

import characters.Character_Class;
import characters.Wizard;

public class SpellEffects {
	private int type;
	private int modifier;
	private int duration;
	
	private snareTypes snare;
	private String root;
	private String stun;
	private String disable;
	private String interrupt;
	
	public SpellEffects(snareTypes snare){
		this.snare = snare;
		modifier = snare.getFrostboltMod();
		duration = snare.getFrostboltDuration();
	}
	
	public enum snareTypes{
		FROSTBOLT(1,2),
		HAMSTRING(1,5);
		
		private int snareModifier;
		private int duration;
		
		private snareTypes(int slowModifier, int duration){
			this.snareModifier = slowModifier;
			this.duration = duration;
		}
		
		public int getFrostboltMod(){
			return FROSTBOLT.snareModifier;
		}
		public int getFrostboltDuration(){
			return FROSTBOLT.duration;
		}
	}
	public enum rootTypes{
		FROSTNOVA(0,2);
		
		private int rootModifier;
		private int duration;
		
		private rootTypes(int rootModifier, int duration){
			this.rootModifier = rootModifier;
			this.duration = duration;
		}
		
		public int getNovaMod(){
			return FROSTNOVA.rootModifier;
		}
		
		public int getNovaDuration(){
			return FROSTNOVA.duration;
		}
	}
	
	public void snare(Wizard wiz){
		wiz.setMovementSpeed(modifier);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getModifier() {
		return modifier;
	}
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public snareTypes getSnare() {
		return snare;
	}
	public void setSnare(snareTypes snare) {
		this.snare = snare;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getStun() {
		return stun;
	}
	public void setStun(String stun) {
		this.stun = stun;
	}
	public String getDisable() {
		return disable;
	}
	public void setDisable(String disable) {
		this.disable = disable;
	}
	public String getInterrupt() {
		return interrupt;
	}
	public void setInterrupt(String interrupt) {
		this.interrupt = interrupt;
	}
	
}
