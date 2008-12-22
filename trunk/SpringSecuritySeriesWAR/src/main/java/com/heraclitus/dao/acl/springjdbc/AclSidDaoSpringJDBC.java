package com.heraclitus.dao.acl.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.heraclitus.dao.acl.AclSidDao;
import com.heraclitus.domain.acl.AclSid;
import com.heraclitus.domain.acl.AclSidDefault;

/**
 * Implementation of {@link AclSidDao} using spring jdbc services.
 */
public class AclSidDaoSpringJDBC extends SimpleJdbcDaoSupport implements
        AclSidDao {
    
    private class AclSidAllQuery extends MappingSqlQuery {
        
        protected AclSidAllQuery(final DataSource ds) {
            super(ds, "SELECT id, principal, sid FROM ACL_SID ORDER BY id");
            compile();
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public List<AclSid> execute() throws DataAccessException {
            return super.execute();
        }
        
        @Override
        protected AclSid mapRow(final ResultSet rs, final int rowNum)
                throws SQLException {
            final Long id = new Long(rs.getLong("id"));
            
            final boolean principal = rs.getBoolean("principal");
            final String sid = rs.getString("sid");
            final AclSid aclSid = new AclSidDefault(id, principal, sid);
            
            return aclSid;
        }
    }
    
    private AclSidAllQuery aclSidAllQuery;
    
    public List<AclSid> findAllAclSidEntries() {
        return aclSidAllQuery.execute();
    }
    
    @Override
    protected void initDao() throws Exception {
        super.initDao();
        aclSidAllQuery = new AclSidAllQuery(getDataSource());
    }
    
}
