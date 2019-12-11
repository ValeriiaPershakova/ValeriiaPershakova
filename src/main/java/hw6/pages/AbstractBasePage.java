package hw6.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBasePage {
    protected static WebDriver driver;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public Dimension getCurrentWindowSize() {
        return driver.manage().window().getSize();
    }

    public static String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
