package com.heraclitus.springsecuritywebapp.dsl;

/**
 * default implementation of {@link User}.
 */
public class UserImpl implements User {
    
    private final String password;
    private final String username;
    
    public UserImpl(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
    
    public String password() {
        return password;
    }
    
    public String username() {
        return username;
    }
    
}
