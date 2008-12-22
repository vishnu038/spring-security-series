package com.heraclitus.dao.acl;

import java.util.List;

import com.heraclitus.domain.acl.AclSid;

/**
 * data access behaviour related to {@link AclSid}'s
 */
public interface AclSidDao {
    
    List<AclSid> findAllAclSidEntries();
    
}
