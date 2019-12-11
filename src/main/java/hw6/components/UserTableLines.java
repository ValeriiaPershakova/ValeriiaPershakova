package hw6.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class UserTableLines {
    @FindBy(tagName = "tr")
    private List<WebElement> elementsLines;

    public List<Map<String, String>> getLinesAsMaps() {
        List<Map<String, String>> lines = new ArrayList<>();
        for (int i = 1; i < elementsLines.size(); i++) {
            Map<String, String> line = new HashMap<>();
            line.put("Number", elementsLines.get(i).findElement(By.tagName("td")).getText());
            line.put("User", elementsLines.get(i).findElement(By.cssSelector("td>a")).getText());
            line.put("Description", elementsLines.get(i).findElement(By.cssSelector("td>div>span")).getText());
            lines.add(line);
        }
        return lines;
    }
    public WebElement findElementByUserName(String username) {
        for (int i=1; i<elementsLines.size(); i++) {
            String name = elementsLines.get(i).findElement(By.cssSelector("td>a")).getText();
            if (username.equals(name)) {
                return elementsLines.get(i);
            }
        }
        return null;
    }
}
