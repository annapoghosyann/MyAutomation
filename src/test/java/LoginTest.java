import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    String driverPath = "/Users/annapoghosyann/Downloads/chromedriver";
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void checkLogin() throws InterruptedException {
        driver.get("https://picsartstage2.com/");

        WebElement loginMainButton = driver.findElement(By.cssSelector("[href=\"/sign-in\"]"));
        loginMainButton.click();

        WebElement loginField = driver.findElement(By.cssSelector("[class=pa-uiLib-inputWrapper] [name='username']"));
        loginField.sendKeys("repbea");

        WebElement passwordField = driver.findElement(By.cssSelector("[class=pa-uiLib-inputWrapper] [name='password']"));
        passwordField.sendKeys("123457");

        WebElement loginButton = driver.findElement(By.cssSelector("[class=\"pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn\"]"));
        loginButton.click();

        WebElement accountPhoto = driver.findElement(By.cssSelector("[class*=\"placeholder image-main\"]"));

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(accountPhoto));
//        Thread.sleep(5000);
        System.out.println(accountPhoto.isDisplayed());

    }

    @AfterMethod
    public void kill() {
        driver.close();
        driver.quit();
    }
}
