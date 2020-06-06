package tmsandbox.pages;

import tmsandbox.Driver;
import tmsandbox.DriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {
    private static final int TIMEOUT = 10;
    public DriverWait wait = new DriverWait(TIMEOUT);
    public BasePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getDriver(), TIMEOUT), this);
    }

}

