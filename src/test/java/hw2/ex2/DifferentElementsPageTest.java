package hw2.ex2;

import hw2.AbstractBaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DifferentElementsPageTest extends AbstractBaseSeleniumTest {
    //7. Open through the header menu Service -> Different Elements Page
    @Test
    public void openDifferentElementsPage() {
        WebElement serviceElement = driver.findElement(By.linkText("SERVICE"));
        serviceElement.click();
        driver.findElement(By.cssSelector(".dropdown-menu a[href='different-elements.html']")).click();
        assertEquals(driver.getCurrentUrl(),"https://epam.github.io/JDI/different-elements.html");
    }

    @Test(dependsOnMethods = "openDifferentElementsPage")
    public void differentElementsPageIsOpenTest() {

    }

    @Test(dependsOnMethods = "openDifferentElementsPage")
    public void pageElementsTest() {
      //8. Check interface on Different elements page, it contains all needed elements
        List<WebElement> checkBox = driver.findElements(By.cssSelector(".checkbox-row>label.label-checkbox"));
        List<WebElement> radio = driver.findElements(By.cssSelector(".checkbox-row>label.label-radio"));
        List<WebElement> dropDownMenu = driver.findElements(By.cssSelector(".main-content .uui-form-element"));
        List<WebElement> buttons = driver.findElements(By.xpath("//*[ends-with(@value='Button')]"));

    }
}
