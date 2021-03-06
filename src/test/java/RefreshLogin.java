import config.CreatePage;
import config.DriverUtils;
import config.HomePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class RefreshLogin {

    @BeforeMethod
    public void initDriver(){
        DriverUtils.initDriver();
        HomePage homePage = new HomePage();
        homePage.openPage();
        DriverUtils.driver.manage().addCookie(new Cookie("we_experiment_create_page_variant","0"));
    }

    @Test
    public void checkLogin() {
        CreatePage createPage = new CreatePage();
        createPage.openPage();

        DriverUtils.driver.manage().addCookie(new Cookie("user_key", "b6409bcb-3cc8-4644-9eb4-897da417ca2d"));
        DriverUtils.driver.navigate().refresh();
    }

    @AfterMethod
    public void killDriver() throws InterruptedException {
        DriverUtils.killDriver();
    }
}