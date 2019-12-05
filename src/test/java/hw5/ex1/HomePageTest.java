package hw5.ex1;

import hw3.AttachmentListener;
import hw3.ex1.HomePageSteps;
import hw3.AbstractBaseSeleniumTest;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.*;


@Listeners({AllureTestNg.class, AttachmentListener.class})
public class HomePageTest extends AbstractBaseSeleniumTest {

    private HomePageSteps steps;
    private List<String> menuElements = new ArrayList<>(
            Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
    private Map<String, String> benefitIcons = new HashMap<>();

    {
        benefitIcons.put("icons-benefit icon-practise", "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        benefitIcons.put("icons-benefit icon-custom", "To be flexible and\n" +
                "customizable");
        benefitIcons.put("icons-benefit icon-multi", "To be multiplatform");
        benefitIcons.put("icons-benefit icon-base", "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        steps = new HomePageSteps(driver);
    }

    @Parameters({"url", "pageTitle", "login", "password", "name",
            "mainHeader", "mainText", "subHeader", "subHeaderLink"})
    @Test(testName = "homePageTestFailed")
    public void homePageTest(String url, String pageTitle, String login, String password, String name,
                             String mainHeader, String mainText, String subHeader, String subHeaderLink) {
        steps.openJDISite(url);
        //2. Assert Browser Title
        steps.browserTitleShouldBe(pageTitle);
        //3. Perform login
        steps.login(login, password);
        //4. Assert User name in the right-top side of screen that user is loggined
        steps.userNameShouldBe(name);
        //5. Assert Browser title
        steps.browserTitleShouldBe(pageTitle);

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        steps.headerMenuShouldBeDisplayed();
        steps.headerMenuShouldContainElements(menuElements);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        steps.imagesShouldBeDisplayed();
        steps.imagesShouldBeExactNumber(4);


        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        steps.textShouldBePresent();
        steps.textShouldContainProperText(benefitIcons);

        //9. Assert a text of the main headers
        steps.mainTitleShouldBeDisplayed();
        steps.mainTitleShouldBeEqual(mainHeader);

        steps.mainTextShouldBeDisplayed();
        steps.mainTexteShouldBeEqual(mainText);


        //10. Assert that there is the iframe in the center of page
        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        //12. Switch to original window back
        steps.iframeShouldBePresent();
        steps.switchToIframe();
        steps.iframeShouldHaveLogoInLeftTopCorner();
        steps.switchToOriginalPage();

        //13. Assert a text of the sub header
        //14. Assert that JDI GITHUB is a link and has a proper URL
        steps.subHeaderShouldBeEqual(subHeader);
        steps.subHeaderShouldBeLinkTo(subHeaderLink);

        //15. Assert that there is Left Section
        steps.leftSectionShouldBePresent();

        //16. Assert that there is Footer
        steps.footerShouldBePresent();
    }

}

