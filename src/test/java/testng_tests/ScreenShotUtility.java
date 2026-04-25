package testng_tests;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility {
    public File captureScreen(String fileName, ChromeDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yy_hh-mm");
        String timestamp = new DateTime().toString(formatter);
        fileName = timestamp + "_" + fileName;
        File destFile = new File("screenshots" + File.separator + fileName + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destFile;
    }
}
