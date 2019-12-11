package hw6.cucumber1.steps;

import cucumber.api.java.en.Then;
import hw6.UserTablePage;
import hw6.cucumber1.storages.TestStorage;
import hw6.cucumber1.storages.WebDriverSingleton;
import hw6.elementsEnum.MenuElements;
import hw6.elementsEnum.ServiceMenuElements;
import hw6.elementsEnum.MenuType;
import hw6.pages.AbstractBasePage;
import hw6.utils.Utils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;


public class AssertionStep extends AbstractBaseStep {
    @Then("^page title is '([^\"]+)'$")
    public void pageTitleIs(String expectedTitle) {
        assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    @Then("^username should be '([^\"]+)' on the Home page$")
    public void usernameShouldBeOnTheHomePage(String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    @Then("^Home Page should contain all elements$")
    public void homePageShouldContainAllElements() {
        //4 images
        for (WebElement element : homePage.getImages()) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(homePage.getImages().size(), 4);

        //text under images
        for (WebElement element : homePage.getTextElementsUnderImages())
            assertTrue(element.isDisplayed());

        //2 text above
        assertTrue(homePage.getMainTitle().isDisplayed());
        assertTrue(homePage.getMainText().isDisplayed());
    }

    @Then("^service drop down menu in '([^\"]+)' menu should contain all elements$")
    public void serviceDropDownMenuShouldContainAllElements(String menuType) {
        MenuType type = MenuType.valueOf(Utils.toEnumFormat(menuType));
        List<String> dropDownMenuElementsActual = homePage.getServiceDropDownMenuElementsText(type);
        List<String> dropDownMenuElementsExpected = new ArrayList<>();
        for (ServiceMenuElements element : ServiceMenuElements.values()) {
            dropDownMenuElementsExpected.add(element.getDescription());
        }
        assertTrue(dropDownMenuElementsActual.containsAll(dropDownMenuElementsExpected),
                String.format("Service Drop down menu in %s menu doesn't contain all elements", menuType));
    }

    @Then("^'([^\"]+)' page is opened$")
    public void pageIsOpened(String pageName) {
        String expectedUrl = MenuElements.valueOf(Utils.toEnumFormat(pageName)).getUrl();
        assertEquals(AbstractBasePage.getCurrentURL(), expectedUrl);
    }

    @Then("^Different elements page should contain all elements$")
    public void differentElementsPageShouldContainAllElements() {
        //4 check boxes
        assertEquals(differentElementsPage.getCheckBoxesAmount(), 4);
        //4 radio buttons
        assertEquals(differentElementsPage.getRadioAmount(), 4);
        //1 dropdown menu
        assertEquals(differentElementsPage.getDropDownMenuAmount(), 1);
        //2 buttons
        assertEquals(differentElementsPage.getButtonsAmount(), 2);
    }

    @Then("^Different elements page should contain Right Section$")
    public void differentElementsPageShouldContainRightSection() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("^Different elements page should contain Left Section$")
    public void differentElementsPageShouldContainLeftSection() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Then("^checkboxes '(.*)' should be selected on the Different Elements page$")
    public void checkboxesShouldBeSelectedOnTheDifferentElementsPage(List<String> attributes) {
        for (String attribute : attributes) {
            assertTrue(differentElementsPage.getCheckBox(attribute).isDisplayed());
            assertTrue(differentElementsPage.getCheckBox(attribute).isSelected());
        }
    }

    @Then("^logrow should have '(.*)' on the Different Elements page$")
    public void logrowShouldHaveValuesOnTheDifferentElementsPage(List<String> values) {
        assertTrue(differentElementsPage.getLogRow().isDisplayed());
        assertTrue(differentElementsPage.logRowContains(values.get(0), values.get(1)));
    }

    @Then("^radio '([^\"]+)' should be selected on the Different Elements page$")
    public void radioButtonShouldBeSelectedOnTheDifferentElementsPage(String radioButton) {
        assertTrue(differentElementsPage.getRadioElement(radioButton).isDisplayed());
        assertTrue(differentElementsPage.getRadioElement(radioButton).isSelected());
    }

    @Then("^element '([^\"]+)' in the drop down menu should be selected on the Different Elements page$")
    public void dropDownElementShouldBeSelectedOnTheDifferentElementsPage(String element) {
        assertTrue(differentElementsPage.getDropDownMenuElement(element).isDisplayed());
        assertTrue(differentElementsPage.getDropDownMenuElement(element).isSelected());
    }

    @Then("^checkboxes '(.*)' should be unselected on the Different Elements page$")
    public void checkboxesShouldBeUnselectedOnTheDifferentElementsPage(List<String> attributes) {
        for (String attribute : attributes) {
            assertTrue(differentElementsPage.getCheckBox(attribute).isDisplayed());
            assertFalse(differentElementsPage.getCheckBox(attribute).isSelected());
        }
    }

    @Then("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numberTypeDropdownAreDisplayedOnUserTablePage(int expectedValue) {
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getDropdownsAmount(), expectedValue);
        for (WebElement element : userTablePage.getDropdowns()) {
            assertTrue(element.isDisplayed());
        }
    }

    @Then("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUserTablePage(int expectedValue) {
        assertEquals(userTablePage.getUserNamesAmount(), expectedValue);
        for (WebElement element : userTablePage.getUserNames()) {
            assertTrue(element.isDisplayed());
        }
    }

    @Then("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void discriptionImagesAreDisplayedOnUserTablePage(int expectedValue) {
        assertEquals(userTablePage.getDiscriptionImagesAmount(), expectedValue);
        for (WebElement element : userTablePage.getDiscriptionImages()) {
            assertTrue(element.isDisplayed());
        }
    }

    @Then("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void discriptionTextesAreDisplayedOnUserTablePage(int expectedValue) {
        assertEquals(userTablePage.getDiscriptionTextsAmount(), expectedValue);
        for (WebElement element : userTablePage.getDiscriptionTexts()) {
            assertTrue(element.isDisplayed());
        }
    }
    @Then("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUserTablePage(int expectedValue) {
        assertEquals(userTablePage.getCheckboxesAmount(), expectedValue);
        for (WebElement element : userTablePage.getCheckboxes()) {
            assertTrue(element.isDisplayed());
        }
    }
    @Then("^User table contains following values:$")
    public void userTableContainsValues(List<Map<String,String>> values) {
        for (int i = 0; i < userTablePage.getLines().size(); i++) {
            for (String key : userTablePage.getLines().get(i).keySet()) {
                assertEquals(userTablePage.getLines().get(i).get(key),values.get(i).get(key));
            }
        }
    }
    @Then("^1 log row has '([^\"]+)' text in log section$")
    public void logRowHasText(String expectedLog) {
        assertTrue(userTablePage.logRowHasText(expectedLog));
    }
    @Then("^droplist contains values$")
    public void droplistContains(List<Map<String,String>> expectedValues) {
        WebElement line = userTablePage.getLineByName(TestStorage.INSTANCE.getData("username_for_dropdown"));
        List<String> expectedTexts = new ArrayList<>();
        for (Map<String, String> map : expectedValues) {
            for (String key : map.keySet()) {
                expectedTexts.add(map.get(key));
            }
        }
        List<String> actualTexts = userTablePage.getDropdownOptionsByUsername(TestStorage.INSTANCE.getData("username_for_dropdown"));
        assertTrue(actualTexts.containsAll(expectedTexts));
    }


}
