package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtils {

    public static String driverPath = "/Users/annapoghosyann/Downloads/chromedriver";
    public static WebDriver driver;

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    public static void killDriver() throws InterruptedException {
        Thread.sleep(7000);
        driver.close();
        driver.quit();
    }
}
