package com.heraclitus.service.impl;

import java.util.List;

import com.heraclitus.dao.acl.AclClassDao;
import com.heraclitus.dao.acl.AclEntryDao;
import com.heraclitus.dao.acl.AclObjectIdentityDao;
import com.heraclitus.dao.acl.AclSidDao;
import com.heraclitus.domain.acl.AclClass;
import com.heraclitus.domain.acl.AclEntry;
import com.heraclitus.domain.acl.AclObjectIdentity;
import com.heraclitus.domain.acl.AclSid;
import com.heraclitus.service.AclQueryService;

/**
 * 
 */
public class AclQueryServiceImpl implements AclQueryService {
    
    private AclClassDao aclClassDao;
    private AclEntryDao aclEntryDao;
    private AclObjectIdentityDao aclObjectIdentityDao;
    private AclSidDao aclSidDao;
    
    public List<AclClass> findAllAclClasses() {
        return aclClassDao.findAllAclClasses();
    }
    
    public List<AclEntry> findAllAclEntries() {
        return aclEntryDao.findAllAclEntries();
    }
    
    public List<AclObjectIdentity> findAllAclObjectIdentities() {
        return aclObjectIdentityDao.findAllAclObjectIdentities();
    }
    
    public List<AclSid> findAllAclSidEntries() {
        return aclSidDao.findAllAclSidEntries();
    }
    
    public void setAclClassDao(final AclClassDao aclClassDao) {
        this.aclClassDao = aclClassDao;
    }
    
    public void setAclEntryDao(final AclEntryDao aclEntryDao) {
        this.aclEntryDao = aclEntryDao;
    }
    
    public void setAclObjectIdentityDao(
            final AclObjectIdentityDao aclObjectIdentityDao) {
        this.aclObjectIdentityDao = aclObjectIdentityDao;
    }
    
    public void setAclSidDao(final AclSidDao aclSidDao) {
        this.aclSidDao = aclSidDao;
    }
    
}
