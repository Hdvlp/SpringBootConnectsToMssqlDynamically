package com.springbootconnectstomssqldynamically.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbootconnectstomssqldynamically.demo.service.DataService;

@Configuration
public class InitDataService {
    
    @Bean
    public DataService configDataService(DataSource dataSource){
        return new DataService(dataSource);
    }

}
