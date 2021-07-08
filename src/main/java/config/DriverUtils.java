package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtils {

    public static String driverPath = "/Users/annapoghosyann/Downloads/chromedriver";
    public static WebDriver driver;

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    public void killDriver() throws InterruptedException {
        Thread.sleep(7000);
        driver.close();
        driver.quit();
    }
}
