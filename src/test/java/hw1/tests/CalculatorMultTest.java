package hw1.tests;

import hw1.data.CalculatorDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultTest extends AbstractBaseTest {
    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Mult Long Type Data", groups = {"mult"})
    public void multLongTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Mult Double Type Data", groups = {"mult"})
    public void multDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.0001);
    }
}
