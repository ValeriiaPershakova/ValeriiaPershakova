package hw4.ex2.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LogRow {
    @FindBy(css = ".info-panel-body.info-panel-body-log")
    private SelenideElement logRow;

    public LogRow() {
        page(this);
    }

    public ElementsCollection findLogRows(String parameter) {
        return logRow.$$(By.xpath("div//li")).filter(Condition.text(parameter));
    }
}
