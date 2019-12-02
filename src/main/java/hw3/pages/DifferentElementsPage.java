package hw3.pages;

import hw3.components.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends AbstractBasePage {
    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;
    private RightSection rightSection;
    private LogRow logRow;
    private CheckBoxes elements;
    private RadioButtons metals;
    private DropDownMenu colors;
    private Buttons buttons;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.headerMenu = PageFactory.initElements(driver, HeaderMenu.class);
        this.leftSideMenu = PageFactory.initElements(driver, LeftSideMenu.class);
        this.rightSection = PageFactory.initElements(driver, RightSection.class);
        this.logRow = PageFactory.initElements(driver, LogRow.class);
        this.elements = PageFactory.initElements(driver, CheckBoxes.class);
        this.metals = PageFactory.initElements(driver, RadioButtons.class);
        this.colors = PageFactory.initElements(driver, DropDownMenu.class);
        this.buttons = PageFactory.initElements(driver, Buttons.class);
    }

    public int getCheckBoxesAmount() {
        return elements.getAmount();
    }

    public int getRadioAmount() {
        return metals.getAmount();
    }

    public int getDropDownMenuAmount() {
        return colors.getAmount();
    }

    public int getButtonsAmount() {
        return buttons.getAmount();
    }

    public WebElement getRightSection() {
        return rightSection.getElement();
    }

    public WebElement getLeftSection() {
        return leftSideMenu.getElement();
    }

    public WebElement getCheckBox(String attribute) {
        return elements.getElement(attribute);
    }

    public WebElement getLogRow() {
        return logRow.get();
    }

    public boolean logRowContains(String attribute, String value) {
        return logRow.contains(attribute, value);
    }

    public WebElement getRadioElement(String attribute) {
        return metals.getElement(attribute);
    }

    public WebElement getDropDownMenuElement(String attribute) {
        return colors.getElement(attribute);
    }
}
