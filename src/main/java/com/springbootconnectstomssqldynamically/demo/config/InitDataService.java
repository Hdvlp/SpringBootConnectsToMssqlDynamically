package com.springbootconnectstomssqldynamically.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.springbootconnectstomssqldynamically.demo.service.DataService;

@Configuration
public class InitDataService {
    
    @Bean
    public DataService configDataService(SQLServerDataSource dataSource){
        return new DataService(dataSource);
    }

}
