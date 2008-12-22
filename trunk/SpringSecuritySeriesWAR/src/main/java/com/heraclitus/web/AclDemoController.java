package com.heraclitus.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.heraclitus.domain.Project;
import com.heraclitus.domain.acl.AclClass;
import com.heraclitus.domain.acl.AclEntry;
import com.heraclitus.domain.acl.AclObjectIdentity;
import com.heraclitus.domain.acl.AclSid;
import com.heraclitus.service.AclQueryService;
import com.heraclitus.service.ProjectService;

/**
 * {@link Controller} for acl demo page.
 */
public class AclDemoController implements Controller {
    
    private AclQueryService aclQueryService;
    private ProjectService projectService;
    
    public ModelAndView handleRequest(final HttpServletRequest request,
            final HttpServletResponse response) throws Exception {
        
        final List<Project> projects = projectService.findAllProjects();
        final List<AclSid> aclSids = aclQueryService.findAllAclSidEntries();
        final List<AclClass> aclClasses = aclQueryService.findAllAclClasses();
        final List<AclObjectIdentity> aclObjectIdentities = aclQueryService
                .findAllAclObjectIdentities();
        final List<AclEntry> aclEntries = aclQueryService.findAllAclEntries();
        
        final Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("projects", projects);
        myModel.put("aclSids", aclSids);
        myModel.put("aclClasses", aclClasses);
        myModel.put("aclObjectIdentities", aclObjectIdentities);
        myModel.put("aclEntries", aclEntries);
        
        return new ModelAndView("acldemo", "model", myModel);
    }
    
    public void setAclQueryService(final AclQueryService aclQueryService) {
        this.aclQueryService = aclQueryService;
    }
    
    public void setProjectService(final ProjectService projectService) {
        this.projectService = projectService;
    }
}
