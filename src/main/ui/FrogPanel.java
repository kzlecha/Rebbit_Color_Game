package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.model.FrogList;
import main.ui.FrogImage;

public class FrogPanel extends JPanel{
	/*
	 * Extension of JPanel specific to FrogGame
	 * 
	 * Functionality allows for frogs to be flipped, therefore showing the opposite icon
	 * And the game is won when all frogs are flipped to the green "face"
	 * Winning the game will display a "You Win" message
	 */
	
	FrogList frogList;
	List<JButton> jbuttons;
	FrogImage frogImage;
	
	boolean winCondition;
	
	public FrogPanel(boolean ...args) {
		/*
		 * Instancate variables and create buttons for each frog
		 * Each Button can be flipped and will check to see if the winCondition has been met
		 * If the winConditon is met, the win message is displayed
		 */
		
		// instanciate variables
		frogList = new FrogList();
		jbuttons = new ArrayList<>();
		frogImage = new FrogImage();
		
		//set layout
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		for (int i = 0; i < args.length; i++) {
			int index = i;
			
			// add a frog and create a new button for it
			frogList.addFrog(args[i]);
			JButton jbutton = new JButton(new FrogIcon(args[i]));
			
			// add action listener to button
			jbutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					 // flip frog at index when button is pressed
					System.out.println("You clicked button " + index);
					flip_frogs(index);
					
					// check to see if the user has won
					getWinCondition();
					if (winCondition) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								displayWinMessage();
							}
						});
					}
				}
			});
			
			add(jbutton);
			jbuttons.add(jbutton);
			
		}
	}
	
	boolean getWinCondition() {
		/*
		 * The game is won if all frogs are green instead of grey
		 * Time Complexity: O(1)
		 * 
		 * REQUIRES:
		 * 		Nothing
		 * MODIFIES:
		 * 		boolean winCondition (true if all frogs are green)
		 * RETURNS:
		 * 		winCondition
		 */
		winCondition=frogList.allFrogsGreen();
		return winCondition;
	}
	
	void flip_frogs(int index) {
		/*
		 * Flips Frog at index and its neighbors
		 * TimeComplexity: O(3)
		 * 
		 * REQUIRES:
		 * 		integer index denoting which frog has been flipped
		 * MODIFIES:
		 * 		frogList: flips frog at index
		 * 		jbuttons: resets icons to match flip
		 * RETURNS:
		 * 		Nothing
		 */
		frogList.flip(index);
		System.out.println(frogList.toString());
		
		displayFrog(index);
		displayFrog(index - 1);
		displayFrog(index + 1);
	}
	
	void displayFrog(int index) {
		// display the appropriate icon for the frog at the given position
		
		if(index < 0 || index > frogList.size()-1) {
			return;
		}
		
		if(frogList.isFrogGreen(index)) {
			jbuttons.get(index).setIcon(frogImage.getGreenImage());
		}else {
			jbuttons.get(index).setIcon(frogImage.getGreyImage());
		}
	}
	
	void displayWinMessage() {
		// display win message and exit the system
		JOptionPane.showMessageDialog(this, "You win!", "You win!", JOptionPane.INFORMATION_MESSAGE, frogImage.getGreenImage());
		System.exit(0);
	}
}
