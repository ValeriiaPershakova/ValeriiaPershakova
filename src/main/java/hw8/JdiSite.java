package hw8;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw8.entities.JdiUser;
import hw8.entities.MenuElements;
import hw8.entities.MetalsColorsInput;
import hw8.pages.JdiHomePage;
import hw8.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("index.html")
    public static JdiHomePage jdiHomePage;
    @Url("metals-colors.html")
    public static MetalsColorsPage metalsColorsPage;
    @Css(".uui-navigation.nav.navbar-nav.m-l8")
    public static Menu headerMenu;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(JdiUser jdiUser) {
        jdiHomePage.login(jdiUser);
    }

    public static void goTo(MenuElements menuItem) {
        headerMenu.select(menuItem.getDescription());
    }

    public static void fillMetalsColorsForm(MetalsColorsInput input) {
        metalsColorsPage.form.submit(input);
    }

    public static boolean resultLogContains(MetalsColorsInput input) {
        return metalsColorsPage.assertResults(input);
    }
}
