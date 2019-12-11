package hw6.utils;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Utils {
    public static List<String> getTextFromWebElementsInUpperCase(List<WebElement> webElements) {
        List<String> textList = new ArrayList<>();
        for (WebElement element : webElements) {
            textList.add(element.getText().toUpperCase());
        }
        return textList;
    }

    public static String toNormalCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder converted = new StringBuilder();
        boolean convertFirst = true;
        for (char ch : input.toCharArray()) {
            if (convertFirst) {
                ch = Character.toTitleCase(ch);
                convertFirst = false;
            } else {
                ch = Character.toLowerCase(ch);
            }

            converted.append(ch);
        }
        return converted.toString();
    }
    public static String toEnumFormat(String input) {
        List<String> string = Arrays.asList(input.split("\\s"));
        StringBuilder builder = new StringBuilder();
        Iterator<String> iter = string.iterator();
        while (iter.hasNext()){
            builder.append(iter.next().toUpperCase());
        if(iter.hasNext()) {
            builder.append("_");
        }
        }
        return builder.toString();
    }

    public static String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }
}
