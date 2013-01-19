package skeleton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import characters.Wizard;

import abilities.Spells;

public class Skeleton extends JFrame{
	public static int width;
	public static int height;
	public Skeleton(){
		pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
	    width = screenSize.width;
	    height = screenSize.height;
	    add(new Environment());
	    setVisible(true);
		setTitle("Bit Destroyer");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);	
		
	}
	
	public static void main(String[] args){
		new Skeleton();
	}
}
