import config.CreatePage;
import config.DriverUtils;
import config.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class FirstTest {

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

        WebElement element = DriverUtils.driver.findElement(By.cssSelector(".home-title-0-2-6"));
        String text = element.getText();
        System.out.println(text);

        WebElement element1 = DriverUtils.driver.findElement(By.cssSelector("[data-test=\"headerNavigation-navigationListItem-Create\"]>a"));
        element1.click();

        WebElement element2 = DriverUtils.driver.findElement(By.cssSelector("[class*='createDesignHeader'] [class*='bottomText']"));
        String text2 = element2.getText();
        System.out.println(text2);
    }

    @AfterMethod
    public void killDriver() throws InterruptedException {
        DriverUtils.killDriver();
    }
}
