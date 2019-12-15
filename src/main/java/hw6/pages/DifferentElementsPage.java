package hw6.pages;

import hw6.components.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends AbstractBasePage {
    private LeftSideMenu leftSideMenu;
    private RightSection rightSection;
    private LogRow logRow;
    private DifferentElementsPageCheckBoxes elements;
    private DifferentElementsPageRadioButtons metals;
    private DifferentElementsPageDropDownMenu colors;
    private DifferentElementsPageButtons buttons;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.leftSideMenu = PageFactory.initElements(driver, LeftSideMenu.class);
        this.rightSection = PageFactory.initElements(driver, RightSection.class);
        this.logRow = PageFactory.initElements(driver, LogRow.class);
        this.elements = PageFactory.initElements(driver, DifferentElementsPageCheckBoxes.class);
        this.metals = PageFactory.initElements(driver, DifferentElementsPageRadioButtons.class);
        this.colors = PageFactory.initElements(driver, DifferentElementsPageDropDownMenu.class);
        this.buttons = PageFactory.initElements(driver, DifferentElementsPageButtons.class);
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
