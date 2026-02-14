// java.laskin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
/*
 * JUnit 5
 */

public class CalculatorTest { // The class name must end with Test

    // Fixture: all tests use the same calculator,
    // which is reset before each test.
    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        calculator.reset();
    }

    // The test method name can be anything, as long as it has the @Test annotation
    @Test
    public void testAdd() {
        calculator.add(1);
        calculator.add(2);
        assertEquals(3, calculator.getResult(), DELTA, "The sum of numbers 1 and 2 is 3");
        calculator.reset();
    }

    @Test
    public void testSubtract() {
        calculator.add(10.0);
        calculator.subtract(2.0);
        assertEquals(8.0, calculator.getResult(), DELTA, "The difference between 10 and 2 is 8");
        calculator.reset();
    }

    @Test
    public void testDivideByNegative() {
        calculator.add(10);
        calculator.divide(-2);
        assertEquals(-5, calculator.getResult(), DELTA, "Division by negative number is incorrect");
    }

    @Test
    public void testReset() {
        calculator.add(10);
        calculator.reset();
        assertEquals(0, calculator.getResult(), DELTA, "Reset should set result to 0");
    }

    @Test
    public void testGetResult() {
        calculator.add(7);
        assertEquals(7, calculator.getResult(), DELTA, "getResult should return the current result");
    }

    @Test
    public void testPowerOn() {
        calculator.add(5);
        calculator.powerOn();
        assertEquals(0, calculator.getResult(), DELTA, "powerOn should reset result to 0");
    }

    @Test
    public void testPowerOff() {
        // No state change to check, but method should be callable
        calculator.powerOff();
        calculator.reset();
    }

    @Test
    @DisplayName("Test division 8 / 2")
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult(), DELTA, "Division 8/2 is 4");
        calculator.reset();
    }

    // The correct result of this test is that division by zero throws an exception,
    // the caller then handles it in the desired way
    @Test
    @DisplayName("Test division by zero")
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testMultiply() {
        calculator.add(3);
        calculator.multiply(4);
        assertEquals(12, calculator.getResult(), DELTA, "Multiplication 3*4 is incorrect");
    }
}
