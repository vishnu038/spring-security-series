package com.heraclitus.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

/**
 * I am responsible for populating the configured datasource
 */
public class HsqldbSchemaAndDataPopulator implements InitializingBean {
    
    private JdbcTemplate template;
    
    /**
     *
     */
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(template, "dataSource required");
        
        // add tables to represent admin core-domain instances.
        template
                .execute("CREATE TABLE USERS(USERNAME VARCHAR_IGNORECASE(50) NOT NULL PRIMARY KEY,"
                        + "PASSWORD VARCHAR_IGNORECASE(50) NOT NULL,"
                        + "ENABLED BOOLEAN NOT NULL);");
        template
                .execute("CREATE TABLE AUTHORITIES(USERNAME VARCHAR_IGNORECASE(50) NOT NULL,AUTHORITY VARCHAR_IGNORECASE(50) NOT NULL,CONSTRAINT FK_AUTHORITIES_USERS FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME));");
        template
                .execute("CREATE UNIQUE INDEX IX_AUTH_USERNAME ON AUTHORITIES(USERNAME,AUTHORITY);");
        
        // add tables to represent bug tracking domain instances.
        template
                .execute("CREATE TABLE PROJECTS(ID BIGINT NOT NULL PRIMARY KEY, NAME VARCHAR_IGNORECASE(50) NOT NULL, DESCRIPTION VARCHAR_IGNORECASE(200) NOT NULL);");
        
        // insert data here
        template
                .execute("INSERT INTO USERS VALUES('disabled','disabled',FALSE);");
        template.execute("INSERT INTO USERS VALUES('admin','admin',TRUE);");
        template
                .execute("INSERT INTO USERS VALUES('username','password',TRUE);");
        template.execute("INSERT INTO USERS VALUES('test','test',TRUE);");
        
        template
                .execute("INSERT INTO AUTHORITIES VALUES('admin','ROLE_USER');");
        template
                .execute("INSERT INTO AUTHORITIES VALUES('admin','ROLE_ADMIN');");
        
        template
                .execute("INSERT INTO AUTHORITIES VALUES('username','ROLE_USER');");
        
        template.execute("INSERT INTO AUTHORITIES VALUES('test','ROLE_USER');");
        
        template
                .execute("INSERT INTO projects VALUES (1, 'Test Project', 'A description not longer than 200 chars of what project is.');");
        template
                .execute("INSERT INTO projects VALUES (2, 'Test Project 2', 'Smaller description of project here.');");
    }
    
    public void setDataSource(final DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
}
