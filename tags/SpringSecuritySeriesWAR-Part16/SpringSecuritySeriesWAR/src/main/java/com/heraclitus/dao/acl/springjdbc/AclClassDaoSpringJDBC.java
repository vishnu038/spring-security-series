package com.heraclitus.dao.acl.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.heraclitus.dao.acl.AclClassDao;
import com.heraclitus.domain.acl.AclClass;
import com.heraclitus.domain.acl.AclClassImmutable;

/**
 * 
 */
public class AclClassDaoSpringJDBC extends SimpleJdbcDaoSupport implements
        AclClassDao {
    
    private class AclClassAllQuery extends MappingSqlQuery {
        
        protected AclClassAllQuery(final DataSource ds) {
            super(ds, "SELECT id, class FROM ACL_CLASS ORDER BY id");
            compile();
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public List<AclClass> execute() throws DataAccessException {
            return super.execute();
        }
        
        @Override
        protected AclClass mapRow(final ResultSet rs, final int rowNum)
                throws SQLException {
            final Long id = new Long(rs.getLong("id"));
            final String className = rs.getString("class");
            final AclClass aclClass = new AclClassImmutable(id, className);
            
            return aclClass;
        }
    }
    
    private AclClassAllQuery aclClassAllQuery;
    
    public List<AclClass> findAllAclClasses() {
        return aclClassAllQuery.execute();
    }
    
    @Override
    protected void initDao() throws Exception {
        super.initDao();
        aclClassAllQuery = new AclClassAllQuery(getDataSource());
    }
    
}
