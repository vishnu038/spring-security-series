package com.heraclitus.dao.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.heraclitus.dao.ProjectDao;
import com.heraclitus.domain.Project;
import com.heraclitus.domain.ProjectImpl;

/**
 * Base implementation of {@link ProjectDao} that uses Spring JDBC services.
 */
public class ProjectDaoSpringJDBC extends SimpleJdbcDaoSupport implements
        ProjectDao {
    
    protected class ProjectsAllQuery extends MappingSqlQuery {
        
        protected ProjectsAllQuery(final DataSource ds) {
            super(ds, "SELECT id, name, description FROM projects ORDER BY id");
            compile();
        }
        
        @Override
        protected Project mapRow(final ResultSet rs, final int rowNum)
                throws SQLException {
            final Long id = new Long(rs.getLong("id"));
            final String name = rs.getString("name");
            final String description = rs.getString("description");
            final Project project = new ProjectImpl(id, name, description);
            
            return project;
        }
    }
    
    private ProjectsAllQuery projectsAllQuery;
    
    @SuppressWarnings("unchecked")
    public List<Project> findAllProjects() {
        return projectsAllQuery.execute();
    }
    
    @Override
    protected void initDao() throws Exception {
        super.initDao();
        projectsAllQuery = new ProjectsAllQuery(getDataSource());
    }
}