package hw6.pages;

import hw6.elementsEnum.MenuElements;
import hw6.elementsEnum.MenuType;
import hw6.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.How.CSS;

public class HomePage extends AbstractBasePage {
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernameLabel;

    @FindBy(how = CSS, using = ".uui-navigation.nav.navbar-nav.m-l8")
    private WebElement headerMenu;

    @FindBy(how = CSS, using = ".uui-navigation.nav.navbar-nav.m-l8>li")
    private List<WebElement> headerMenuElements;

    @FindBy(className = "benefit")
    private List<WebElement> imagesText;

    @FindBy(name = "main-title")
    private WebElement mainTitle;

    @FindBy(name = "jdi-text")
    private WebElement mainText;

    @FindBy(id = "iframe")
    private WebElement frame;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy(how = CSS, using = "h3.text-center>a")
    private WebElement subHeader;

    @FindBy(className = "sidebar-menu")
    private WebElement leftMenu;

    @FindBy(how = CSS, using = "div.footer-bg>div")
    private WebElement footer;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void open(String URL) {
        driver.get(URL);
    }

    public void userIconClick() {
        userIcon.click();
    }

    public void setTextUsernameTextField(String username) {
        nameField.sendKeys(username);
    }

    public void setTextPasswordTextField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }


    public List<WebElement> getHeaderMenuElements() {
        return headerMenuElements;
    }

    public List<WebElement> getImages() {
        List<WebElement> images = new ArrayList<>();
        for (WebElement element : imagesText) {
            images.add(element.findElement(By.className("benefit-icon")));
        }
        return images;
    }

    public List<WebElement> getTextElementsUnderImages() {
        List<WebElement> textUnderImages = new ArrayList<>();
        for (WebElement element : imagesText) {
            textUnderImages.add(element.findElement(By.className("benefit-txt")));
        }
        return textUnderImages;
    }

    public String getImageClass(int i) {
        return getImages().get(i).findElement(By.cssSelector("span")).getAttribute("class");
    }

    public WebElement getMainTitle() {
        return mainTitle;
    }

    public WebElement getMainText() {
        return mainText;
    }

    public WebElement getIframe() {
        return frame;
    }

    public void switchToIframe() {
        driver.switchTo().frame(frame);
    }

    public WebElement getLogo() {
        return epamLogo;
    }

    public void switchToOriginalPage() {
        driver.switchTo().defaultContent();
    }

    public String getSubHeaderText() {
        return subHeader.getText();
    }

    public String getSubHeaderLink() {
        return subHeader.getAttribute("href");
    }

    public WebElement getLeftMenu() {
        return leftMenu;
    }

    public WebElement getFooter() {
        return footer;
    }

    public List<String> getServiceDropDownMenuElementsText(MenuType menuType) {
        List<String> dropDownMenuElementsText = new ArrayList<>();
        switch (menuType) {
            case HEADER: {
                List<WebElement> dropDownHeaderMenu = headerMenu.findElements(By.cssSelector("ul.dropdown-menu>li>a"));
                dropDownMenuElementsText = Utils.getTextFromWebElementsInUpperCase(dropDownHeaderMenu);
                break;
            }
            case LEFT_SIDE: {
                WebElement menuServiceElement = leftMenu.findElement(By.xpath("//span[text()='Service']"));
                List<WebElement> dropDownLeftMenu = menuServiceElement.findElements(By.xpath("//*[@class='sidebar-menu']//span[text()='Service']/parent::a/parent::li/child::ul/li"));
                dropDownMenuElementsText = Utils.getTextFromWebElementsInUpperCase(dropDownLeftMenu);
                break;
            }
        }
        return dropDownMenuElementsText;
    }

    public void goTo(MenuElements menuElement) {
        switch (menuElement) {
            case COMPLEX_TABLE:
            case SIMPLE_TABLE:
            case USER_TABLE: {
                headerMenu.findElement(By.xpath("//a[contains(text(),'" + Utils.toTitleCase(menuElement.getDescription()) + "')]")).click();
                break;
            }
            default: {
                headerMenu.findElement(By.xpath("//a[contains(text(),'" + Utils.toNormalCase(menuElement.getDescription()) + "')]")).click();
                break;
            }
        }

    }

    public void menuClick(String elementName, MenuType menuType) {
        switch (menuType) {
            case HEADER: {
                headerMenu.findElement(By.xpath("//a[contains(text(),'" + Utils.toNormalCase(elementName) + "')]")).click();
                break;
            }
            case LEFT_SIDE: {
                leftMenu.findElement(By.xpath("//span[text()='" + Utils.toNormalCase(elementName) + "']")).click();
            }
        }
    }
}
