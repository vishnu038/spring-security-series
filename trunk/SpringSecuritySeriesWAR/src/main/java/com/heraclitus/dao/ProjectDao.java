package com.heraclitus.dao;

import java.util.List;

import com.heraclitus.domain.Project;

/**
 * I define data access methods related to {@link Project}.
 */
public interface ProjectDao {
    
    List<Project> findAllProjects();
    
}
