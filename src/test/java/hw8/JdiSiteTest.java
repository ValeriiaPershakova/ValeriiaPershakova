package hw8;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw8.data.MetalsColorsFormDataProvider;
import hw8.entities.JdiUser;
import hw8.entities.MenuElements;
import hw8.entities.MetalsColorsInput;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static java.lang.String.format;

public class JdiSiteTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(priority = 1)
    public void jdiLoginTest() {
        JdiSite.open();
        JdiSite.login(JdiUser.ROMAN);
        String actualUserName = JdiSite.jdiHomePage.getUserName();
        Assert.assertEquals(actualUserName, JdiUser.ROMAN.getFullName(),
                format("Expected loggined user: %s, but get %s", JdiUser.ROMAN, actualUserName));

    }

    @Test(priority = 2,
            dataProviderClass = MetalsColorsFormDataProvider.class, dataProvider = "Json Input for Metals&Colors Form")
    public void jdiMetalsColorsFormTest(MetalsColorsInput metalsColorsInput) {
        JdiSite.goTo(MenuElements.METALS_COLORS);
        Assert.assertTrue(JdiSite.metalsColorsPage.isOpened());
        JdiSite.fillMetalsColorsForm(metalsColorsInput);
        Assert.assertTrue(JdiSite.resultLogContains(metalsColorsInput), "Result Log does not contain all expected results");
    }
}
