package hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;

public abstract class AbstractBaseTest {
    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 4000;
    }

    @AfterMethod
    public void tearDown() {
        close();
    }
}
