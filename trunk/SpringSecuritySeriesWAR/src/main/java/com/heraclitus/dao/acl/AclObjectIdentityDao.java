package com.heraclitus.dao.acl;

import java.util.List;

import com.heraclitus.domain.acl.AclObjectIdentity;

public interface AclObjectIdentityDao {
    
    List<AclObjectIdentity> findAllAclObjectIdentities();
    
}
