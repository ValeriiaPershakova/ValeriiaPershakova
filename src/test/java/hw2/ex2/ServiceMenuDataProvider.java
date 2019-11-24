package hw2.ex2;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceMenuDataProvider {
    @DataProvider(name = "serviceDropDownMenuElements")
    public static Object[][] serviceDropDownMenuElements() {
        return new Object[][]{
                {Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLES WITH PAGES",
                        "DIFFERENT ELEMENTS")}
        };
    }
}
