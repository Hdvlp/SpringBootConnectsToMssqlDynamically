package com.springbootconnectstomssqldynamically.demo.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@Configuration
public class Db { 
    
    @Bean
    DataSource dataSource() {
        final SQLServerDataSource dataSource = new SQLServerDataSource();
        String url = DbConnectionSetUp.getURL();
        String user = DbConnectionSetUp.getUser();
        String password = DbConnectionSetUp.getPassword();
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        // clearing after use
        url = null;
        user = null;
        password = null;
        return dataSource;
    }

}