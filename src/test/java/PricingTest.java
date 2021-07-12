import config.CreatePage;
import config.DriverUtils;
import config.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PricingTest {

    @BeforeMethod
    public void initDriver(){
        DriverUtils.initDriver();
        HomePage homePage = new HomePage();
        homePage.openPage();
        DriverUtils.driver.manage().addCookie(new Cookie("we_experiment_create_page_variant","0"));
    }

    @Test
    public void checkPricing() {
        CreatePage createPage = new CreatePage();
        createPage.openPage();

        WebElement pricingButton = DriverUtils.driver.findElement(By.cssSelector("li[data-test=\"headerNavigation-navigationListItem-Pricing\"] [class*='pa-uiLib-headerNavigation-url']"));
        System.out.println(pricingButton.getText());
        pricingButton.click();

        WebElement goldTitle = DriverUtils.driver.findElement(By.cssSelector(".gold-pricing-title"));
        String goldTitleText = goldTitle.getText();

        System.out.println(goldTitleText.equals("Try PicsArt Gold Free for 7-Days"));
    }

    @AfterMethod
    public void killDriver() throws InterruptedException {
        DriverUtils.killDriver();
    }
}
