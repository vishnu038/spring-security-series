package com.heraclitus.springsecuritywebapp;

import static com.heraclitus.springsecuritywebapp.dsl.NavigatingSpringSecurityWebApp.login;
import static com.heraclitus.springsecuritywebapp.dsl.NavigatingSpringSecurityWebApp.loginAsUser;
import static com.heraclitus.springsecuritywebapp.dsl.NavigatingSpringSecurityWebApp.logout;
import static com.heraclitus.springsecuritywebapp.dsl.UsersOnSpringSecurityWebApp.withAdminRole;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        
        loginAsUser(driver, withAdminRole());
        
        // verify
        assertThat(driver.getTitle(),
                is("Admin: Spring Security Web Application"));
        assertNotNull(driver.findElement(By.linkText("Home")));
        assertNotNull(driver.findElement(By.linkText("Admin")));
        assertNotNull(driver.findElement(By.linkText("Logout")));
        
        logout(driver);
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
        assertNotNull(driver.findElement(By.linkText("Logout")));
        
        logout(driver);
        
    }
    
    @Test
    public void shouldBeAbleToViewUsernameOfUserOnAdminPageWhenSuccessfullyAuthenticated() {
        loginAsUser(driver, withAdminRole());
        
        // state verification
        assertThat(driver.getTitle(),
                is("Admin: Spring Security Web Application"));
        assertThat(driver.findElement(By.id("loginstatus")).getText(),
                containsString("Logged in as: admin"));
        
        logout(driver);
    }
    
    @Test
    public void shouldBeAbleToViewUsernameOfUserOnHomePageWhenSuccessfullyAuthenticated() {
        
        driver.get("http://localhost:8080/springsecuritywebapp/home.htm");
        login(driver);
        
        // state verification
        assertThat(driver.getTitle(),
                is("Home: Spring Security Web Application"));
        assertThat(driver.findElement(By.id("loginstatus")).getText(),
                containsString("Logged in as: username"));
        
        logout(driver);
    }
    
    @Test
    public void shouldNotBeAbleToSeeAdminLinkOnCommonNavigationWhenNotLoggedInAsStandardUser() {
        
        driver.get("http://localhost:8080/springsecuritywebapp/home.htm");
        login(driver);
        
        // verify
        assertThat(driver.getTitle(),
                is("Home: Spring Security Web Application"));
        
        try {
            driver.findElement(By.linkText("Admin"));
            fail("should not be able to see a link to admin page when logged in as standard user");
        } catch (final NoSuchElementException e) {
            assertNotNull(e);
        }
        
        logout(driver);
    }
}