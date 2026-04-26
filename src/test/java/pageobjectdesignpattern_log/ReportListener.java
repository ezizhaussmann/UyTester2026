package pageobjectdesignpattern_log;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (ExtentReportManager.getTest() != null)
            ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (ExtentReportManager.getTest() == null) return;
        ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = null;
        if (testClass instanceof BaseClass) {
            driver = ((BaseClass) testClass).driver;
        }

        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            attachScreenshotToAllure(screenshot);
            ExtentReportManager.getTest().addScreenCaptureFromBase64String(
                java.util.Base64.getEncoder().encodeToString(screenshot)
            );
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure(byte[] screenshot) {
        return screenshot;
    }
}