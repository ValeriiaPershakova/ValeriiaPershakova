package hw6.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTableDropdown {
    @FindBy(tagName = "select")
    private List<WebElement> dropdown;

    public int getAmount() {
        return dropdown.size();
    }

    public List<WebElement> getDropdowns() {
        return dropdown;
    }
}
