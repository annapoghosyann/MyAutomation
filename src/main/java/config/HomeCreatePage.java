package config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeCreatePage {
    public static void openPage() {
        DriverUtils.driver.get(Configuration.ENVIRONMENT+"/create");
    }
    public static String getHeaderText(){
        WebElement headerText = DriverUtils.driver.findElement(By.cssSelector("[data-test=\"create-search-text\"]"));
        return headerText.getText();
    }
    public static void clickNewProjectButton(){
        WebElement newProjectButton = DriverUtils.driver.findElement(By.cssSelector("[class*=\"pw-button\"]"));
        newProjectButton.click();
    }
}
