package hw4.ex2.components;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class TableWithPagesTable {
    @FindBy(css = "#table-with-pages tbody>tr")
    private ElementsCollection tableRecords;

    public TableWithPagesTable() {
        page(this);
    }

    public ElementsCollection getTableRecords() {
        return tableRecords;
    }

    public int size() {
        return tableRecords.size();
    }
}
