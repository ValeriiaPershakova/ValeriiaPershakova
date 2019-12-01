package hw3;

import hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public abstract class AbstractBaseStep {
    protected HomePage homePage;

    protected AbstractBaseStep(WebDriver driver) {
        this.homePage = PageFactory.initElements(driver, HomePage.class);
    }
    public void openJDISite(String url) {
        homePage.open(url);
    }

    public void browserTitleShouldBe(String title) {
        assertEquals(homePage.getPageTitle(), title);
    }

    public void login(String login, String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(login);
        homePage.setTextPasswordTextField(password);
        homePage.clickLoginButton();
    }

    public void userNameShouldBe(String name) {
        assertEquals(homePage.getUsernameLabelText(), name);
    }

}
