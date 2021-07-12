import config.CreatePage;
import config.DriverUtils;
import config.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollTest {

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

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));"
                + "return true;";
        WebElement element = DriverUtils.driver.findElement(By.cssSelector("[data-test=\"facebook-post\"]"));
        ((JavascriptExecutor)DriverUtils.driver).executeAsyncScript(scrollElementIntoMiddle,element);


    }

    @AfterMethod
    public void killDriver() throws InterruptedException {
        DriverUtils.killDriver();
    }
}