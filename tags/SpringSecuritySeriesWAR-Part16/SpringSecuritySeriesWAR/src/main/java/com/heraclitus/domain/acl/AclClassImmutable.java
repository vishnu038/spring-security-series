package com.heraclitus.domain.acl;

/**
 * immutable implementation of {@link AclClass}.
 */
public class AclClassImmutable implements AclClass {
    
    private final String fullyQualifiedClassName;
    private final Long id;
    
    public AclClassImmutable(final Long id, final String fullyQualifiedClassName) {
        this.id = id;
        this.fullyQualifiedClassName = fullyQualifiedClassName;
    }
    
    public String getFullyQualifiedClassName() {
        return fullyQualifiedClassName;
    }
    
    public Long getId() {
        return id;
    }
}
