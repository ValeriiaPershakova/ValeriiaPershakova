package hw2.ex1;

import hw2.AbstractBaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static hw2.ex1.HomePageDataProvider.benefitIcons;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends AbstractBaseSeleniumTest {

    @Test(dataProviderClass = HomePageDataProvider.class, dataProvider = "MenuElements")
    public void headerMenuTest(String[] menu) {
        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerMenu = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8>li"));
        assertEquals(headerMenu.size(), 4);

        for (int i = 0; i < 4; i++) {
            assertEquals(headerMenu.get(i).getText(), menu[i]);
            assertTrue(headerMenu.get(i).isDisplayed());
        }
    }

    @Test
    public void benefitImagesDisplayedTest() {
        //7. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));

        assertEquals(images.size(), 4);
        for (WebElement element : images) {
            assertTrue(element.isDisplayed());
        }
    }

    @Test
    public void benefitImagesAndTextsTest() {
        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> imagesText = driver.findElements(By.className("benefit"));

        for (WebElement element : imagesText) {
            List<WebElement> pair = element.findElements(By.tagName("span"));
            if (benefitIcons.containsKey(pair.get(0).getAttribute("class"))) {
                String expected = benefitIcons.get(pair.get(0).getAttribute("class"));
                String actual = pair.get(1).getText();
                assertEquals(actual, expected);
            } else {
                throw new RuntimeException("class name is not in the list");
            }
        }
    }

    @Test(dataProviderClass = hw2.ex1.HomePageDataProvider.class, dataProvider = "mainContentText")
    public void mainHeadersTextTest(String expectedTitle, String expectedText) {
        //9. Assert a text of the main headers
        assertTrue(driver.findElement(By.name("main-title")).isDisplayed());
        assertEquals(driver.findElement(By.name("main-title")).getText(), expectedTitle);

        assertTrue(driver.findElement(By.name("jdi-text")).isDisplayed());
        assertEquals(driver.findElement(By.name("jdi-text")).getText(), expectedText);
    }

    @Test(priority = 1)
    public void iframeTest() {
        //10. Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.id("iframe"));

        assertTrue(frame.isDisplayed());


        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe

        driver.switchTo().frame(frame);
    }

    @Test(priority = 2)
    public void iframeLogoTest() {
        WebElement logo = driver.findElement(By.id("epam_logo"));

        assertTrue(logo.isDisplayed());

        Dimension frameSize = driver.manage().window().getSize();
        assertTrue(logo.getLocation().getX() < frameSize.getWidth() / 10);
        assertTrue(logo.getLocation().getY() < frameSize.getHeight() / 10);

        //12. Switch to original window back
        driver.switchTo().defaultContent();
    }

    @Test
    public void subHeaderTest() {
        //13. Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("h3.text-center>a"));

        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");
    }

    @Test
    public void leftMenuTest() {
        //15. Assert that there is Left Section
        WebElement leftMenu = driver.findElement(By.name("navigation-sidebar"));

        assertTrue(leftMenu.isDisplayed());
        assertTrue(leftMenu.getLocation().getX() < windowSize.getWidth() / 10);
    }

    @Test
    public void footerTest() {
        //16. Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("div.footer-bg>div"));

        assertTrue(footer.isDisplayed());
        assertTrue(footer.getLocation().getY() >= windowSize.getHeight() * 0.9);

    }
}

