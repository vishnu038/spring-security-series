package com.heraclitus.domain.acl;

/**
 * 
 */
public interface AclObjectIdentity {
    
    public Long getId();
    
    public Long getObjectIdClass();
    
    public Long getObjectIdIdentity();
    
    public Long getOwnerSid();
    
    public Long getParentObject();
    
    public boolean isEntriesInheriting();
}
