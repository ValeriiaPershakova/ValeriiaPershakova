package hw1.tests;

import hw1.data.CalculatorDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivTest extends AbstractBaseTest {
    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Div Long Type Correct Data", groups = {"div"})
    public void divLongCorrectDataTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Div Double Type Correct Data", groups = {"div"})
    public void divDoubleCorrectDataTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.00001);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Div Long Type Incorrect Data", groups = {"div"},
            expectedExceptions = NumberFormatException.class)
    public void divLongIncorrectDataTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "Div Double Type Incorrect Data", groups = {"div"},
            expectedExceptions = NumberFormatException.class)
    public void divDoubleIncorrectDataTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
    }
}
