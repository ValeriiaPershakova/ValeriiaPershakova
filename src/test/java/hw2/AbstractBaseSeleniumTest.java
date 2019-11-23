package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public abstract class AbstractBaseSeleniumTest {
    protected WebDriver driver;
    protected Dimension windowSize;
    protected String[] menu = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    protected Map<String, String> benefitIcons = new HashMap<>();

    {
        benefitIcons.put("icons-benefit icon-practise", "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        benefitIcons.put("icons-benefit icon-custom", "To be flexible and\n" +
                "customizable");
        benefitIcons.put("icons-benefit icon-multi", "To be multiplatform");
        benefitIcons.put("icons-benefit icon-base", "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
//        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MICROSECONDS);
//        driver.manage().timeouts().setScriptTimeout(30000, TimeUnit.MICROSECONDS);
        driver.manage().window().maximize();
        //1. Open test site by URL
        driver.get("https://epam.github.io/JDI/index.html");
        windowSize = driver.manage().window().getSize();
    }

    @AfterClass
    public void tearDown() {
        //17. Close Browser
        driver.close();
    }
    @Test(priority = 0)
    public void loginTest() {

        //2. Assert Browser Title
        assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        //4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");
    }
}
