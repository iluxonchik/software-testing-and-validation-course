package ap;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
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


    /*
        For division tests, using DataProvider.
    */

    @DataProvider
    private Object[][] divisionDPOkay (){
        return new Object[][] {
                {new Calculator("Calc"), 4, 2, 2},
                {new Calculator("Calc"), 1, 2, 0},
                {new Calculator("Calc"), null, 1992, 0},
                {new Calculator("Calc"), -1 , 2, 0},
                {new Calculator("Calc"), 2 , -2, -1}
        };
    }

    @Test(dataProvider = "divisionDPOkay")
    public void testDivisionWithDPOkay(Calculator calc, Integer a, Integer b, Integer expected) {
        /*
            "mvn test" doesn't show with wich values the test failed, when using DataProviders.
            This "try/catch", combined with the error message in assertEquals() is a workaround for this.
        */
        try {
            Integer res = calc.divide(a, b);
            assertEquals(res, expected, "a = " + a + " b = " + b + " expected = " + expected);
        } catch (Throwable t) {
            fail("testDivisionWithDPOkay threw \"" + t.getClass().getCanonicalName() + "\" when called with arguments "
            + "a = " + a + " b = " + b + " expected = " + expected);
        }
    }

    @Test
    public void testDivisionByZero() {
        final int A = 4;
        final int B = 0;

        Calculator calc = new Calculator("Calc");
        try {
            int res = calc.divide(A, B);
            fail("Division by zero should've failed.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void testDivisionByZeroSecondArgNull() {
        final int A = 4;
        final Integer B = null;

        Calculator calc = new Calculator("Calc");
        try {
            int res = calc.divide(A, B);
            fail("Division by zero should've failed.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}