package hw5.ex1;

import hw3.WebDriverSingleton;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AttachmentListener implements ITestListener {
    @Attachment(value = "{0}", fileExtension = "png", type = "image/png")
    public byte[] makeScreenshot(String name) {
        byte[] array = null;
        try {
            System.out.println("Make " + name + " screenshot");
            array = ((TakesScreenshot) WebDriverSingleton.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenshot(tr.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        makeScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
