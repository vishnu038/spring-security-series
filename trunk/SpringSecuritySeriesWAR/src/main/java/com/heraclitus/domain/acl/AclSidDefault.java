package com.heraclitus.domain.acl;


/**
 * default implementation of {@link AclSid}.
 */
public class AclSidDefault implements AclSid {
    
    private final Long id;
    private final boolean principal;
    private final String sid;
    
    public AclSidDefault(final Long id, final boolean principal,
            final String sid) {
        this.id = id;
        this.principal = principal;
        this.sid = sid;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getSid() {
        return sid;
    }
    
    public boolean isPrincipal() {
        return principal;
    }
    
}
