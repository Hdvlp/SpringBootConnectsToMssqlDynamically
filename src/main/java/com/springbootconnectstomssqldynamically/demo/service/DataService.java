package com.springbootconnectstomssqldynamically.demo.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DataService {

    private DataSource dataSource;

    public DataService(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<String> getData(){
        List<String> names = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            String selectTableSql = "SELECT TOP 200 * FROM customdb.dbo.sample WHERE id > ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectTableSql);

            preparedStatement.setInt(1, 0);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                names.add(rs.getString("id"));
                names.add(rs.getString("name"));
            }
            
        }
        catch (Exception e){}
        return names;
    }


}
