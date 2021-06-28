import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PricingTest {
    String driverPath = "/Users/annapoghosyann/Downloads/chromedriver";
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void checkPricing() {
        driver.get("https://picsart.com/");

        WebElement pricingButton = driver.findElement(By.cssSelector("li[data-test=\"headerNavigation-navigationListItem-Pricing\"] [class*='pa-uiLib-headerNavigation-url']"));
        System.out.println(pricingButton.getText());
        pricingButton.click();

        WebElement goldTitle = driver.findElement(By.cssSelector(".gold-pricing-title"));
        String goldTitleText = goldTitle.getText();

        System.out.println(goldTitleText.equals("Try PicsArt Gold Free for 7-Days"));
    }

    @AfterMethod
    public void kill() {
        driver.close();
        driver.quit();
    }
}
