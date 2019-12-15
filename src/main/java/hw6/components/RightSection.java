package hw6.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightSection {
    @FindBy(name = "log-sidebar")
    private WebElement rightSection;

    public WebElement getElement() {
        return rightSection;
    }
}
