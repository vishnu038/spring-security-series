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
    
}