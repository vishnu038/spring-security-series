package com.heraclitus.dao.acl.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.heraclitus.dao.acl.AclEntryDao;
import com.heraclitus.domain.acl.AclEntry;
import com.heraclitus.domain.acl.AclEntryImmutable;

/**
 * 
 */
public class AclEntryDaoSpringJDBC extends SimpleJdbcDaoSupport implements
        AclEntryDao {
    
    private class AclEntryAllQuery extends MappingSqlQuery {
        
        protected AclEntryAllQuery(final DataSource ds) {
            super(
                    ds,
                    "SELECT id, ACL_OBJECT_IDENTITY, ACE_ORDER, SID, MASK, GRANTING, AUDIT_SUCCESS, AUDIT_FAILURE FROM ACL_ENTRY ORDER BY id");
            compile();
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public List<AclEntry> execute() throws DataAccessException {
            return super.execute();
        }
        
        @Override
        protected AclEntry mapRow(final ResultSet rs, final int rowNum)
                throws SQLException {
            final Long id = Long.valueOf(rs.getLong("id"));
            final Long aclObjectIdIdentity = new Long(rs
                    .getLong("ACL_OBJECT_IDENTITY"));
            final Integer aceOrder = Integer.valueOf(rs.getInt("ace_order"));
            final Long sid = Long.valueOf(rs.getLong("sid"));
            final Integer mask = Integer.valueOf(rs.getInt("mask"));
            final boolean granting = rs.getBoolean("granting");
            final boolean auditSuccess = rs.getBoolean("AUDIT_SUCCESS");
            final boolean auditFailure = rs.getBoolean("AUDIT_FAILURE");
            
            final AclEntry aclObjectIdentity = new AclEntryImmutable(id,
                    aclObjectIdIdentity, aceOrder, sid, mask, granting,
                    auditSuccess, auditFailure);
            
            return aclObjectIdentity;
        }
    }
    
    private AclEntryAllQuery aclEntryAllQuery;
    
    public List<AclEntry> findAllAclEntries() {
        return aclEntryAllQuery.execute();
    }
    
    @Override
    protected void initDao() throws Exception {
        super.initDao();
        aclEntryAllQuery = new AclEntryAllQuery(getDataSource());
    }
    
}
