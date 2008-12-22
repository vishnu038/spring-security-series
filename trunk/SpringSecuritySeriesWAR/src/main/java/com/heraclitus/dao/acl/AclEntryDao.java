package com.heraclitus.dao.acl;

import java.util.List;

import com.heraclitus.domain.acl.AclEntry;


/**
 * 
 */
public interface AclEntryDao {
    
    List<AclEntry> findAllAclEntries();
    
}
