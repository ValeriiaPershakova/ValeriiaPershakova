package hw6.cucumber1;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (features = "classpath:hw6/cucumber1")
public class RunTests extends AbstractTestNGCucumberTests {
}
