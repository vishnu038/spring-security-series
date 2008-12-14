package com.heraclitus.web.spring.security.stubs;

import org.springframework.security.GrantedAuthority;

import com.heraclitus.domain.Role;

/**
 * I am a test stub for {@link GrantedAuthority}.
 */
public class GrantedAuthorityConfigurableStub implements GrantedAuthority {
    
    private final Role role;
    
    public GrantedAuthorityConfigurableStub(final Role role) {
        this.role = role;
    }
    
    public int compareTo(final Object o) {
        return 0;
    }
    
    public String getAuthority() {
        return role.roleName();
    }
    
}
