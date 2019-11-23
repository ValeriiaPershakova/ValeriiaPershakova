package hw2.ex2;

import hw2.AbstractBaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceMenusTest extends AbstractBaseSeleniumTest {
    private List<String> dropDownMenuTexts = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLES WITH PAGES",
            "DIFFERENT ELEMENTS");
    @Test
    public void headerMenuTest() {
        //5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.linkText("SERVICE")).click();
        List<WebElement> dropDownMenu = driver.findElements(By.cssSelector("ul.dropdown-menu>li>a"));
        List<String> dropDownMenuTextActual = getTextFromWebElements(dropDownMenu);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dropDownMenu.size(),dropDownMenuTexts.size());
        softAssert.assertTrue(dropDownMenuTextActual.containsAll(dropDownMenuTexts));

        softAssert.assertAll();
    }

    @Test
    public void leftSideMenuTest() {
        //6. Click on Service subcategory in the left section and check that drop down contains options
        WebElement menuServiceElement = driver.findElement(By.xpath("//*[@class='sidebar-menu']//span[text()='Service']"));
        menuServiceElement.click();
        List<WebElement> dropDownMenu = menuServiceElement.findElements(By.xpath("//*[@class='sidebar-menu']//span[text()='Service']/parent::a/parent::li/child::ul/li"));
        List<String> dropDownMenuTextActual = getTextFromWebElements(dropDownMenu);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dropDownMenu.size(),dropDownMenuTexts.size());
        softAssert.assertTrue(dropDownMenuTextActual.containsAll(dropDownMenuTexts));

        softAssert.assertAll();
    }

    private List<String> getTextFromWebElements(List<WebElement> webElements) {
        List<String> textList = new ArrayList<>();
        for (WebElement element : webElements) {
            textList.add(element.getText());
        }
        return textList;
    }
}
