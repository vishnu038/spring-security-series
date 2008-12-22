package com.heraclitus.domain.acl;

/**
 * 
 */
public interface AclEntry {
    
    public Integer getAceOrder();
    
    public Long getAclObjectIdentity();
    
    public Long getId();
    
    public Integer getMask();
    
    public Long getSid();
    
    public boolean isAuditFailure();
    
    public boolean isAuditSuccess();
    
    public boolean isGranting();
    
}
