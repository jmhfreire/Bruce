package draw;

import java.awt.Graphics2D;
import java.awt.Image;

import skeleton.Environment;
import skeleton.PlayerUI;

public class PlayerUI_Draw {
	private Environment environment;
	private PlayerUI playerUI;
	private Image SKILL_BAR;
	
	public void drawPlayerUI(Graphics2D g2){
		g2.drawImage(SKILL_BAR, 500, 700, environment);
	}
}
