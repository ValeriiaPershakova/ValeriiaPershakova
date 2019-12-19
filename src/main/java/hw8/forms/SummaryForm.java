package hw8.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw8.entities.SummaryEntity;

public class SummaryForm extends Form<SummaryEntity> {
    @Css("#odds-selector label")
    private RadioButtons oddElements;
    @Css("#even-selector label")
    private RadioButtons evenElements;
    @Css("#calculate-button")
    private Button calculateButton;

    @Override
    public void submit(SummaryEntity entity) {
        oddElements.select(entity.getOddElementIndex());
        evenElements.select(entity.getEvenElementIndex());
        calculateButton.click();
    }
}
