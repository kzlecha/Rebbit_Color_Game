package test;

import main.model.Frog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFrog {
	
	// Test that frog that starts grey can be turned green
    @Test
    public void testFrogGrey() {
        Frog testFrog = new Frog(false);
        assertFalse(testFrog.isGreen());
        testFrog.flip();
        assertTrue(testFrog.isGreen());
    }

    // Test that frog that starts green can be turned grey
    @Test
    public void testFrogGreen() {
        Frog testFrog = new Frog(true);
        assertTrue(testFrog.isGreen());
        testFrog.flip();
        assertFalse(testFrog.isGreen());
    }
    
    // Test setGreen()
    @Test
    public void testSetGreen() {
    	Frog testFrog = new Frog();
        testFrog.setGreen(true);
        assertTrue(testFrog.isGreen());
    }

}
