package hw8.entities;

import com.epam.jdi.tools.DataClass;
import hw8.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class MetalsColorsInput extends DataClass<MetalsColorsInput> {
    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    private static Map<String, Integer> summaryValuesIndexes = new HashMap<>();

    static {
        summaryValuesIndexes.put("1", 1);
        summaryValuesIndexes.put("2", 1);
        summaryValuesIndexes.put("3", 2);
        summaryValuesIndexes.put("4", 2);
        summaryValuesIndexes.put("5", 3);
        summaryValuesIndexes.put("6", 3);
        summaryValuesIndexes.put("7", 4);
        summaryValuesIndexes.put("8", 4);
    }

    public MetalsColorsInput(List<String> summary, List<String> elements, String color, String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public SummaryEntity getSummaryEntity() {
        SummaryEntity entity = new SummaryEntity(summaryValuesIndexes.get(summary.get(0)), summaryValuesIndexes.get(summary.get(1)));
        return entity;
    }

    public List<String> getExpectedResultsAsStringList() {
        List<String> result = new ArrayList<>();
        result.add(format("Summary: %s", getSum()));
        result.add(format("Elements: %s", Utils.valuesAsString(elements)));
        result.add(format("Color: %s", color));
        result.add(format("Metal: %s", metals));
        result.add(format("Vegetables: %s", Utils.valuesAsString(getVegetables())));
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
