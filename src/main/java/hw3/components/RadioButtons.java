package hw3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RadioButtons {
    @FindBy(how = How.CSS,using = ".main-content-hg>div:nth-child(3)")
    private WebElement radio;
    @FindBy(how = How.CSS, using = ".checkbox-row>label.label-radio")
    private List<WebElement> radioButtons;

    public int getAmount() {
        return radioButtons.size();
    }

    public WebElement getElement(String attribute) {
        switch (attribute.toUpperCase()) {
            case "GOLD": return radio.findElement(By.cssSelector(":nth-child(1) input"));
            case "SILVER": return radio.findElement(By.cssSelector(":nth-child(2) input"));
            case "BRONZE": return radio.findElement(By.cssSelector(":nth-child(3) input"));
            case "SELEN": return radio.findElement(By.cssSelector(":nth-child(4) input"));
            default: return null;
        }

    }
}
