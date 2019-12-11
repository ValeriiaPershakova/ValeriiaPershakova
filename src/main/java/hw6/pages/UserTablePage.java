package hw6.pages;

import hw6.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTablePage extends AbstractBasePage {
    private UserTableDropdown numberType;
    private UserTableUsername users;
    private UserTableDescription description;
    private UserTableLines lines;
    private LogRow logRow;

    public UserTablePage(WebDriver driver) {
        super(driver);
        numberType = PageFactory.initElements(driver, UserTableDropdown.class);
        users = PageFactory.initElements(driver, UserTableUsername.class);
        description = PageFactory.initElements(driver, UserTableDescription.class);
        lines = PageFactory.initElements(driver, UserTableLines.class);
        logRow = PageFactory.initElements(driver, LogRow.class);
    }

    public int getDropdownsAmount() {
        return numberType.getAmount();
    }

    public List<WebElement> getDropdowns() {
        return numberType.getDropdowns();
    }

    public int getUserNamesAmount() {
        return users.getAmount();
    }

    public List<WebElement> getUserNames() {
        return users.getUsernames();
    }

    public int getDiscriptionImagesAmount() {
        return description.getImagesAmount();
    }

    public List<WebElement> getDiscriptionImages() {
        return description.getImages();
    }

    public int getDiscriptionTextsAmount() {
        return description.getTextsAmount();
    }

    public List<WebElement> getDiscriptionTexts() {
        return description.getTexts();
    }

    public int getCheckboxesAmount() {
        return description.getCheckboxesAmount();
    }

    public List<WebElement> getCheckboxes() {
        return description.getCheckboxes();
    }

    public List<Map<String, String>> getLines() {
        return lines.getLinesAsMaps();
    }

    public void selectCheckboxByName(String username) {
        WebElement searchedLine = lines.findElementByUserName(username);
        searchedLine.findElement(By.tagName("input")).click();
    }

    public boolean logRowHasText(String text) {
        return logRow.contains(text);
    }

    public void clickOnDropdownForUser(String username) {
        WebElement searchedLine = lines.findElementByUserName(username);
        searchedLine.findElement(By.tagName("select")).click();
    }


    public List<String> getDropdownOptionsByUsername(String username) {
        WebElement searchedLine = lines.findElementByUserName(username);
        List<String> texts = new ArrayList<>();
        for (WebElement element : searchedLine.findElements(By.tagName("option"))) {
            texts.add(element.getText());
        }
        return texts;
    }
}
