package hw8.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

import java.util.List;

public class ElementsCheckboxes extends Section {
    @XPath("//label[contains(text(),'Water')]")
    public Checkbox water;
    @XPath("//label[contains(text(),'Earth')]")
    public Checkbox earth;
    @XPath("//label[contains(text(),'Wind')]")
    public Checkbox wind;
    @XPath("//label[contains(text(),'Fire')]")
    public Checkbox fire;

    public void select(List<String> elements) {
        for (String str : elements) {
            switch (str) {
                case "Water": {
                    water.check();
                    break;
                }
                case "Earth": {
                    earth.check();
                    break;
                }
                case "Wind": {
                    wind.check();
                    break;
                }
                case "Fire": {
                    fire.check();
                    break;
                }
                default: {
                    throw new RuntimeException("Wrong Elements checkbox name: " + str);
                }
            }
        }
    }
}
