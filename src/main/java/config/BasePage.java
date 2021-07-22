package config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public abstract void openPage();

    public BasePage() {
        PageFactory.initElements(DriverUtils.driver,this);
    }
    protected void smartClick(WebElement element){
        WaitHelper.getWait().elementToBeClickable(element);
        element.click();
    }
}
