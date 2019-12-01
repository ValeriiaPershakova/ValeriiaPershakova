package hw3.components;

import hw3.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class DropDownMenu {
    @FindBy(how = How.CSS, using = ".main-content .uui-form-element")
    private List<WebElement> dropDownMenu;

    public int getAmount() {
        return dropDownMenu.size();
    }

    public WebElement getElement(String attribute) {
        return dropDownMenu.get(0).findElement(By.xpath("//option[contains(text(),'"+ Utils.toNormalCase(attribute)+"')]"));
    }
}
