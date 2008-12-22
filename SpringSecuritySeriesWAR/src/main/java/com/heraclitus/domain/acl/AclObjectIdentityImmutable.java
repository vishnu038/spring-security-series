package com.heraclitus.domain.acl;

/**
 * Immutable implementation of {@link AclObjectIdentity}.
 */
public class AclObjectIdentityImmutable implements AclObjectIdentity {
    
    private final boolean entriesInheriting;
    private final Long id;
    
    private final Long objectIdClass;
    
    private final Long objectIdIdentity;
    
    private final Long ownerSid;
    
    private final Long parentObject;
    
    public AclObjectIdentityImmutable(final Long id, final Long objectIdClass,
            final Long objectIdIdentity, final Long parentObject,
            final Long ownerSid, final boolean entriesInheriting) {
        this.id = id;
        this.objectIdClass = objectIdClass;
        this.objectIdIdentity = objectIdIdentity;
        this.parentObject = parentObject;
        this.ownerSid = ownerSid;
        this.entriesInheriting = entriesInheriting;
    }
    
    public Long getId() {
        return id;
    }
    
    public Long getObjectIdClass() {
        return objectIdClass;
    }
    
    public Long getObjectIdIdentity() {
        return objectIdIdentity;
    }
    
    public Long getOwnerSid() {
        return ownerSid;
    }
    
    public Long getParentObject() {
        return parentObject;
    }
    
    public boolean isEntriesInheriting() {
        return entriesInheriting;
    }
    
}
