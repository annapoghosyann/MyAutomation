package config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    private static WebDriverWait webDriverWait;

    public WaitHelper() {
        webDriverWait = new WebDriverWait(DriverUtils.driver, 30);
    }

    public static WaitHelper getWait() {
        return new WaitHelper();
    }
    public void elementToBeClickable(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
