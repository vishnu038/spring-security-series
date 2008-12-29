package com.heraclitus.domain.acl;

/**
 * 
 */
public class AclEntryImmutable implements AclEntry {
    
    private final Integer aceOrder;
    private final Long aclObjectIdentity;
    private final boolean auditFailure;
    private final boolean auditSuccess;
    private final boolean granting;
    private final Long id;
    private final Integer mask;
    private final Long sid;
    
    public AclEntryImmutable(final Long id, final Long aclObjectIdentity,
            final Integer aceOrder, final Long sid, final Integer mask,
            final boolean granting, final boolean auditSuccess,
            final boolean auditFailure) {
        this.id = id;
        this.aclObjectIdentity = aclObjectIdentity;
        this.aceOrder = aceOrder;
        this.sid = sid;
        this.mask = mask;
        this.granting = granting;
        this.auditSuccess = auditSuccess;
        this.auditFailure = auditFailure;
    }
    
    public Integer getAceOrder() {
        return aceOrder;
    }
    
    public Long getAclObjectIdentity() {
        return aclObjectIdentity;
    }
    
    public Long getId() {
        return id;
    }
    
    public Integer getMask() {
        return mask;
    }
    
    public Long getSid() {
        return sid;
    }
    
    public boolean isAuditFailure() {
        return auditFailure;
    }
    
    public boolean isAuditSuccess() {
        return auditSuccess;
    }
    
    public boolean isGranting() {
        return granting;
    }
    
}
