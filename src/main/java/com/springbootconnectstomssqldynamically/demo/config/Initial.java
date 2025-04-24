package com.springbootconnectstomssqldynamically.demo.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Initial {

    private DataSource dataSource;

    public Initial(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Bean
    public int init(){
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            String createTableSql = "IF OBJECT_ID(N'customdb.dbo.sample', N'U') IS NULL BEGIN " + 
            "CREATE TABLE customdb.dbo.sample(id int NOT NULL IDENTITY(1,1), name NVARCHAR(60), PRIMARY KEY(id)); " + 
            "END;";

            statement.execute(createTableSql);
            String insertSql = "INSERT INTO customdb.dbo.sample (name) VALUES (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

            for (int i = 0; i < 10; i++){
                preparedStatement.setString(1, "user ä ö ü " + i);
                preparedStatement.addBatch();
            }

            int[] results = preparedStatement.executeBatch();
            System.out.println();
            System.out.println("Inserted rows: " + results.length);
            System.out.println("Database initialized.");
            System.out.println();
        }
        catch (Exception e){}
        return 0;
    }

}
