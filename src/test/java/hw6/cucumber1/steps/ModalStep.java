package hw6.cucumber1.steps;

import cucumber.api.java.en.Given;
import hw6.cucumber1.storages.UserStorage;
import hw6.cucumber1.storages.WebDriverSingleton;
import hw6.pages.DifferentElementsPage;
import hw6.pages.HomePage;
import hw6.utils.Utils;
import org.openqa.selenium.support.PageFactory;

public class ModalStep extends AbstractBaseStep {
    @Given("^I open JDI Site$")
    public void iOpenJdiSite() {
        homePage = PageFactory.initElements(WebDriverSingleton.INSTANCE.getDriver(), HomePage.class);
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.open("https://epam.github.io/JDI/index.html");
    }

    @Given("^I am on \"Home Page\"$")
    public void iAmOnHomePage() {
        iOpenJdiSite();
    }

    @Given("^I login as user '([^\"]+)'$")
    public void iLoginAsUser(String userName) {
        UserStorage user = UserStorage.valueOf(Utils.toEnumFormat(userName));
        String login = user.getLogin();
        String password = user.getPassword();
        homePage.userIconClick();
        homePage.setTextUsernameTextField(login);
        homePage.setTextPasswordTextField(password);
        homePage.clickLoginButton();
    }
}

