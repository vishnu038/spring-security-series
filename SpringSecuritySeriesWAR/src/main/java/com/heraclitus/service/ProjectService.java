package com.heraclitus.service;

import java.util.List;

import com.heraclitus.domain.Project;

/**
 * I contain business behaviour related to {@link Project}'s.
 */
public interface ProjectService {
    
    List<Project> findAllProjects();
    
}
