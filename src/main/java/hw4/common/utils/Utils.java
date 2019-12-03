package hw4.common.utils;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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
}
