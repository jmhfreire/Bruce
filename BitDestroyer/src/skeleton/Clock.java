package skeleton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;

public class Clock extends JLabel{
	private int x;
	private int y;
	private Image image;
	
	public Clock(){
		setText("Time: 0");
		this.setFont(new Font("Century Gothic", Font.BOLD, 30));
		setForeground(Color.RED);
		setVisible(true);
		x = 10;
		y = 10;
	}

	@Override
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
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
