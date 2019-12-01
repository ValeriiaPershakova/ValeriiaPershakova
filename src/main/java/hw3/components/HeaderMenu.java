package hw3.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.How.CSS;

public class HeaderMenu {
    @FindBy(how = CSS, using = ".uui-navigation.nav.navbar-nav.m-l8>li")
    private List<WebElement> headerMenuElements;


}
