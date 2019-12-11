package hw6.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UserTableDescription {
    @FindBy(how = How.CSS, using = "table img")
    private List<WebElement> descImages;
    @FindBy(how = How.CSS, using = ".user-descr")
    private List<WebElement> descTextes;
    @FindBy(how = How.CSS, using = ".user-descr>input")
    private List<WebElement> checkBoxes;

    public int getImagesAmount() {
        return descImages.size();
    }

    public int getTextsAmount() {
        return descTextes.size();
    }

    public int getCheckboxesAmount() {
        return checkBoxes.size();
    }

    public List<WebElement> getImages() {
        return descImages;
    }

    public List<WebElement> getTexts() {
        return descTextes;
    }

    public List<WebElement> getCheckboxes() {
        return checkBoxes;
    }
}
