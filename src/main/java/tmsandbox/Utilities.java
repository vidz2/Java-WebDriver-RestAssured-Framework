package tmsandbox;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Utilities {
    public static String takeScreenshot(WebDriver driver, String outputPath){

        String fileName = String.format("screenshot-%s.png", Calendar.getInstance().getTimeInMillis());

        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(outputPath + fileName);
        try{
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot taken");
        return fileName;
    }
}
