package com.heraclitus.service.impl;

import java.util.List;

import com.heraclitus.dao.ProjectDao;
import com.heraclitus.domain.Project;
import com.heraclitus.service.ProjectService;

/**
 * default implementation of {@link ProjectService}.
 */
public class ProjectServiceImpl implements ProjectService {
    
    private ProjectDao projectDao;
    
    public List<Project> findAllProjects() {
        
        return projectDao.findAllProjects();
    }
    
    public void setProjectDao(final ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
    
}