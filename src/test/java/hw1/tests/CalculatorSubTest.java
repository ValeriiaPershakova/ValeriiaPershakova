package hw1.tests;

import hw1.data.CalculatorDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubTest extends AbstractBaseTest {
    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Sub Long Type Data", groups = {"sub"})
    public void subLongTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Sub Double Type Data", groups = {"sub"})
    public void subDoubleTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.0001);
    }
}
