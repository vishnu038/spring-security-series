package com.heraclitus.springsecuritywebapp;

import static com.heraclitus.springsecuritywebapp.dsl.NavigatingSpringSecurityWebApp.logout;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
 * I specifically contain tests that verify the behaviour of UserStory 5.
 */
public class UserStory5AcceptanceTest {
    
    private final WebDriver driver = new FirefoxDriver();
    
    @After
    public void aTearDownMethodForEachTest() {
        // close firefox browser that was launched after each test
        driver.close();
    }
    
    @Test
    public void shouldForwardUserToPageTheyAttemptedToReachPreviouslyAfterSuccessfulLogin() {
        
        // try to access admin
        driver.get("http://localhost:8080/springsecuritywebapp/admin.htm");
        
        // login on login page
        final WebElement usernameField = driver.findElement(By
                .name("j_username"));
        usernameField.sendKeys("admin");
        
        final WebElement passwordField = driver.findElement(By
                .name("j_password"));
        passwordField.sendKeys("admin");
        
        passwordField.submit();
        
        // verify we are not at admin and not (home)
        assertThat(driver.getTitle(),
                is(not("Home: Spring Security Web Application")));
        assertThat(driver.getTitle(),
                is("Admin: Spring Security Web Application"));
        
        // teardown
        logout(driver);
        
    }
    
    @Test
    public void shouldRemainOnLoginPageWithInformativeMessageWhenAuthenticationFailsDueToIncorrectPassword() {
        
        // try to get to home.htm
        driver.get("http://localhost:8080/springsecuritywebapp/login.jsp");
        
        final WebElement usernameField = driver.findElement(By
                .name("j_username"));
        usernameField.sendKeys("username");
        
        final WebElement passwordField = driver.findElement(By
                .name("j_password"));
        passwordField.sendKeys("incorrect_password");
        
        passwordField.submit();
        
        // state verification
        assertThat(driver.getTitle(),
                is("Login: Spring Security Web Application"));
        
        final WebElement informationMessageSection = driver.findElement(By
                .id("infomessage"));
        assertThat(informationMessageSection.getText(),
                containsString("Login failed due to: Bad credentials."));
    }
    
    @Test
    public void shouldRemainOnLoginPageWithInformativeMessageWhenAuthenticationFailsDueToIncorrectUsername() {
        
        // try to get to home.htm
        driver.get("http://localhost:8080/springsecuritywebapp/login.jsp");
        
        final WebElement usernameField = driver.findElement(By
                .name("j_username"));
        usernameField.sendKeys("username_does_not_exist");
        
        final WebElement passwordField = driver.findElement(By
                .name("j_password"));
        passwordField.sendKeys("password");
        
        passwordField.submit();
        
        // state verification
        assertThat(driver.getTitle(),
                is("Login: Spring Security Web Application"));
        
        final WebElement informationMessageSection = driver.findElement(By
                .id("infomessage"));
        assertThat(
                informationMessageSection.getText(),
                containsString("Login failed due to: Could not find user: username_does_not_exist."));
    }
    
    @Test
    public void shouldRemainOnLoginPageWithUsernameStillPopulatedWhenAuthenticationFails() {
        
        // try to get to home.htm
        driver.get("http://localhost:8080/springsecuritywebapp/login.jsp");
        
        final WebElement usernameField = driver.findElement(By
                .name("j_username"));
        usernameField.sendKeys("username_does_not_exist");
        
        final WebElement passwordField = driver.findElement(By
                .name("j_password"));
        passwordField.sendKeys("password");
        
        passwordField.submit();
        
        // state verification
        assertThat(driver.getTitle(),
                is("Login: Spring Security Web Application"));
        
        final WebElement username = driver.findElement(By.name("j_username"));
        
        assertThat(username.getValue(), is("username_does_not_exist"));
    }
    
}