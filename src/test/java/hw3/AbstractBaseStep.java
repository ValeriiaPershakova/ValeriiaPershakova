package hw3;

import hw3.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public abstract class AbstractBaseStep {
    protected HomePage homePage;

    protected AbstractBaseStep(WebDriver driver) {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Step("I open JDI Site by URL: '{0}'")
    public void openJDISite(String url) {
        homePage.open(url);
    }

    @Step("I assert title of the Home page")
    public void browserTitleShouldBe(String title) {
        assertEquals(homePage.getPageTitle(), title);
    }

    @Step("I login as '{0}' with password '{1}'")
    public void login(String login, String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(login);
        homePage.setTextPasswordTextField(password);
        homePage.clickLoginButton();
    }

    @Step("I assert that I logined as '{0}'")
    public void userNameShouldBe(String name) {
        assertEquals(homePage.getUsernameLabelText(), name);
    }

}
