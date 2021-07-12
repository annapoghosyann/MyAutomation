import config.CreatePage;
import config.DriverUtils;
import config.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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

    @BeforeMethod
    public void initDriver(){
        DriverUtils.initDriver();
        HomePage homePage = new HomePage();
        homePage.openPage();
        DriverUtils.driver.manage().addCookie(new Cookie("we_experiment_create_page_variant","0"));
    }

    @Test
    public void checkLogin() throws InterruptedException {
        CreatePage createPage = new CreatePage();
        createPage.openPage();

        WebElement loginMainButton = DriverUtils.driver.findElement(By.cssSelector("[href=\"/sign-in\"]"));
        loginMainButton.click();

        WebElement loginField = DriverUtils.driver.findElement(By.cssSelector("[class=pa-uiLib-inputWrapper] [name='username']"));
        loginField.sendKeys("repbea");

        WebElement passwordField = DriverUtils.driver.findElement(By.cssSelector("[class=pa-uiLib-inputWrapper] [name='password']"));
        passwordField.sendKeys("123457");

        WebElement loginButton = DriverUtils.driver.findElement(By.cssSelector("[class=\"pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn\"]"));
        loginButton.click();

        WebElement accountPhoto = DriverUtils.driver.findElement(By.cssSelector("[class*=\"placeholder image-main\"]"));

        WebDriverWait webDriverWait = new WebDriverWait(DriverUtils.driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(accountPhoto));
//        Thread.sleep(5000);
        System.out.println(accountPhoto.isDisplayed());

    }

    @AfterMethod
    public void killDriver() throws InterruptedException {
        DriverUtils.killDriver();
    }
}
