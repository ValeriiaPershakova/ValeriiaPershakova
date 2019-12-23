package hw8.entities;

import com.epam.jdi.tools.DataClass;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class MetalsColorsInput extends DataClass<MetalsColorsInput> {
    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public MetalsColorsInput(List<String> summary, List<String> elements,
                             String color, String metals,
                             List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }


    public List<String> getExpectedResultsAsStringList() {
        List<String> result = new ArrayList<>();
        result.add(format("Summary: %s", getSum()));
        result.add(format("Elements: %s", String.join(", ", elements)));
        result.add(format("Color: %s", color));
        result.add(format("Metal: %s", metals));
        result.add(format("Vegetables: %s", String.join(", ", vegetables)));
        return result;
    }

    private int getSum() {
        int expectedSum = Integer.parseInt(getSummary().get(0)) + Integer.parseInt(getSummary().get(1));
        return expectedSum;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

}
