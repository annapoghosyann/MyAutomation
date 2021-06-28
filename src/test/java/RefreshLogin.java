import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class RefreshLogin {
    String driverPath = "/Users/annapoghosyann/Downloads/chromedriver";
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void checkLogin() {
        driver.get("https://picsartstage2.com/");
        driver.manage().addCookie(new Cookie("user_key", "b6409bcb-3cc8-4644-9eb4-897da417ca2d"));
        driver.navigate().refresh();

    }

    @AfterMethod
    public void kill() {
        driver.close();
        driver.quit();
    }
}