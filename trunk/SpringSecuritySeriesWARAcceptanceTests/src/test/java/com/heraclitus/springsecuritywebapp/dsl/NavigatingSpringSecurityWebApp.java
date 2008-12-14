package com.heraclitus.springsecuritywebapp.dsl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * I contain convenience methods for navigating the spring security web app.
 */
public class NavigatingSpringSecurityWebApp {
    
    public static void login(final WebDriver driver) {
        // login on login page
        final WebElement usernameField = driver.findElement(By
                .name("j_username"));
        usernameField.sendKeys("username");
        
        final WebElement passwordField = driver.findElement(By
                .name("j_password"));
        passwordField.sendKeys("password");
        
        passwordField.submit();
    }
    
    public static void loginAsUser(final WebDriver driver, final User user) {
        
        driver.get("http://localhost:8080/springsecuritywebapp/login.jsp");
        
        // login on login page
        final WebElement usernameField = driver.findElement(By
                .name("j_username"));
        usernameField.sendKeys(user.username());
        
        final WebElement passwordField = driver.findElement(By
                .name("j_password"));
        passwordField.sendKeys(user.password());
        
        passwordField.submit();
    }
    
    public static void logout(final WebDriver driver) {
        final WebElement logoutLink = driver.findElement(By.linkText("Logout"));
        logoutLink.click();
    }
    
}