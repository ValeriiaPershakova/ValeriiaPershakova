package hw2.ex2;

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
}
