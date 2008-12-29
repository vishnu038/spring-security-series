package com.heraclitus.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.heraclitus.domain.Project;
import com.heraclitus.service.ProjectService;

/**
 * {@link Controller} for method level security demo page.
 */
public class MethodDemoController implements Controller {
    
    private ProjectService projectService;
    
    public ModelAndView handleRequest(final HttpServletRequest request,
            final HttpServletResponse response) throws Exception {
        
        final List<Project> projects = projectService.findAllProjects();
        
        final Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("projects", projects);
        
        return new ModelAndView("methoddemo", "model", myModel);
    }
    
    public void setProjectService(final ProjectService projectService) {
        this.projectService = projectService;
    }
}
