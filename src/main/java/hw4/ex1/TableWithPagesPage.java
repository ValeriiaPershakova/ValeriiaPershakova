package hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementsCollection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TableWithPagesPage {
    public static String url = "https://epam.github.io/JDI/table-pages.html";
    @FindBy(name = "table-with-pages_length")
    private SelenideElement showEntries;
    @FindBy(name = "log-sidebar")
    private SelenideElement rightSection;
    @FindBy(name = "navigation-sidebar")
    private SelenideElement leftSection;
    @FindBy(id = "table-with-pages")
    private SelenideElement table;
    @FindBy(css = "#table-with-pages tbody>tr")
    private ElementsCollection tableRecords;

    public TableWithPagesPage() {
        page(this);
    }

    public SelenideElement getShowEntries() {
        return showEntries;
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public void selectShowEntriesNumber(String number) {
        showEntries.$(By.xpath("option[contains(text(),'" + number + "')]")).click();
    }

    public ElementsCollection getLogRows() {
        return rightSection.$$(By.xpath("div//ul[@class='panel-body-list logs']/li"));
    }

    public int getTableSize() {
        return tableRecords.size();
    }

    public void search(String str) {
        $(By.xpath("//input[@type='search']")).setValue(str);
    }

    public ElementsCollection getTableRecords() {
        return tableRecords;

    }

    public static CollectionCondition searchedValueInEachRecord(String searchingWord) {
        return new CollectionCondition() {
            @Override
            public void fail(WebElementsCollection webElementsCollection, List<WebElement> list, Exception e, long l) {
                e.printStackTrace();
            }

            @Override
            public boolean applyNull() {
                return false;
            }

            @Override
            public boolean apply(@NullableDecl List<WebElement> webElements) {
                for (WebElement element : webElements) {
                    if (!element.getText().contains(searchingWord)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}
