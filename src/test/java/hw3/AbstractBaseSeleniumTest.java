package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public abstract class AbstractBaseSeleniumTest {
    protected WebDriver driver;

    @BeforeSuite
    public void suiteSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(30000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDown() {
        //17. Close Browser
        driver.close();
    }

}
