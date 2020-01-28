package main.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrogGame {
	/*
	 * This class instanciates and displays the GUI
	 * 
	 * createGUI:
	 * 		runs default set up
	 * main:
	 * 		creates panel of five frogs, adds to GUI and runs game program
	 */
	
	public static JFrame createGUI() {
		/*
		 * Create the JFrame for the Frog Game and return it
		 * 
		 * REQUIRES:
		 * 		Nothing
		 * MODIFIES:
		 * 		Nothing
		 * RETURNS:
		 * 		JFrame that is the basic GUI for the Frog Game
		 */
		
		// create the JFrame
		JFrame frame = new JFrame("Frog Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return frame;
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = createGUI();
				
				// instanciate the frog panel
				FrogPanel fp = new FrogPanel(false, false, false, false, false);
				frame.add(fp);
				
				// make the frame visible to the user
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
