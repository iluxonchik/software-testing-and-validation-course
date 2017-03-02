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
    public void testConstructorInvalidNameNull() {
        final String NAME = null;
        try {
            Calculator calc = new Calculator(NAME);
            fail("Null name not refused");
        } catch (IllegalArgumentException e) {
            // success
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

    @Test
    public void testGetName() {
        final String NAME = "Name";
        Calculator calc = new Calculator(NAME);
        assertEquals(calc.getName(), NAME, "Unexpected name");
    }

    @Test
    public void testSumBothPositive() {
        final int A = 1;
        final int B = 2;
        final int EXPECTED = 3;
        Calculator calc = new Calculator("Calc");
        int res = calc.sum(A, B);

        assertEquals(res, EXPECTED);
    }

    @Test
    public void testSumSecondArgNull() {
        final int A = 1;
        final Integer B = null;
        final int EXPECTED = 1;
        Calculator calc = new Calculator("Calc");
        int res = calc.sum(A, B);

        assertEquals(res, EXPECTED);
    }

    @Test
    public void testSumFirstArgNull() {
        final Integer A = null;
        final Integer B = 1;
        final int EXPECTED = 1;
        Calculator calc = new Calculator("Calc");
        int res = calc.sum(A, B);

        assertEquals(res, EXPECTED);
    }

    @Test
    public void testSumBothArgsNull() {
        final Integer A = null;
        final Integer B = null;
        final int EXPECTED = 0;
        Calculator calc = new Calculator("Calc");
        int res = calc.sum(A, B);

        assertEquals(res, EXPECTED);
    }

    @Test
    public void testSumBothNegative() {
        final int A = -1;
        final int B = -2;
        final int EXPECTED = -3;
        Calculator calc = new Calculator("Calc");
        int res = calc.sum(A, B);

        assertEquals(res, EXPECTED);
    }

    @Test
    public void testSumMixPositiveNegative() {
        final int A = -1;
        final int B = 2;
        final int EXPECTED = 1;
        Calculator calc = new Calculator("Calc");
        int res = calc.sum(A, B);

        assertEquals(res, EXPECTED);
    }

}