package com.heraclitus.service;

import java.util.List;

import org.springframework.security.annotation.Secured;

import com.heraclitus.domain.Project;

/**
 * I contain business behaviour related to {@link Project}'s.
 */
public interface ProjectService {
    
    @Secured( { "ROLE_USER" })
    List<Project> findAllProjects();
    
}
