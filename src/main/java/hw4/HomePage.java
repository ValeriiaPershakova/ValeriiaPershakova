package hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    public static final String URL = "https://epam.github.io/JDI/index.html";

    @FindBy(id = "user-name")
    private SelenideElement userName;

    public HomePage() {
        page(this);
    }

    public void login(String login, String password) {
        $("#user-icon").click();
        $("#name").setValue(login);
        $("#password").setValue(password);
        $("#login-button").click();
    }
    public SelenideElement userName() {
        return userName;
    }
}
