package hw8.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw8.entities.MetalsColorsInput;
import hw8.entities.SummaryEntity;
import hw8.sections.ElementsCheckboxes;
import org.openqa.selenium.By;

import java.util.List;

public class MetalsColorsForm extends Form<MetalsColorsInput> {

    @Css("#summary-block")
    private SummaryForm summaryForm;

    @Css("#elements-checklist")
    private ElementsCheckboxes elements;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metal;

    @Css("#vegetables")
    private UIElement vegetables;

    @Css("#submit-button")
    private Button submit;


    @Override
    public void submit(MetalsColorsInput input) {
        fillSummary(input.getSummaryEntity());
        fillElements(input.getElements());
        fillColors(input.getColor());
        fillMetals(input.getMetals());
        fillVegetables(input.getVegetables());
        clickSubmitButton();
    }

    private void fillSummary(SummaryEntity summaryEntity) {
        summaryForm.submit(summaryEntity);
    }

    private void fillColors(String color) {
        colors.select(color);
    }

    private void fillMetals(String metals) {
        this.metal.select(metals);
    }

    private void fillVegetables(List<String> vegetables) {
        this.vegetables.find(By.className("caret")).click();
        WebList elements = this.vegetables.finds(By.xpath("//a[@class='checkbox']"));
        this.vegetables.find(By.xpath("//a//label[contains(text(),'Vegetables')]")).click();
        for (UIElement element : elements) {
            for (String str : vegetables) {
                if (element.find(By.tagName("label")).getText().equals(str)) {
                    element.click();
                }
            }
        }
    }

    private void fillElements(List<String> elements) {
        this.elements.select(elements);
    }

    private void clickSubmitButton() {
        submit.click();
    }
}
