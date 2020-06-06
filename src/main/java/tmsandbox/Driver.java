package tmsandbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    public static DriverWait wait;

    public static enum BrowserName {
        CHROME, FIREFOX;
    }

    public static void initDriver(String browser){

        BrowserName browserName = browser != null ? BrowserName.valueOf(browser.toUpperCase()) : BrowserName.valueOf("CHROME");
        switch (browserName){

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                threadLocalDriver.set(new FirefoxDriver());
                break;
            case CHROME:
            default:
                threadLocalDriver.set(setupChrome());
                break;
        }
        threadLocalDriver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new DriverWait(10);
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void quit(){
        getDriver().quit();
        threadLocalDriver.remove();
    }

    private static WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
       return new ChromeDriver();
    }



}
