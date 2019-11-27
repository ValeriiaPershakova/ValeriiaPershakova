package hw2.ex2;

import hw2.AbstractBaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class ServiceMenusAndDifferentElementsPageTest extends AbstractBaseSeleniumTest {

    private List<String> dropDownServiceHeaderMenuElements = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE",
             "TABLE WITH PAGES", "DIFFERENT ELEMENTS" );

    @Test
    public void serviceMenuAndDifferentElementsPageTest() {
        SoftAssert softAssert = new SoftAssert();

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.linkText("SERVICE")).click();
        List<WebElement> dropDownHeaderMenu = driver.findElements(By.cssSelector("ul.dropdown-menu>li>a"));
        List<String> dropDownHeaderMenuTextActual = Utils.getTextFromWebElementsInUpperCase(dropDownHeaderMenu);


        softAssert.assertTrue(dropDownHeaderMenuTextActual.containsAll(dropDownServiceHeaderMenuElements));


        //6. Click on Service subcategory in the left section and check that drop down contains options
        WebElement menuServiceElement = driver.findElement(By.xpath("//ul[@class='sidebar-menu']//span[text()='Service']"));
        menuServiceElement.click();
        List<WebElement> dropDownLeftMenu = menuServiceElement.findElements(By.xpath("//*[@class='sidebar-menu']//span[text()='Service']/parent::a/parent::li/child::ul/li"));
        List<String> dropDownLeftMenuTextActual = Utils.getTextFromWebElementsInUpperCase(dropDownLeftMenu);

        softAssert.assertTrue(dropDownLeftMenuTextActual.containsAll(dropDownServiceHeaderMenuElements));


        //7. Open through the header menu Service -> Different Elements Page
        WebElement serviceElement = driver.findElement(By.linkText("SERVICE"));
        serviceElement.click();
        driver.findElement(By.xpath("//a[contains(text(),'Different elements')]")).click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/different-elements.html");


        //8. Check interface on Different elements page, it contains all needed elements
        List<WebElement> checkBox = driver.findElements(By.cssSelector(".checkbox-row>label.label-checkbox"));
        softAssert.assertTrue(checkBox.size() == 4);

        List<WebElement> radio = driver.findElements(By.cssSelector(".checkbox-row>label.label-radio"));
        softAssert.assertTrue(radio.size() == 4);

        List<WebElement> dropDownMenu = driver.findElements(By.cssSelector(".main-content .uui-form-element"));
        softAssert.assertTrue(dropDownMenu.size() == 1);

        List<WebElement> buttons = driver.findElements(By.xpath("//*[@class='uui-button']"));
        softAssert.assertTrue(buttons.size() == 2);

        //9. Assert that there is Right Section
        WebElement rightSide = driver.findElement(By.name("log-sidebar"));
        softAssert.assertTrue(rightSide.isDisplayed());

        //10. Assert that there is Left Section
        WebElement leftSide = driver.findElement(By.name("navigation-sidebar"));
        softAssert.assertTrue(leftSide.isDisplayed());

        //11. Select checkboxes
        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.

        WebElement logRow = driver.findElement(By.cssSelector(".info-panel-body.info-panel-body-log"));

        WebElement waterCheckBox = driver.findElement(By.cssSelector(".checkbox-row>label.label-checkbox:nth-child(1) input"));
        waterCheckBox.click();
        WebElement waterLog = logRow.findElement(By.xpath("//li[contains(text(),'Water')]"));
        softAssert.assertTrue(waterLog.isDisplayed());
        softAssert.assertTrue(waterCheckBox.isSelected());
        softAssert.assertTrue(waterLog.getText().contains("true"));

        WebElement windCheckBox = driver.findElement(By.cssSelector(".checkbox-row>label.label-checkbox:nth-child(3) input"));
        windCheckBox.click();
        WebElement windLog = logRow.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        softAssert.assertTrue(windLog.isDisplayed());
        softAssert.assertTrue(windCheckBox.isSelected());
        softAssert.assertTrue(windLog.getText().contains("true"));


        //13. Select radio
        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        WebElement selenRadio = driver.findElement(By.cssSelector(".checkbox-row>label.label-radio:nth-child(4) input"));
        selenRadio.click();
        softAssert.assertTrue(selenRadio.isSelected());
        softAssert.assertTrue(selenRadio.isDisplayed());
        WebElement radioLog = logRow.findElement(By.xpath("//li[contains(text(),'metal')]"));
        softAssert.assertTrue(radioLog.getText().contains("Selen"));


        //15. Select in dropdown
        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.

        WebElement yellowColorsDropDown = driver.findElement(By.xpath("//option[contains(text(),'Yellow')]"));
        yellowColorsDropDown.click();
        softAssert.assertTrue(yellowColorsDropDown.isSelected());
        softAssert.assertTrue(yellowColorsDropDown.isDisplayed());

        WebElement colorLog = logRow.findElement(By.xpath("//li[contains(text(),'Colors')]"));
        softAssert.assertTrue(colorLog.getText().contains(yellowColorsDropDown.getText()));


        //17. Unselect and assert checkboxes
        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        waterCheckBox.click();
        waterLog = logRow.findElement(By.xpath("//li[contains(text(),'Water')]"));
        softAssert.assertTrue(waterLog.isDisplayed());
        softAssert.assertFalse(waterCheckBox.isSelected());
        softAssert.assertTrue(waterLog.getText().contains("false"));

        windCheckBox.click();
        windLog = logRow.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        softAssert.assertTrue(windLog.isDisplayed());
        softAssert.assertFalse(windCheckBox.isSelected());
        softAssert.assertTrue(windLog.getText().contains("false"));

        softAssert.assertAll();
    }
}
