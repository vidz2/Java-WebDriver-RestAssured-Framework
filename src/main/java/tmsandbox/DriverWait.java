package tmsandbox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWait {
    private static WebDriverWait wait;
    private static final int POLLING = 100;
    private static int timeout;

    public DriverWait(int waitSeconds){
        timeout = waitSeconds;
        wait = new WebDriverWait(Driver.getDriver(), waitSeconds, POLLING);
    }

    public static void setTimeout(int waitSeconds){
        wait.withTimeout(Duration.ofSeconds(waitSeconds));
    }

    public WebElement waitForElementToBeVisible(WebElement element, int waitSeconds){
        return wait
                .withTimeout(Duration.ofSeconds(waitSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element){
        return waitForElementToBeVisible(element,timeout);
    }

}
