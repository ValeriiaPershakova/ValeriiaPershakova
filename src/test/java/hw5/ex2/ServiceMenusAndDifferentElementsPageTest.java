package hw5.ex2;

import hw3.elementsEnum.MenuElements;
import hw3.elementsEnum.MenuType;
import hw3.elementsEnum.ServiceMenuElements;
import hw5.AbstractBaseSeleniumTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ServiceMenusAndDifferentElementsPageTest extends AbstractBaseSeleniumTest {
    private ServicePageSteps steps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        steps = new ServicePageSteps(driver);
    }

    @Parameters({"url", "pageTitle", "login", "password", "name",
            "checkBoxWater", "checkBoxWind",
            "radioAttribute", "radioValue",
            "dropDownElement", "dropDownValue"})

    @Test
    public void serviceMenusAndDifferentElementsPageTest(String url, String pageTitle, String login, String password, String name,
                                                         String checkBoxWater, String checkBoxWind,
                                                         String radioAttribute, String radioValue,
                                                         String dropDownElement, String dropDownValue) {


        steps.openJDISite(url);
        //2. Assert Browser Title
        steps.browserTitleShouldBe(pageTitle);
        //3. Perform login
        steps.login(login, password);
        //4. Assert User name in the right-top side of screen that user is loggined
        steps.userNameShouldBe(name);
        //5. Click on "Service" subcategory in the header and check that drop down contains options
        steps.dropDownMenuShouldContainElements(MenuType.HEADER, ServiceMenuElements.values());
        //6. Click on Service subcategory in the left section and check that drop down contains options
        steps.dropDownMenuShouldContainElements(MenuType.LEFT_SIDE, ServiceMenuElements.values());
        //7. Open through the header menu Service -> Different Elements Page
        steps.goTo(MenuElements.DIFFERENT_ELEMENTS);

        //8. Check interface on Different elements page, it contains all needed elements
        steps.checkBoxArePresent(4);
        steps.radioButtonsArePresent(4);
        steps.dropDownMenuIsPresent(1);
        steps.buttonsArePresent(2);
        //9. Assert that there is Right Section
        steps.rightSectionIsPresent();
        //10. Assert that there is Left Section
        steps.leftSectionIsPresent();

        //11. Select checkboxes
        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        steps.checkBoxSelected(checkBoxWater, checkBoxWind);
        steps.logRowWork(checkBoxWater, "true");
        steps.logRowWork(checkBoxWind, "true");

        //13. Select radio
        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        steps.radioWork(radioAttribute);
        steps.logRowWork(radioAttribute, radioValue);

        //15. Select in dropdown
        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        steps.dropDownMenuWork(dropDownElement);
        steps.logRowWork(dropDownElement, dropDownValue);

        //17. Unselect and assert checkboxes
        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        steps.checkBoxUnselected(checkBoxWater, checkBoxWind);
        steps.logRowWork(checkBoxWater, "false");
        steps.logRowWork(checkBoxWind, "false");

        steps.assertAll();
    }

}
