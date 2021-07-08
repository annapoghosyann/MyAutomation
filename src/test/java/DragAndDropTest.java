import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.swing.*;
import java.util.ArrayList;

public class DragAndDropTest {
    String driverPath = "/Users/annapoghosyann/Downloads/chromedriver";
    WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() throws InterruptedException{
        driver.get("https://picsartstage2.com/create");
        WebDriverWait wait = new WebDriverWait(driver,50);

        WebElement instaStoryButton = driver.findElement(By.cssSelector("[class*=\"pwCreateDesignContainer\"][data-test='insta-story']"));
        wait.until(ExpectedConditions.visibilityOf(instaStoryButton));
        new Actions(driver).moveToElement(instaStoryButton).click().build().perform();

        String s = new ArrayList<>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(s);
        cookiePolicy();
        driver.navigate().refresh();

        WebElement photosCategory = driver.findElement(By.cssSelector("[id=\"photos-category\"]"));
        wait.until(ExpectedConditions.visibilityOf(photosCategory)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class*='pa-uiLib-sidebar-sidebarItem']"))).click();


        Thread.sleep(10000);
        WebElement chosenPhoto = driver.findElement(By.cssSelector("[data-test=\"canvas-container\"]"));
//        chosenPhoto.click();
        new Actions(driver).moveToElement(chosenPhoto).click().build().perform();

        new Actions(driver).dragAndDropBy(chosenPhoto, 10, 20).perform();

        }

        public void cookiePolicy() {
        driver.manage().addCookie(new Cookie("user_key", "b6409bcb-3cc8-4644-9eb4-897da417ca2d"));
        driver.manage().addCookie(new Cookie("we-editor-first-open", "true"));
        driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed", "2021-06-26T13:47:26.654Z"));
        driver.manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        driver.navigate().refresh();
    }


    @AfterMethod
    public void kill() throws InterruptedException {
        Thread.sleep(7000);
        driver.close();
        driver.quit();
    }
}
