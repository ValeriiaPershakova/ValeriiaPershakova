package hw3.ex2;

import hw3.elementsEnum.MenuElements;
import hw3.elementsEnum.MenuType;
import hw3.elementsEnum.ServiceMenuElements;
import hw3.pages.DifferentElementsPage;
import hw3.AbstractBaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static hw3.pages.AbstractBasePage.getCurrentURL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ServicePageSteps extends AbstractBaseStep {
    private DifferentElementsPage differentElementsPage;
    public SoftAssert softAssert;

    public ServicePageSteps(WebDriver driver) {
        super(driver);
        this.differentElementsPage = new DifferentElementsPage(driver);
        softAssert = new SoftAssert();
    }

    @Step("Assertion that '{0}' Service drop down menu contains all the elements: '{1}'")
    public void dropDownMenuShouldContainElements(MenuType menuType, ServiceMenuElements[] values) {
        List<String> dropDownMenuElementsActual = homePage.getServiceDropDownMenuElementsText(menuType);
        List<String> dropDownMenuElementsExpected = new ArrayList<>();
        for (ServiceMenuElements element : values) {
            dropDownMenuElementsExpected.add(element.getDescription());
        }
        assertTrue(dropDownMenuElementsActual.containsAll(dropDownMenuElementsExpected));
    }

    @Step("I go to '{0}' by Header menu")
    public void goTo(MenuElements menuElement) {
        homePage.goTo(menuElement);
        assertEquals(getCurrentURL(), menuElement.getUrl());
    }

    @Step("Assertion that There are '{0}' check boxes on the Different Elements Page")
    public void checkBoxArePresent(int amount) {
        softAssert.assertEquals(differentElementsPage.getCheckBoxesAmount(), amount);
    }

    @Step("Assertion that There are '{0}' radio button on the Different Elements Page")
    public void radioButtonsArePresent(int amount) {
        softAssert.assertEquals(differentElementsPage.getRadioAmount(), amount);
    }

    @Step("Assertion that There are '{0}' drop down menus on the Different Elements Page")
    public void dropDownMenuIsPresent(int amount) {
        softAssert.assertEquals(differentElementsPage.getDropDownMenuAmount(), amount);
    }

    @Step("Assertion that There are '{0}' buttons on the Different Elements Page")
    public void buttonsArePresent(int amount) {
        softAssert.assertEquals(differentElementsPage.getButtonsAmount(), amount);
    }

    @Step("Assertion that the Right section is present on the Different Elements Page")
    public void rightSectionIsPresent() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Step("Assertion that the Left section is present on the Different Elements Page")
    public void leftSectionIsPresent() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Step("I select '{0}' checkboxes, they are displayed")
    public void checkBoxSelected(String... attributes) {
        for (String attribute : attributes) {
            differentElementsPage.getCheckBox(attribute).click();
            softAssert.assertTrue(differentElementsPage.getCheckBox(attribute).isDisplayed());
            softAssert.assertTrue(differentElementsPage.getCheckBox(attribute).isSelected());
        }
    }

    @Step("I unselect '{0}' checkboxes")
    public void checkBoxUnselected(String... attributes) {
        for (String attribute : attributes) {
            differentElementsPage.getCheckBox(attribute).click();
            softAssert.assertTrue(differentElementsPage.getCheckBox(attribute).isDisplayed());
            softAssert.assertFalse(differentElementsPage.getCheckBox(attribute).isSelected());
        }
    }

    @Step("Assertion that the Logrow contains expected attribute '{0}' and value '{1}'")
    public void logRowWork(String attribute, String value) {
        softAssert.assertTrue(differentElementsPage.getLogRow().isDisplayed());
        softAssert.assertTrue(differentElementsPage.logRowContains(attribute, value));
    }

    @Step("I select '{0}' radio button")
    public void radioWork(String attribute) {
        differentElementsPage.getRadioElement(attribute).click();
        softAssert.assertTrue(differentElementsPage.getRadioElement(attribute).isDisplayed());
        softAssert.assertTrue(differentElementsPage.getRadioElement(attribute).isSelected());
    }

    @Step("I select '{0}' from the drop down menu on the Different Elements Page")
    public void dropDownMenuWork(String attribute) {
        differentElementsPage.getDropDownMenuElement(attribute).click();
        softAssert.assertTrue(differentElementsPage.getDropDownMenuElement(attribute).isDisplayed());
        softAssert.assertTrue(differentElementsPage.getDropDownMenuElement(attribute).isSelected());
    }

    @Step("I summarize all the assertion")
    public void assertAll() {
        softAssert.assertAll();
    }
}
