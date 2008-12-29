package com.heraclitus.web.spring.security.stubs;

import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;

/**
 * Test stub of an {@link Authentication}.
 */
public class AuthenticationConfigurableStub implements Authentication {
    
    private final GrantedAuthority[] authorities;
    
    public AuthenticationConfigurableStub(final GrantedAuthority[] authorities) {
        this.authorities = authorities;
    }
    
    public GrantedAuthority[] getAuthorities() {
        return authorities;
    }
    
    public Object getCredentials() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public Object getDetails() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public Object getPrincipal() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public boolean isAuthenticated() {
        return true;
    }
    
    public void setAuthenticated(final boolean isAuthenticated)
            throws IllegalArgumentException {
        // TODO Auto-generated method stub
        
    }
    
}
