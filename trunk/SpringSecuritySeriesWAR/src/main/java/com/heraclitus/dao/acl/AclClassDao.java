package com.heraclitus.dao.acl;

import java.util.List;

import com.heraclitus.domain.acl.AclClass;

/**
 * data access methods for {@link AclClass}.
 */
public interface AclClassDao {
    
    List<AclClass> findAllAclClasses();
    
}
