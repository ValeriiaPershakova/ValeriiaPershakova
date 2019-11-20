package hw1.tests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public abstract class AbstractBaseTest {
    protected Calculator calculator;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println("Before Groups");
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("After Groups");
        calculator = null;
    }
}
