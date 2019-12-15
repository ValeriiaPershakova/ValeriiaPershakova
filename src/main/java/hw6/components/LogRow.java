package hw6.components;

import hw6.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogRow {
    @FindBy(how = How.CSS, using = ".info-panel-body.info-panel-body-log")
    private WebElement logRow;

    public WebElement get() {
        return logRow;
    }

    public boolean contains(String attribute, String value) {
        WebElement log = logRow.findElement(By.xpath("//li[contains(text(),'" + Utils.toNormalCase(attribute) + "')]"));
        if (log != null) {
            return log.getText().toLowerCase().contains(value.toLowerCase());
        } else {
            return false;
        }
    }

    public boolean contains(String line) {
        WebElement log = logRow.findElement(By.xpath("//li[contains(text(),'" + line + "')]"));
        if (log != null) {
            return true;
        } else {
            return false;
        }
    }
}
