package hw6.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UserTableUsername {
    @FindBy(how = How.CSS, using = "td>a")
    private List<WebElement> usernames;

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public int getAmount() {
        return usernames.size();
    }
}
