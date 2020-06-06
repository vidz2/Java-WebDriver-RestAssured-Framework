package tmsandbox.tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tmsandbox.Driver;
import tmsandbox.Utilities;

import java.io.IOException;

@Listeners({ExtentIReporterSuiteListenerAdapter.class})
public class UITestBase extends TestBase {

    private static String output_path;

    WebDriver getDriver() {
        return Driver.getDriver();
    }

    @BeforeMethod(groups={"ui_test","used_cars"})
    public void setup(){
        Driver.initDriver(env_properties.getProperty("browser"));
    }

    @AfterMethod(groups={"ui_test","used_cars"})
    public void afterMethod(ITestResult result) throws IOException {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                ExtentTestManager.getTest(result).fail("ITestResult.FAILURE, event afterMethod",
                        MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(getDriver(),output_path)).build());
                break;
            case ITestResult.SKIP:
                ExtentTestManager.getTest(result).skip("ITestResult.SKIP, event afterMethod");
                break;
            default:
                break;
        }
        Driver.quit();
    }
}
