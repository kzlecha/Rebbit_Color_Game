package main.ui;

import javax.swing.ImageIcon;

public class FrogImage {
	/*
	 * Create ImageIcons for the Frogs
	 * 
	 * images are saved in the images folder
	 */
	
	private ImageIcon greenImage;
	private ImageIcon greyImage;

	public FrogImage() {
		greenImage = new ImageIcon("images/logo_small.png");
		greyImage = new ImageIcon("images/logo_grey.png");
	}

	public ImageIcon getGreenImage() {
		return greenImage;
	}

	public ImageIcon getGreyImage() {
		return greyImage;
	}
	
	
}
