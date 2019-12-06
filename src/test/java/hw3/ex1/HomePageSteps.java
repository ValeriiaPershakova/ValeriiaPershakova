package hw3.ex1;

import hw3.AbstractBaseStep;
import io.qameta.allure.Step;
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

    @Step("Assertion that the Header Menu is displayed on Home Page")
    public void headerMenuShouldBeDisplayed() {
        for (WebElement element : homePage.getHeaderMenuElements()) {
            assertTrue(element.isDisplayed());
        }
    }

    @Step("Assertion that The header menu contains all those elements: '{0}'")
    public void headerMenuShouldContainElements(List<String> menuElements) {
        assertEquals(homePage.getHeaderMenuElements().size(), 4);
        for (int i = 0; i < 4; i++) {
            assertEquals(homePage.getHeaderMenuElements().get(i).getText(), menuElements.get(i));
        }
    }

    @Step("Assertion that Benefit images on the Home page are displayed")
    public void imagesShouldBeDisplayed() {
        for (WebElement element : homePage.getImages()) {
            assertTrue(element.isDisplayed());
        }
    }

    @Step("Assertion that There are '{0}' benefit images on the Home Page")
    public void imagesShouldBeExactNumber(int quantity) {
        assertEquals(homePage.getImages().size(), quantity);
    }

    @Step("Assertion that There are texts under each benefit image")
    public void textShouldBePresent() {
        for (WebElement element : homePage.getTextElementsUnderImages())
            assertTrue(element.isDisplayed());
    }

    @Step("Assertion that Each benefit image has proper text under it")
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

    @Step("Assertion that Main title is displayed on the Home page")
    public void mainTitleShouldBeDisplayed() {
        assertTrue(homePage.getMainTitle().isDisplayed());
    }

    @Step("Assertion that the Main title is '{0}'")
    public void mainTitleShouldBeEqual(String mainTitle) {
        assertEquals(homePage.getMainTitle().getText(), mainTitle);
    }

    @Step("Assertion that Main text is displayed")
    public void mainTextShouldBeDisplayed() {
        assertTrue(homePage.getMainText().isDisplayed());
    }

    @Step("Assertion that the Main text is '{0}'")
    public void mainTexteShouldBeEqual(String mainText) {
        assertEquals(homePage.getMainText().getText(), mainText);
    }

    @Step("Assertion that iFrame is present on Home Page")
    public void iframeShouldBePresent() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step("I switch to iFrame")
    public void switchToIframe() {
        homePage.switchToIframe();
    }

    @Step("Assertion that iFrame has logo image in left top corner")
    public void iframeShouldHaveLogoInLeftTopCorner() {
        WebElement logo = homePage.getLogo();
        assertTrue(logo.isDisplayed());

        Dimension frameSize = homePage.getCurrentWindowSize();
        assertTrue(logo.getLocation().getX() < frameSize.getWidth() * 0.1);
        assertTrue(logo.getLocation().getY() < frameSize.getHeight() * 0.1);
    }

    @Step("I switch to Original page")
    public void switchToOriginalPage() {
        homePage.switchToOriginalPage();
    }

    @Step("Assertion that the Subheader is '{0}'")
    public void subHeaderShouldBeEqual(String subHeader) {
        assertEquals(homePage.getSubHeaderText(), subHeader);
    }

    @Step("Assertion that the Subheader link to URL '{0}'")
    public void subHeaderShouldBeLinkTo(String link) {
        assertEquals(homePage.getSubHeaderLink(), link);
    }

    @Step("Assertion that There is the Left section on Home page")
    public void leftSectionShouldBePresent() {
        assertTrue(homePage.getLeftMenu().isDisplayed());
        assertTrue(homePage.getLeftMenu().getLocation().getX()
                < homePage.getCurrentWindowSize().getWidth() * 0.1);
    }

    @Step("Assertion that There is the Footer on Home Page")
    public void footerShouldBePresent() {
        assertTrue(homePage.getFooter().isDisplayed());
        assertTrue(homePage.getFooter().getLocation().getY()
                >= homePage.getCurrentWindowSize().getHeight() * 0.9);
    }
}
