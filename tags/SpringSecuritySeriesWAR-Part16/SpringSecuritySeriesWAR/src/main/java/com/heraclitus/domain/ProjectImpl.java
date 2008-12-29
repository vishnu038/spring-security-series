package com.heraclitus.domain;

import java.io.Serializable;

/**
 * immutable implementation of {@link Project}.
 */
public class ProjectImpl implements Project, Serializable {
    
    private final Long id;
    private final String name;
    private final String description;
    
    public ProjectImpl(final Long id, final String name,
            final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
}
