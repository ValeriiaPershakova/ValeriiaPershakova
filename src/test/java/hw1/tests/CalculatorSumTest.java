package hw1.tests;

import hw1.data.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractBaseTest {
    @Test(groups = {"sum"}, dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sum Long Type Data" )
    public void sumLongTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @Test(groups = {"sum"}, dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Sum Double Type Data")
    public void sumDoubleTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.0001);
    }

}
