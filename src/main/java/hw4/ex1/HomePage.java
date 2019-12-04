package hw4.ex1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.common.elementsEnum.MenuElements;
import hw4.common.elementsEnum.MenuType;
import hw4.common.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public static final String URL = "https://epam.github.io/JDI/index.html";


    @FindBy(id = "user-name")
    private SelenideElement userName;
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private SelenideElement serviceElementFromHeaderMenu;

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

    public ElementsCollection serviceDropDownMenu(MenuType menuType) {
        switch (menuType) {
            case HEADER: {
                serviceElementFromHeaderMenu.click();
                return $$("ul.dropdown-menu>li>a");
            }
            case LEFT_SIDE: {
                $(By.xpath("//span[text()='Service']")).click();
                return $$(By.xpath("//*[@class='sidebar-menu']//span[text()='Service']/parent::a/parent::li/child::ul/li"));
            }
            default: {
                throw new RuntimeException("no such Menu Type");
            }
        }

    }

    public SelenideElement title() {
        return $("title");
    }

    public void goTo(MenuElements menuElement) {
        switch (menuElement) {
            case HOME:
            case CONTACT_FORM:
            case METALS_COLORS: {
                $(By.xpath("//a[contains(text(),'" + Utils.toNormalCase(menuElement.getDescription()) + "')]")).click();
                break;
            }
            default: {
                serviceElementFromHeaderMenu.click();
                $(By.xpath("//a[contains(text(),'" + Utils.toNormalCase(menuElement.getDescription()) + "')]")).click();
                break;
            }
        }
    }
}
