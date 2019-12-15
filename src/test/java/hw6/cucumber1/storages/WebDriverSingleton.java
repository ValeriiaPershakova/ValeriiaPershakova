package hw6.cucumber1.storages;

import org.openqa.selenium.WebDriver;

public enum WebDriverSingleton {
    INSTANCE;

    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
