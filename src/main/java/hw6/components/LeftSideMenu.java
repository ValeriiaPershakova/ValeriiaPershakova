package hw6.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenu {
    @FindBy(name = "navigation-sidebar")
    private WebElement leftSide;

    public WebElement getElement() {
        return leftSide;
    }
}
