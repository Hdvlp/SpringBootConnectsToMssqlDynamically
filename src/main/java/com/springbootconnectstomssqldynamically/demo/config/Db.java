package com.springbootconnectstomssqldynamically.demo.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@Configuration
public class Db { 

    @Bean
    DataSource dataSource() {
        final var dataSource = new SQLServerDataSource();
        dataSource.setURL(DbConnectionSetUp.getURL());
        dataSource.setUser(DbConnectionSetUp.getUser());
        dataSource.setPassword(DbConnectionSetUp.getPassword());
        return dataSource;
    }

}