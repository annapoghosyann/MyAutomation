import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveCookiePolicy {
    String driverPath = "/Users/annapoghosyann/Downloads/chromedriver";
    WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.get("https://picsartstage2.com/");

        driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed","2021-06-28T11:19:39.118Z"));

        driver.navigate().refresh();

    }

    @AfterMethod
    public void kill(){
        driver.close();
        driver.quit();
    }
}
