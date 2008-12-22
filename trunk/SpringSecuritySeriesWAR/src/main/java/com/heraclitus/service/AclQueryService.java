package com.heraclitus.service;

import java.util.List;

import com.heraclitus.domain.acl.AclClass;
import com.heraclitus.domain.acl.AclEntry;
import com.heraclitus.domain.acl.AclObjectIdentity;
import com.heraclitus.domain.acl.AclSid;

/**
 * I define business level query behaviour for spring security's ACL approach
 */
public interface AclQueryService {
    
    List<AclClass> findAllAclClasses();
    
    List<AclEntry> findAllAclEntries();
    
    List<AclObjectIdentity> findAllAclObjectIdentities();
    
    List<AclSid> findAllAclSidEntries();
    
}
