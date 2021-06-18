import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FirstTest {
    String driverPath = "/Users/annapoghosyann/Downloads/chromedriver";
    WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.get("https://picsart.com/");
        WebElement element = driver.findElement(By.cssSelector(".home-title-0-2-6"));
        String text = element.getText();
        System.out.println(text);

        WebElement element1 = driver.findElement(By.cssSelector("[data-test=\"headerNavigation-navigationListItem-Create\"]>a"));
        element1.click();

        WebElement element2 = driver.findElement(By.cssSelector("[class*='createDesignHeader'] [class*='bottomText']"));
        String text2 = element2.getText();
        System.out.println(text2);
    }

    @AfterMethod
    public void kill(){
        driver.close();
        driver.quit();
    }
}
