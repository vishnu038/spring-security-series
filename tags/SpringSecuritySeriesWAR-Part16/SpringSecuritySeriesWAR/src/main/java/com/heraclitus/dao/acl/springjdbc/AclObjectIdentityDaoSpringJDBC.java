package com.heraclitus.dao.acl.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.heraclitus.dao.acl.AclObjectIdentityDao;
import com.heraclitus.domain.acl.AclObjectIdentity;
import com.heraclitus.domain.acl.AclObjectIdentityImmutable;

/**
 * 
 */
public class AclObjectIdentityDaoSpringJDBC extends SimpleJdbcDaoSupport
        implements AclObjectIdentityDao {
    
    private class AclObjectIdentityAllQuery extends MappingSqlQuery {
        
        protected AclObjectIdentityAllQuery(final DataSource ds) {
            super(
                    ds,
                    "SELECT id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting FROM ACL_OBJECT_IDENTITY ORDER BY id");
            compile();
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public List<AclObjectIdentity> execute() throws DataAccessException {
            return super.execute();
        }
        
        @Override
        protected AclObjectIdentity mapRow(final ResultSet rs, final int rowNum)
                throws SQLException {
            final Long id = new Long(rs.getLong("id"));
            final Long objectIdClass = new Long(rs.getLong("object_id_class"));
            final Long objectIdIdentity = new Long(rs
                    .getLong("object_id_identity"));
            final Long parentObject = new Long(rs.getLong("parent_object"));
            final Long ownerSid = new Long(rs.getLong("owner_sid"));
            final boolean entriesInheriting = rs
                    .getBoolean("entries_inheriting");
            final AclObjectIdentity aclObjectIdentity = new AclObjectIdentityImmutable(
                    id, objectIdClass, objectIdIdentity, parentObject,
                    ownerSid, entriesInheriting);
            
            return aclObjectIdentity;
        }
    }
    
    private AclObjectIdentityAllQuery aclObjectIdentityAllQuery;
    
    public List<AclObjectIdentity> findAllAclObjectIdentities() {
        return aclObjectIdentityAllQuery.execute();
    }
    
    @Override
    protected void initDao() throws Exception {
        super.initDao();
        aclObjectIdentityAllQuery = new AclObjectIdentityAllQuery(
                getDataSource());
    }
    
}
