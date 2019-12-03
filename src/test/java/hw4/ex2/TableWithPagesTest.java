package hw4.ex2;

import com.codeborne.selenide.WebDriverRunner;
import hw4.AbstractBaseTest;
import hw4.common.elementsEnum.MenuElements;
import hw4.common.elementsEnum.MenuType;
import hw4.common.elementsEnum.ServiceMenuElements;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class TableWithPagesTest extends AbstractBaseTest {
    @Parameters({"login", "password", "userName", "entriesNumber", "searchedValue"})
    @Test
    public void tableWithPagesTest(String login, String password, String userName,
                                   String entriesNumber, String searchedValue) {
        //1. Open test site by URL
        open(HomePage.URL);
        HomePage homePage = new HomePage();
        //2. Assert Browser title
        homePage.title().shouldHave(attribute("text", "Home Page"));
        //3. Perform login

        //---Design Pattern: BUILDER
        User piter = User.userBuilder().setLogin(login).setPassword(password).setName(userName).build();
        //---Design Pattern: VALUE OBJECT
        homePage.login(piter);
        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.userName().shouldBe(matchesText(piter.getName()));
        homePage.userName().shouldBe(visible);
        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.serviceDropDownMenu(MenuType.HEADER).texts().containsAll(ServiceMenuElements.getDescriptionCollection());
        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePage.serviceDropDownMenu(MenuType.LEFT_SIDE).texts().containsAll(ServiceMenuElements.getDescriptionCollection());

        //7. Open through the header menu Service -> Table with pages
        homePage.goTo(MenuElements.TABLE_WITH_PAGES);
        Assert.assertEquals(WebDriverRunner.url(), TableWithPagesPage.url);

        //8. Check that default value for “Show entries” dropdown is 5
        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage();
        tableWithPagesPage.getShowEntries().shouldHave(text("5"));

        //9. Assert that there is Right Section
        tableWithPagesPage.getRightSection().should(exist);
        //10. Assert that there is Left Section
        tableWithPagesPage.getLeftSection().should(exist);

        //11. Select new value for the entries in the dropdown list
        tableWithPagesPage.selectShowEntriesNumber(entriesNumber);
        tableWithPagesPage.getShowEntries().shouldHave(text(entriesNumber));
        //12. Assert that for the dropdown there is an individual log row and value is corresponded to the value of dropdown.
        tableWithPagesPage.getEntriesNumberChangedLogRow().shouldHave(text(entriesNumber));
        //13. Assert that in the table displayed corrected amount of entries
        Assert.assertEquals(tableWithPagesPage.getTableSize(), Integer.parseInt(entriesNumber));

        //14. Type in “Search” text field
        tableWithPagesPage.search(searchedValue);
        //15. Assert the table contains only records with Search field value
        tableWithPagesPage.getTableRecords().shouldHave(TableWithPagesPage.searchedValueInEachRecord(searchedValue));
    }
}
