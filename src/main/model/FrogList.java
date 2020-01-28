package main.model;

import java.util.ArrayList;
import java.util.List;

public class FrogList{
	/*
	 * A list of Frogs
	 * In addition to having most functionality of a list
	 * a frog at a given index can be flipped
	 * doing so will flip its neighbors as well
	 * 
	 * TODO: it might be better to extend the List class instead of creating intermediate methods
	 */
	
	List<Frog> frogs;
	
	public FrogList() {
		// instanciate the list
		frogs = new ArrayList<Frog>();
	}
	
	public void addFrog(boolean green) {
		/*
		 * Adds a Frog to the ArrayList of Frogs
		 * 
		 * REQUIRES:
		 * 		@param: boolean (true if Frog is green)
		 * MODIFIES:
		 * 		frogs: adds a new frog to the list
		 * RETURNS:
		 * 		Nothing
		 */
		
		frogs.add(new Frog(green));
	}
	
	public Frog getFrog(int index) {
		/*
		 * An extension of ArrayList get(index)
		 * Returns the frog at an index
		 * Time Complexity: O(1)
		 * 
		 * REQUIRES:
		 * 		@param: integer index in the list
		 * MODIFIES:
		 * 		Nothing
		 * RETURNS:
		 * 		frog at the given index
		 */
		if(index < 0 || index > frogs.size()-1) {
			return null;
		}
		return frogs.get(index);
	}
	
	public boolean isFrogGreen(int index) {
		/*
		 * Checks to see if the frog at the given index is green
		 * Time Complexity: O(1)
		 * 
		 * REQUIRES:
		 * 		Integer postion denoting the frog's index in the list
		 * MODIFIES:
		 * 		Nothing
		 * RETURNS:
		 * 		boolean telling if the frog is green (true if green)
		 * 		returns false if index out of bounds
		 * TODO:
		 * 		raise IndexOutOfBoundsException if out of bounds
		 * 
		 */
		if(index >= 0 && index <= frogs.size()){
            Frog temp = frogs.get(index);
            return temp.isGreen();
        }
        return false;
	}
	
	public boolean allFrogsGreen() {
		/*
		 * Iterates through the list to check if each frog is green
		 * Returns true if all frogs are green and false otherwise
		 * Time Complexity: O(n)
		 * 
		 * REQUIRES:
		 * 		Nothing
		 * MODIFIES:
		 * 		Nothing
		 * RETURNS:
		 * 		boolean (true if all are green and false if grey)
		 */
		for(Frog frog: frogs) {
			if(!frog.isGreen()) {
				return false;
			}
		}
		return true;
	}
	
	public int size() {
		/*
		 * return size of the list
		 */
		return frogs.size();
	}
	
	public void flip(int index) {
		/*
		 * Flips the frog at the current index
		 * as well as the frogs next to it (+1 and -1)
		 * Time Complexity: O(1)
		 * 
		 * REQUIRES:
		 * 		Integer index denoting the frog's index in the list
		 * MODIFIES:
		 * 		Flips frog at current index, as well as its neighbors
		 * 		Therefore frogs at index, index + 1, and index - 1
		 * RETURNS:
		 * 		Nothing
		 * 
		 */
		int max_index = frogs.size() - 1;
		int left_index = index - 1;
		int right_index = index + 1;

		// frog at index
		if((index >= 0) && (index <= max_index)) {
			Frog temp = frogs.get(index);
			temp.flip();
		}
		
		// neighboring frogs
		if((left_index >= 0) && (left_index <= max_index)) {
			Frog temp = frogs.get(index - 1);
			temp.flip();
		}
		if((right_index >= 0) && (right_index <= max_index)) {
			Frog temp = frogs.get(index + 1);
			temp.flip();
		}
		
	}
	
	
	@Override
	public String toString() {
		/*
		 * Overrides Object toString method. Lists order that frogs are green and grey
		 * 
		 * REQUIRES:
		 * 		Nothing
		 * MODIFIES:
		 * 		Nothing
		 * RETURNS:
		 * 		A string listing color of the frog in order
		 */
		String s = "";
		for(Frog frog: frogs) {
			if(frog.isGreen()) {
				s += "green ";
			}else {
				s += "grey ";
			}
		}
		return s;
	}
	

}
