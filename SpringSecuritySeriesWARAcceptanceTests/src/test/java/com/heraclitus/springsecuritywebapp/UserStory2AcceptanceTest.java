package com.heraclitus.springsecuritywebapp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
 * I specifically contain tests that verify the behaviour of UserStory 2.
 */
public class UserStory2AcceptanceTest {
    
    private final WebDriver driver = new FirefoxDriver();
    
    @After
    public void aTearDownMethodForEachTest() {
        // close firefox browser that was launched after each test
        driver.close();
    }
    
    @Test
    public void shouldBeAbleToViewHomePageWhenSuccessfullyAuthenticated() {
        
        // try to get to home.htm
        driver.get("http://localhost:8080/springsecuritywebapp/home.htm");
        
        // check we are on our custom login page
        assertThat(driver.getTitle(),
                is("Login: Spring Security Web Application"));
        
        final WebElement usernameField = driver.findElement(By
                .name("j_username"));
        usernameField.sendKeys("username");
        
        final WebElement passwordField = driver.findElement(By
                .name("j_password"));
        passwordField.sendKeys("password");
        
        passwordField.submit();
        
        // state verification
        assertThat(driver.getTitle(),
                is("Home: Spring Security Web Application"));
    }
}