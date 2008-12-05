package com.heraclitus.springsecuritywebapp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * I contain end-to-end acceptance/functional tests for the simple web
 * application with spring security.
 * 
 * I specifically contain tests that verify the behaviour of UserStory 9.
 */
public class UserStory9AcceptanceTest {
    
    private WebDriver driver = new FirefoxDriver();
    
    @After
    public void aTearDownMethodForEachTest() {
        // close firefox browser that was launched after each test
        driver.close();
    }
    
    @Test
    public void shouldOnlyAllowOneConcurrentSessionPerUser() throws Exception {
        
        driver.get("http://localhost:8080/springsecuritywebapp/login.jsp");
        
        // login on login page
        final WebElement usernameField = driver.findElement(By
                .name("j_username"));
        usernameField.sendKeys("test");
        
        final WebElement passwordField = driver.findElement(By
                .name("j_password"));
        passwordField.sendKeys("test");
        
        passwordField.submit();
        
        // close browser session
        driver.close();
        
        driver = new FirefoxDriver();
        // try to log in again.
        driver.get("http://localhost:8080/springsecuritywebapp/login.jsp");
        
        // login on login page
        final WebElement usernameField2 = driver.findElement(By
                .name("j_username"));
        usernameField2.sendKeys("test");
        
        final WebElement passwordField2 = driver.findElement(By
                .name("j_password"));
        passwordField2.sendKeys("test");
        
        passwordField2.submit();
        
        assertThat(driver.getTitle(),
                is("Login: Spring Security Web Application"));
        
        final WebElement informationMessageSection = driver.findElement(By
                .id("infomessage"));
        assertThat(
                informationMessageSection.getText(),
                containsString("Login failed due to: Maximum sessions of 1 for this principal exceeded."));
    }
}