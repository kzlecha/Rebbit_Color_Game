package main.ui;

import javax.swing.ImageIcon;

import main.model.Frog;

public class FrogIcon extends ImageIcon{
	/*
	 * Creates ImageIcon for a frog dependent on input denoting "face" (green or grey)
	 */
	Frog frog;
	
	public FrogIcon(boolean green) {
		/*
		 * Create ImageIcon for a Frog
		 * 
		 * if green is true:
		 * 		the icon is green
		 * if green is false:
		 * 		the icon is grey
		 */
		super(green ? "images/logo_green.png" : "images/logo_grey.png");
	}

}
