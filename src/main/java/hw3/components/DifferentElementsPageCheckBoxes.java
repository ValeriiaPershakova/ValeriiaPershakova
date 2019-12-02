package hw3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class DifferentElementsPageCheckBoxes {
    @FindBy(how = How.CSS, using = ".main-content-hg>div:nth-child(2)")
    private WebElement checkBox;
    @FindBy(how = How.CSS, using = ".checkbox-row>label.label-checkbox")
    private List<WebElement> checkBoxes;

    public int getAmount() {
        return checkBoxes.size();
    }

    public WebElement getElement(String attribute) {
        switch (attribute.toUpperCase()) {
            case "WATER": {
                return checkBox.findElement(By.cssSelector(":nth-child(1) input"));
            }
            case "EARTH": {
                return checkBox.findElement(By.cssSelector(":nth-child(2) input"));
            }
            case "WIND":{
                return checkBox.findElement(By.cssSelector(":nth-child(3) input"));
            }
            case "FIRE":{
                return checkBox.findElement(By.cssSelector(":nth-child(4) input"));
            } default: return null;
        }
    }
}
