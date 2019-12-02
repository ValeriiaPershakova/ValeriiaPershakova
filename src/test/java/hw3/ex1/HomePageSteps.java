package hw3.ex1;

import hw3.AbstractBaseStep;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps extends AbstractBaseStep {


    public HomePageSteps(WebDriver driver) {
        super(driver);
    }

    public void headerMenuShouldBeDisplayed() {
        for (WebElement element : homePage.getHeaderMenuElements()) {
            assertTrue(element.isDisplayed());
        }
    }

    public void headerMenuShouldContainElements(List<String> menuElements) {
        assertEquals(homePage.getHeaderMenuElements().size(), 4);
        for (int i = 0; i < 4; i++) {
            assertEquals(homePage.getHeaderMenuElements().get(i).getText(), menuElements.get(i));
        }
    }

    public void imagesShouldBeDisplayed() {
        for (WebElement element : homePage.getImages()) {
            assertTrue(element.isDisplayed());
        }
    }


    public void imagesShouldBeExactNumber(int quantity) {
        assertEquals(homePage.getImages().size(), quantity);
    }

    public void textShouldBePresent() {
        for (WebElement element : homePage.getTextElementsUnderImages())
            assertTrue(element.isDisplayed());
    }

    public void textShouldContainProperText(Map<String, String> benefitIcons) {
        for (int i = 1; i < homePage.getImages().size(); i++) {
            if (benefitIcons.containsKey(homePage.getImageClass(i))) {
                String expected = benefitIcons.get(homePage.getImageClass(i));
                String actual = homePage.getTextElementsUnderImages().get(i).getText();
                assertEquals(actual, expected);
            } else {
                throw new RuntimeException("class name is not in the list");
            }
        }
    }

    public void mainTitleShouldBeDisplayed() {
        assertTrue(homePage.getMainTitle().isDisplayed());
    }

    public void mainTitleShouldBeEqual(String mainTitle) {
        assertEquals(homePage.getMainTitle().getText(), mainTitle);
    }

    public void mainTextShouldBeDisplayed() {
        assertTrue(homePage.getMainText().isDisplayed());
    }

    public void mainTexteShouldBeEqual(String mainText) {
        assertEquals(homePage.getMainText().getText(), mainText);
    }

    public void iframeShouldBePresent() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    public void switchToIframe() {
        homePage.switchToIframe();
    }

    public void iframeShouldHaveLogoInLeftTopCorner() {
        WebElement logo = homePage.getLogo();
        assertTrue(logo.isDisplayed());

        Dimension frameSize = homePage.getCurrentWindowSize();
        assertTrue(logo.getLocation().getX() < frameSize.getWidth() * 0.1);
        assertTrue(logo.getLocation().getY() < frameSize.getHeight() * 0.1);
    }

    public void switchToOriginalPage() {
        homePage.switchToOriginalPage();
    }

    public void subHeaderShouldBeEqual(String subHeader) {
        assertEquals(homePage.getSubHeaderText(), subHeader);
    }

    public void subHeaderShouldBeLinkTo(String link) {
        assertEquals(homePage.getSubHeaderLink(), link);
    }

    public void leftSectionShouldBePresent() {
        assertTrue(homePage.getLeftMenu().isDisplayed());
        assertTrue(homePage.getLeftMenu().getLocation().getX()
                < homePage.getCurrentWindowSize().getWidth() * 0.1);
    }

    public void footerShouldBePresent() {
        assertTrue(homePage.getFooter().isDisplayed());
        assertTrue(homePage.getFooter().getLocation().getY()
                >= homePage.getCurrentWindowSize().getHeight() * 0.9);
    }
}
