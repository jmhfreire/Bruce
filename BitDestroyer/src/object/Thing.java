package object;

import java.awt.Dimension;
import java.awt.Toolkit;

// objects in the game that need to be scaled will extend this? Base for every single object maybe?

public class Thing {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	protected int width;
	protected int height;
	public Thing(){
		width = screenSize.width;
		height = screenSize.height;
	}
}
