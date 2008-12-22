package com.heraclitus.domain.acl;


/**
 * to represent ACL_SID table
 */
public interface AclSid {
    
    public Long getId();
    
    public String getSid();
    
    public boolean isPrincipal();
    
}
