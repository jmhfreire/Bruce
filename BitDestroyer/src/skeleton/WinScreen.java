package skeleton;
import java.awt.Image;

import javax.swing.ImageIcon;

public class WinScreen {
	private int x;
	private int y;
	private Image image;
	
	public WinScreen(){
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		ImageIcon win = new ImageIcon(cl.getResource("winscreen.png"));
		image = win.getImage();
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
