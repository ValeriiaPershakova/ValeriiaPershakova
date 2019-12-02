package hw4.ex1;

import com.codeborne.selenide.Condition;
import hw4.HomePage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class TableWithPagesTest {
    @Test
    public void tableWithPagesTest(String login, String password, String) {
        open(HomePage.URL);
        HomePage homePage = new HomePage();
        homePage.login(login, password);
        homePage.userName().shouldBe(userName);
        homePage.userName().shouldHave(Condition.visible);
    }
}
