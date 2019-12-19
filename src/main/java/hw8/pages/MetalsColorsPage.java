package hw8.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw8.entities.MetalsColorsInput;
import hw8.forms.MetalsColorsForm;

import java.util.List;
import java.util.stream.Collectors;

public class MetalsColorsPage extends WebPage {
    @Css(".uui-navigation.nav.navbar-nav.m-l8")
    public Menu headerMenu;

    @Css(".form")
    public MetalsColorsForm form;

    @Css(".info-panel-body-result li")
    public WebList results;


    public boolean assertResults(MetalsColorsInput input) {
        List<String> resultsText = results.stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
        return resultsText.containsAll(input.getExpectedResultsAsStringList());
    }
}
