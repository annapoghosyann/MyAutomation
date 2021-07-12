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

public class RemoveCookiePolicy {

    @BeforeMethod
    public void initDriver(){
        DriverUtils.initDriver();
        HomePage homePage = new HomePage();
        homePage.openPage();
        DriverUtils.driver.manage().addCookie(new Cookie("we_experiment_create_page_variant","0"));
    }

    @Test
    public void myFirstTest() {
        CreatePage createPage = new CreatePage();
        createPage.openPage();

        DriverUtils.driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed","2021-06-28T11:19:39.118Z"));
        DriverUtils.driver.navigate().refresh();

    }

    @AfterMethod
    public void killDriver() throws InterruptedException {
        DriverUtils.killDriver();
    }
}
