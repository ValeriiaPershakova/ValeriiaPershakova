package hw2.ex1;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class HomePageDataProvider {
    public static Map<String, String> benefitIcons = new HashMap<>();

    static {
        benefitIcons.put("icons-benefit icon-practise", "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        benefitIcons.put("icons-benefit icon-custom", "To be flexible and\n" +
                "customizable");
        benefitIcons.put("icons-benefit icon-multi", "To be multiplatform");
        benefitIcons.put("icons-benefit icon-base", "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    @DataProvider(name = "MenuElements")
    public static Object[][] menuElements() {
        return new Object[][]{
                {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"}
        };
    }

    @DataProvider(name = "mainContentText")
    public static Object[][] mainContentText() {
        return new Object[][]{
                {"EPAM FRAMEWORK WISHES…",
                        "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
                        "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
                        "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."}
        };
    }
}
