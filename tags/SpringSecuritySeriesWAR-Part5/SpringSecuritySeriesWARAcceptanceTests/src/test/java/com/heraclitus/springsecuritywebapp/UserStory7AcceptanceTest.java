package com.heraclitus.springsecuritywebapp;

import static com.heraclitus.springsecuritywebapp.dsl.NavigatingSpringSecurityWebApp.login;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * I contain end-to-end acceptance/functional tests for the simple web
 * application with spring security.
 * 
 * I specifically contain tests that verify the behaviour of UserStory 7.
 */
public class UserStory7AcceptanceTest {
    
    private final WebDriver driver = new FirefoxDriver();
    
    @After
    public void aTearDownMethodForEachTest() {
        // close firefox browser that was launched after each test
        driver.close();
    }
    
    @Test
    public void shouldBeAbleToSeeCommonNavigationOnAdminPage() {
        
        // try to access admin
        driver.get("http://localhost:8080/springsecuritywebapp/admin.htm");
        
        login(driver);
        
        // verify
        assertThat(driver.getTitle(),
                is("Admin: Spring Security Web Application"));
        assertNotNull(driver.findElement(By.linkText("Home")));
        assertNotNull(driver.findElement(By.linkText("Admin")));
        assertNotNull(driver.findElement(By.linkText("Logout")));
        
    }
    
    @Test
    public void shouldBeAbleToSeeCommonNavigationOnHomePage() {
        
        // try to access admin
        driver.get("http://localhost:8080/springsecuritywebapp/home.htm");
        
        login(driver);
        
        // verify
        assertThat(driver.getTitle(),
                is("Home: Spring Security Web Application"));
        assertNotNull(driver.findElement(By.linkText("Home")));
        assertNotNull(driver.findElement(By.linkText("Admin")));
        assertNotNull(driver.findElement(By.linkText("Logout")));
        
    }
}