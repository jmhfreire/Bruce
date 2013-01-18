package characters;

import java.awt.event.KeyEvent;

public interface CharacterActions {
	
	void moveChar();
	void Attack();
	
	// possible things to implement - dodge
	//specialized character actions such as casting, maybe make an interface CasterCharacterActions that extends
	//CharacterActions.
	
}
