package hw2.ex2;

import hw2.AbstractBaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageTest extends AbstractBaseSeleniumTest {

    @Test
    public void openDifferentElementsPage() {
        //7. Open through the header menu Service -> Different Elements Page
        WebElement serviceElement = driver.findElement(By.linkText("SERVICE"));
        serviceElement.click();
        driver.findElement(By.xpath("//a[contains(text(),'Different elements')]")).click();
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/different-elements.html");
    }

    //8. Check interface on Different elements page, it contains all needed elements
    @Test(dependsOnMethods = "openDifferentElementsPage")
    public void checkBoxIsPresentTest() {
        List<WebElement> checkBox = driver.findElements(By.cssSelector(".checkbox-row>label.label-checkbox"));
        assertTrue(checkBox.size() == 4);
    }

    @Test(dependsOnMethods = "openDifferentElementsPage")
    public void radioIsPresentTest() {
        List<WebElement> radio = driver.findElements(By.cssSelector(".checkbox-row>label.label-radio"));
        assertTrue(radio.size() == 4);
    }

    @Test(dependsOnMethods = "openDifferentElementsPage")
    public void dropDownMenuIsPresentTest() {
        List<WebElement> dropDownMenu = driver.findElements(By.cssSelector(".main-content .uui-form-element"));
        assertTrue(dropDownMenu.size() == 1);
    }

    @Test(dependsOnMethods = "openDifferentElementsPage")
    public void buttonsArePresentTest() {
        List<WebElement> buttons = driver.findElements(By.xpath("//*[contains(@value,'Button')]"));
        assertTrue(buttons.size() == 2);
    }


    @Test(dependsOnMethods = "openDifferentElementsPage")
    public void rightSideTest() {
        //9. Assert that there is Right Section
        WebElement rightSide = driver.findElement(By.name("log-sidebar"));
        assertTrue(rightSide.isDisplayed());
    }

    @Test(dependsOnMethods = "openDifferentElementsPage")
    public void leftSideTest() {
        //10. Assert that there is Left Section
        WebElement leftSide = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(leftSide.isDisplayed());
    }

    @Test(dependsOnMethods = "checkBoxIsPresentTest", invocationCount = 2)
    public void checkBoxTest() {
        //11. Select checkboxes
        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        //16. Unselect and assert checkboxes
        //17. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.

        SoftAssert softAssert = new SoftAssert();
        WebElement logRow = driver.findElement(By.cssSelector(".info-panel-body.info-panel-body-log"));

        WebElement waterCheckBox = driver.findElement(By.cssSelector(".checkbox-row>label.label-checkbox:nth-child(1) input"));
        boolean waterCheckBoxInitState = waterCheckBox.isSelected();
        waterCheckBox.click();
        WebElement waterLog = logRow.findElement(By.xpath("//li[contains(text(),'Water')]"));
        softAssert.assertTrue(waterLog.isDisplayed());
        softAssert.assertTrue(waterCheckBox.isSelected() == !waterCheckBoxInitState);
        softAssert.assertTrue(waterLog.getText().contains(String.valueOf(!waterCheckBoxInitState)));


        WebElement windCheckBox = driver.findElement(By.cssSelector(".checkbox-row>label.label-checkbox:nth-child(3) input"));
        boolean windCheckBoxInitState = windCheckBox.isSelected();
        windCheckBox.click();
        WebElement windLog = logRow.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        softAssert.assertTrue(windLog.isDisplayed());
        softAssert.assertTrue(windCheckBox.isSelected()==!windCheckBoxInitState);
        softAssert.assertTrue(windLog.getText().contains(String.valueOf(!waterCheckBoxInitState)));

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "radioIsPresentTest")
    public void metalRadioTest() {
        //13. Select radio
        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        SoftAssert softAssert = new SoftAssert();
        WebElement logRow = driver.findElement(By.cssSelector(".info-panel-body.info-panel-body-log"));

        WebElement selenRadio = driver.findElement(By.cssSelector(".checkbox-row>label.label-radio:nth-child(4) input"));
        selenRadio.click();
        System.out.println(selenRadio.getText());
        softAssert.assertTrue(selenRadio.isSelected());
        softAssert.assertTrue(selenRadio.isDisplayed());
        WebElement radioLog = logRow.findElement(By.xpath("//li[contains(text(),'metal')]"));
        softAssert.assertTrue(radioLog.getText().contains("Selen"));

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "dropDownMenuIsPresentTest")
    public void colorsDropDownTest() {
        //15. Select in dropdown
        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        SoftAssert softAssert = new SoftAssert();
        WebElement logRow = driver.findElement(By.cssSelector(".info-panel-body.info-panel-body-log"));

        WebElement yellowColorsDropDown = driver.findElement(By.xpath("//option[contains(text(),'Yellow')]"));
        yellowColorsDropDown.click();
        softAssert.assertTrue(yellowColorsDropDown.isSelected());
        softAssert.assertTrue(yellowColorsDropDown.isDisplayed());

        WebElement colorLog = logRow.findElement(By.xpath("//li[contains(text(),'Colors')]"));
        softAssert.assertTrue(colorLog.getText().contains(yellowColorsDropDown.getText()));
        System.out.println(yellowColorsDropDown.getText());

        softAssert.assertAll();
    }

}
