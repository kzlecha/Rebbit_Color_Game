package test;

import main.model.FrogList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFrogList {

	// Test list of 1 frog
	
	@Test
	public void testOneFrog() {
		FrogList frogs = new FrogList();
		frogs.addFrog(false);
		frogs.flip(0);
		assertTrue(frogs.getFrog(0).isGreen());
	}
	
	// Test 2 frogs
	
	@Test
	public void testTwoGrey() {
		FrogList frogs = new FrogList();
		frogs.addFrog(false);
		frogs.addFrog(false);
		
		System.out.println(frogs.toString());
        assertFalse(frogs.allFrogsGreen());

        // flip one and both become green
        frogs.flip(0);
        System.out.println(frogs.toString());
        assertTrue(frogs.allFrogsGreen());
	}
	
	@Test
	public void testOneGreyOneGreen() {
		FrogList frogs = new FrogList();
		frogs.addFrog(true);
		frogs.addFrog(false);

        System.out.println(frogs.toString());
        assertFalse(frogs.allFrogsGreen());
        
        // flip one and one is still green and one grey
		frogs.flip(0);
		System.out.println(frogs.toString());
        assertFalse(frogs.allFrogsGreen());
	}
	
	// Test 3 Frogs
	@Test
    public void testThreefrogsownsSame() {
		FrogList frogs = new FrogList();
		frogs.addFrog(false);
		frogs.addFrog(false);
		frogs.addFrog(false);

        System.out.println(frogs.toString());
        assertFalse(frogs.allFrogsGreen());

        frogs.flip(1);
        System.out.println(frogs.toString());
        assertTrue(frogs.allFrogsGreen());

        frogs.flip(0);
        System.out.println(frogs.toString());
        assertFalse(frogs.allFrogsGreen());

        frogs.flip(2);
        System.out.println(frogs.toString());
        assertFalse(frogs.allFrogsGreen());
    }
	
}
