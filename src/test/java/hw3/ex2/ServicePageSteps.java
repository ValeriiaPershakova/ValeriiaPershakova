package hw3.ex2;

import hw3.AbstractBaseStep;
import hw3.elementsEnum.MenuElements;
import hw3.elementsEnum.MenuType;
import hw3.elementsEnum.ServiceMenuElements;
import hw3.pages.DifferentElementsPage;
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

    public void dropDownMenuShouldContainElements(MenuType menuType, ServiceMenuElements[] values) {
        List<String> dropDownMenuElementsActual = homePage.getServiceDropDownMenuElementsText(menuType);
        List<String> dropDownMenuElementsExpected = new ArrayList<>();
        for (ServiceMenuElements element : values) {
            dropDownMenuElementsExpected.add(element.getDescription());
        }
        assertTrue(dropDownMenuElementsActual.containsAll(dropDownMenuElementsExpected));
    }

    public void goTo(MenuElements menuElement) {
        homePage.goTo(menuElement);
        assertEquals(getCurrentURL(), menuElement.getUrl());
    }

    public void checkBoxArePresent(int amount) {
        softAssert.assertEquals(differentElementsPage.getCheckBoxesAmount(), amount);
    }

    public void radioButtonsArePresent(int amount) {
        softAssert.assertEquals(differentElementsPage.getRadioAmount(), amount);
    }

    public void dropDownMenuIsPresent(int amount) {
        softAssert.assertEquals(differentElementsPage.getDropDownMenuAmount(), amount);
    }

    public void buttonsArePresent(int amount) {
        softAssert.assertEquals(differentElementsPage.getButtonsAmount(), amount);
    }

    public void rightSectionIsPresent() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    public void leftSectionIsPresent() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    public void checkBoxSelected(String... attributes) {
        for (String attribute : attributes) {
            differentElementsPage.getCheckBox(attribute).click();
            softAssert.assertTrue(differentElementsPage.getCheckBox(attribute).isDisplayed());
            softAssert.assertTrue(differentElementsPage.getCheckBox(attribute).isSelected());
        }
    }

    public void checkBoxUnselected(String... attributes) {
        for (String attribute : attributes) {
            differentElementsPage.getCheckBox(attribute).click();
            softAssert.assertTrue(differentElementsPage.getCheckBox(attribute).isDisplayed());
            softAssert.assertFalse(differentElementsPage.getCheckBox(attribute).isSelected());
        }
    }

    public void logRowWork(String attribute, String value) {
        softAssert.assertTrue(differentElementsPage.getLogRow().isDisplayed());
        softAssert.assertTrue(differentElementsPage.logRowContains(attribute, value));
    }

    public void radioWork(String attribute) {
        differentElementsPage.getRadioElement(attribute).click();
        softAssert.assertTrue(differentElementsPage.getRadioElement(attribute).isDisplayed());
        softAssert.assertTrue(differentElementsPage.getRadioElement(attribute).isSelected());
    }

    public void dropDownMenuWork(String attribute) {
        differentElementsPage.getDropDownMenuElement(attribute).click();
        softAssert.assertTrue(differentElementsPage.getDropDownMenuElement(attribute).isDisplayed());
        softAssert.assertTrue(differentElementsPage.getDropDownMenuElement(attribute).isSelected());
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
