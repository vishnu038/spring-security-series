package com.heraclitus.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.ui.TargetUrlResolver;

import com.heraclitus.domain.Role;
import com.heraclitus.web.spring.security.stubs.AuthenticationConfigurableStub;
import com.heraclitus.web.spring.security.stubs.GrantedAuthorityConfigurableStub;

/**
 * I test {@link RoleBasedTargetUrlResolverImpl}.
 */
@SuppressWarnings("synthetic-access")
@RunWith(JMock.class)
public class RoleBasedTargetUrlResolverImplTest {
    
    // collaborators/peers
    private TargetUrlResolver fallbackTargetUrlResolver;
    
    // mockery
    private final Mockery mockery = new JUnit4Mockery();
    
    // class under test
    private RoleBasedTargetUrlResolverImpl roleBasedTargetUrlResolver;
    
    @Before
    public void setupTestMethod() {
        fallbackTargetUrlResolver = mockery.mock(TargetUrlResolver.class);
        
        roleBasedTargetUrlResolver = new RoleBasedTargetUrlResolverImpl(
                fallbackTargetUrlResolver);
    }
    
    @Test
    public void shouldDelegateToFallbackTargetResolverWhenAdminAuthorityDoesNotExist() {
        
        // setup
        final GrantedAuthority userAuthority = new GrantedAuthorityConfigurableStub(
                Role.USER_ROLE);
        final GrantedAuthority[] authorities = new GrantedAuthority[] { userAuthority };
        
        final Authentication auth = new AuthenticationConfigurableStub(
                authorities);
        
        // behavior verification
        mockery.checking(new Expectations() {
            {
                one(fallbackTargetUrlResolver).determineTargetUrl(null, null,
                        auth);
                will(returnValue("/anyTargetUrl"));
            }
        });
        
        // exercise test
        final String determinedTargetUrl = roleBasedTargetUrlResolver
                .determineTargetUrl(null, null, auth);
        
        // state verification
        assertThat(determinedTargetUrl, is("/anyTargetUrl"));
    }
    
    @Test
    public void shouldReturnAdminTargetUrlWhenAdminAuthorityExists() {
        
        // setup
        final GrantedAuthority adminAuthority = new GrantedAuthorityConfigurableStub(
                Role.ADMIN_ROLE);
        final GrantedAuthority[] authorities = new GrantedAuthority[] { adminAuthority };
        
        final Authentication auth = new AuthenticationConfigurableStub(
                authorities);
        
        // exercise test
        final String determinedTargetUrl = roleBasedTargetUrlResolver
                .determineTargetUrl(null, null, auth);
        
        // state verification
        assertThat(determinedTargetUrl, is("/admin.htm"));
    }
}
