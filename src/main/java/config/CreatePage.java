package config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage extends BasePage {


    @FindBy(css = "[class*=\"pw-button\"]")
    public WebElement newProjectButton;

    public void openPage() {
        DriverUtils.driver.get(Configuration.ENVIRONMENT + "/create");
    }

    public String getHeaderText() {
        WebElement headerText = DriverUtils.driver.findElement(By.cssSelector("[data-test=\"create-search-text\"]"));
        return headerText.getText();
    }

    public void clickNewProjectButton() {
        newProjectButton.click();
    }
}
