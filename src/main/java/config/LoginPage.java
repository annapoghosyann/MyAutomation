package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public void login(String username, String password){
        WebDriverWait wait = new WebDriverWait(DriverUtils.driver,50);

        WebElement loginMainButton = DriverUtils.driver.findElement(By.cssSelector("[href=\"/sign-in\"]"));
        wait.until(ExpectedConditions.visibilityOf(loginMainButton));
        loginMainButton.click();

        WebElement loginField = DriverUtils.driver.findElement(By.cssSelector("[class=pa-uiLib-inputWrapper] [name='username']"));
        loginField.sendKeys(username);

        WebElement passwordField = DriverUtils.driver.findElement(By.cssSelector("[class=pa-uiLib-inputWrapper] [name='password']"));
        passwordField.sendKeys(password);

        WebElement loginButton = DriverUtils.driver.findElement(By.cssSelector("[class=\"pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn\"]"));
        loginButton.click();
    }
}
