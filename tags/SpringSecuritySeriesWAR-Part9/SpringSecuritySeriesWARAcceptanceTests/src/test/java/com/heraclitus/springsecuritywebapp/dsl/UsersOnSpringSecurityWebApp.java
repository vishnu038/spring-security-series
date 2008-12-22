package com.heraclitus.springsecuritywebapp.dsl;

/**
 * I contain conenvience methods for returning users that are configured in
 * applicationContext-security's userDetailsService bean.
 */
public class UsersOnSpringSecurityWebApp {
    
    public static User withAdminRole() {
        return new UserImpl("admin", "admin");
    }
}
