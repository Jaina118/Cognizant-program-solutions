import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calcTest {

    private Calculator calculator;

    // This runs BEFORE every test
    @Before
    public void setUp() {
        System.out.println("Setting up Calculator...");
        calculator = new Calculator();  // Arrange
    }

    // This runs AFTER every test
    @After
    public void tearDown() {
        System.out.println("Cleaning up Calculator...");
        calculator = null;
    }

    @Test
    public void testAddition() {
        // Act
        int result = calculator.add(10, 5);
        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(20, 8);
        assertEquals(12, result);
    }
}
