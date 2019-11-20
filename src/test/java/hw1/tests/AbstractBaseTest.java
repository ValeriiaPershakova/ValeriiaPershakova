package hw1.tests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public abstract class AbstractBaseTest {
    protected Calculator calculator;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
