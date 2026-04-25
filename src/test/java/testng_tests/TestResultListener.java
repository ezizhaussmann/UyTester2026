package testng_tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @created : 25/04/2026,19:13,sam.
 **/
public class TestResultListener implements ITestListener {
  ScreenShotUtility screenShotUtility = new ScreenShotUtility();
   public void onTestStart(ITestResult result) {
    }

     public void onTestSuccess(ITestResult result) {
      screenShotUtility.captureScreen(result.getMethod().getMethodName().trim()+"_Passed",
              (ChromeDriver) result.getTestContext().getAttribute("driver"));
    }


   public void onTestFailure(ITestResult result) {
    screenShotUtility.captureScreen(result.getMethod().getMethodName().trim()+"_Filed",
            (ChromeDriver) result.getTestContext().getAttribute("driver"));

    }
    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}

