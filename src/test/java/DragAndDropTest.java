import config.CreatePage;
import config.DriverUtils;
import config.HomePage;
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

    @BeforeMethod
    public void initDriver(){
        DriverUtils.initDriver();
        HomePage homePage = new HomePage();
        homePage.openPage();
        DriverUtils.driver.manage().addCookie(new Cookie("we_experiment_create_page_variant","0"));
    }

    @Test
    public void myFirstTest() throws InterruptedException{
        CreatePage createPage = new CreatePage();
        createPage.openPage();

        WebDriverWait wait = new WebDriverWait(DriverUtils.driver,50);

        WebElement instaStoryButton = DriverUtils.driver.findElement(By.cssSelector("[class*=\"pwCreateDesignContainer\"][data-test='insta-story']"));
        wait.until(ExpectedConditions.visibilityOf(instaStoryButton));
        new Actions(DriverUtils.driver).moveToElement(instaStoryButton).click().build().perform();

        String s = new ArrayList<>(DriverUtils.driver.getWindowHandles()).get(1);
        DriverUtils.driver.switchTo().window(s);
        cookiePolicy();
        DriverUtils.driver.navigate().refresh();

        WebElement photosCategory = DriverUtils.driver.findElement(By.cssSelector("[id=\"photos-category\"]"));
        wait.until(ExpectedConditions.visibilityOf(photosCategory)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class*='pa-uiLib-sidebar-sidebarItem']"))).click();


        Thread.sleep(10000);
        WebElement chosenPhoto = DriverUtils.driver.findElement(By.cssSelector("[data-test=\"canvas-container\"]"));
//        chosenPhoto.click();
        new Actions(DriverUtils.driver).moveToElement(chosenPhoto).click().build().perform();

        new Actions(DriverUtils.driver).dragAndDropBy(chosenPhoto, 10, 20).perform();

        }

        public void cookiePolicy() {
            DriverUtils.driver.manage().addCookie(new Cookie("user_key", "b6409bcb-3cc8-4644-9eb4-897da417ca2d"));
            DriverUtils.driver.manage().addCookie(new Cookie("we-editor-first-open", "true"));
            DriverUtils.driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed", "2021-06-26T13:47:26.654Z"));
            DriverUtils.driver.manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
            DriverUtils.driver.navigate().refresh();
    }


    @AfterMethod
    public void killDriver() throws InterruptedException {
        DriverUtils.killDriver();
    }
}
