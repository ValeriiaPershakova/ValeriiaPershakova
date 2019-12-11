package hw6.cucumber1.steps;

import cucumber.api.java.en.When;
import hw6.cucumber1.storages.TestStorage;
import hw6.elementsEnum.MenuElements;
import hw6.elementsEnum.MenuType;
import hw6.utils.Utils;

import java.util.List;

public class ActionStep extends AbstractBaseStep {
    @When("^I login as user '([^\"]+)' with password '([^\"]+)' on the Home Page$")
    public void iLoginAsUserWithPasswordOnTheHomePage(String username, String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(username);
        homePage.setTextPasswordTextField(password);
        homePage.clickLoginButton();
    }

    @When("^I click on '([^\"]+)' button in the '([^\"]+)' Menu$")
    public void iClickOnElementInTheMenu(String elementName, String menuType) {
        homePage.menuClick(elementName, MenuType.valueOf(Utils.toEnumFormat(menuType)));
    }

    @When("^I click on '([^\"]+)' button in Service dropdown$")
    public void iGoToPageFromHomePage(String menuElement) {
        homePage.goTo(MenuElements.valueOf(Utils.toEnumFormat(menuElement)));
    }

    @When("^I click on '(.*)' checkboxes on the Different Elements page$")
    public void iClickOnCheckBoxesOnTheDifferentElementsPage(List<String> attributes) {
        for (String attribute : attributes) {
            differentElementsPage.getCheckBox(Utils.toNormalCase(attribute)).click();
        }
    }
    @When("^I click on '([^\"]+)' radio button on the Different Elements page$")
    public void iClickOnRadioButtonOnTheDifferentElementsPage(String radioButton) {
        differentElementsPage.getRadioElement(radioButton).click();
    }
    @When("^I select '([^\"]+)' element in the drop down menu on the Different Elements page$")
    public void iSelectElementInTheDropDownMenuOnTheDifferentElementsPage(String element) {
        differentElementsPage.getDropDownMenuElement(element).click();
    }
    @When("^I select 'vip' checkbox for '([^\"]+)'$")
    public void iSelectVipCheckBoxForUserOnUserTablePage(String username) {
        userTablePage.selectCheckboxByName(username);
    }
    @When("^I click on dropdown in column Type for user '([^\"]+)'$")
    public void iClickOnDropdownForUser(String username) {
        userTablePage.clickOnDropdownForUser(username);
        TestStorage.INSTANCE.setData("username_for_dropdown", username);
    }

}
