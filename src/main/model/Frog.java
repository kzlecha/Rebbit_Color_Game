package main.model;

public class Frog {
	/*
	 * Basic Frog object
	 * A frog can be green or grey, denoted by the boolean attribute green
	 * When a frog is flipped, this boolean is toggled.
	 */
	
	private boolean green;
	
	public Frog() {
		// by default assume the frog is not green
		this(false);
	}
	
	public Frog(boolean green) {
		this.green = green;
	}
	
	public boolean isGreen() {
		/*
		 * Return the current state of green
		 * 
		 * Requires: Nothing
		 * Modifies: Nothing
		 * Returns: boolean- true if the frog is green and false if it is not
		 */
		return green;
	}
	
	public void setGreen(boolean green) {
		/*
		 * Set green to @param
		 * 
		 * Requires: boolean- true if the frog is green and false if it is not
		 * Modifies: green
		 * Returns: Nothing
		 */
		this.green = green;
	}
	
	public void flip() {
		/*
		 * Toggles green attribute
		 * 
		 * Requires: Nothing
		 * Modifies: green
		 * Returns: Nothing
		 */
		
		this.green = !this.green;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nisGreen: " + green;
	}

}
