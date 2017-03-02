package ap;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TestCalculator {
    @Test
    public void testConstructorValidName() {
        final String NAME = "The";
        try {
            Calculator calc = new Calculator(NAME);
            assertEquals(calc.getName(), NAME, "Unexpected name");
        } catch (IllegalArgumentException e) {
            fail("Error while instantiating Calculator");
        }
    }

    @Test
    public void testConstructorValidNameTwoCharacters() {
        final String NAME = "Th";
        try {
            Calculator calc = new Calculator(NAME);
            assertEquals(calc.getName(), NAME, "Unexpected name");
        } catch (IllegalArgumentException e) {
            fail("Error while instantiating Calculator");
        }
    }

    @Test
    public void testConstructorValidNameFiveCharacters() {
        final String NAME = "The D";
        try {
            Calculator calc = new Calculator(NAME);
            assertEquals(calc.getName(), NAME, "Unexpected name");
        } catch (IllegalArgumentException e) {
            fail("Error while instantiating Calculator");
        }
    }

    @Test
    public void testConstructorInvalidNameLessThanTwo() {
        final String NAME = "T";
        try {
            Calculator calc = new Calculator(NAME);
            fail("Name should've been refused: name shorter than 2 characters");
        } catch(IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void testConstructorInvalidNameMoreThanFive() {
        final String NAME = "The Documentary";
        try {
            Calculator calc = new Calculator(NAME);
            fail("Name should've been refused: name longer than 5 characters");
        } catch(IllegalArgumentException e) {
            // success
        }
    }

}