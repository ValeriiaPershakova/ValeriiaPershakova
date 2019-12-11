package hw6.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPageButtons {
    @FindBy(xpath = "//*[@class='uui-button']")
    private List<WebElement> buttons;

    public int getAmount() {
        return buttons.size();
    }
}
