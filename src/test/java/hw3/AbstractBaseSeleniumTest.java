package hw3;

import hw5.ex1.AttachmentListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners({AttachmentListener.class})
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

        WebDriverSingleton.INSTANCE.setDriver(driver);

    }


    @AfterMethod
    public void tearDown() {
        //17. Close Browser
        driver.close();
    }

}
