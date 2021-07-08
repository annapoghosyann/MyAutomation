package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage {
    public static void openPage() {
        DriverUtils.driver.get(Configuration.ENVIRONMENT+"create/editor?templateSize=inst_profile");
    }
    public static void dragAndDropPhoto() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(DriverUtils.driver,50);
        WebElement photosCategory = DriverUtils.driver.findElement(By.cssSelector("[id=\"photos-category\"]"));
        wait.until(ExpectedConditions.visibilityOf(photosCategory)).click();


        System.out.println("Anna");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class*='pa-uiLib-sidebar-sidebarItem']"))).click();


        Thread.sleep(10000);
        WebElement chosenPhoto = DriverUtils.driver.findElement(By.cssSelector("[data-test=\"canvas-container\"]"));
//        chosenPhoto.click();
        new Actions(DriverUtils.driver).moveToElement(chosenPhoto).click().build().perform();

        new Actions(DriverUtils.driver).dragAndDropBy(chosenPhoto, 10, 20).perform();
    }
}
