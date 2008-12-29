package com.heraclitus.springsecuritywebapp;

import static com.heraclitus.springsecuritywebapp.dsl.NavigatingSpringSecurityWebApp.login;
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
 * I specifically contain tests that verify the behaviour of UserStory 8.
 */
public class UserStory8AcceptanceTest {
    
    private final WebDriver driver = new FirefoxDriver();
    
    @After
    public void aTearDownMethodForEachTest() {
        // close firefox browser that was launched after each test
        driver.close();
    }
    
    @Test
    public void shouldBeAbleToLogoutOfApplicationAndSeeMessageThatConfirmsThis() {
        
        // try to access admin
        driver.get("http://localhost:8080/springsecuritywebapp/home.htm");
        
        login(driver);
        
        // verify
        final WebElement logoutLink = driver.findElement(By.linkText("Logout"));
        logoutLink.click();
        
        assertThat(driver.getTitle(),
                is("Login: Spring Security Web Application"));
        
        final WebElement informationMessageSection = driver.findElement(By
                .id("infomessage"));
        assertThat(informationMessageSection.getText(),
                containsString("You have been successfully logged out."));
    }
}