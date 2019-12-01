package hw3.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LeftSideMenu {
    @FindBy(name = "navigation-sidebar")
    private WebElement leftSide;
    @FindBy(how = How.CSS, using = "ul.sidebar-menu>li")
    private List<WebElement> leftSideMenuElements;

    public WebElement getElement() {
        return leftSide;
    }
}
