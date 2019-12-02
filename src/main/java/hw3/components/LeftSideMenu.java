package hw3.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LeftSideMenu {
    @FindBy(name = "navigation-sidebar")
    private WebElement leftSide;

    public WebElement getElement() {
        return leftSide;
    }
}
