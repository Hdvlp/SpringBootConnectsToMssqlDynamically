package com.springbootconnectstomssqldynamically.demo.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DataService {

    private DataSource dataSource;

    public DataService(SQLServerDataSource dataSource){
        this.dataSource = dataSource;

        try{

            System.out.println();
            System.out.println("Debugging");
            System.out.println("____");
            
            System.out.println(String.format("getApplicationName(): %s", dataSource.getApplicationName()));
            System.out.println(String.format("getAuthentication(): %s", dataSource.getAuthentication()));
            System.out.println(String.format("getApplicationIntent(): %s", dataSource.getApplicationIntent()));
            System.out.println(String.format("getCancelQueryTimeout(): %s", dataSource.getCancelQueryTimeout()));
            System.out.println(String.format("getClass(): %s", dataSource.getClass()));
            System.out.println(String.format("getClientCertificate(): %s", dataSource.getClientCertificate()));
            System.out.println(String.format("getClientKey(): %s", dataSource.getClientKey()));
            System.out.println(String.format("getConnection(): %s", dataSource.getConnection()));
            System.out.println(String.format("getDatabaseName(): %s", dataSource.getDatabaseName()));
            System.out.println(String.format("getDomain(): %s", dataSource.getDomain()));
            System.out.println(String.format("getFIPS(): %s", dataSource.getFIPS()));
            System.out.println(String.format("getHostNameInCertificate(): %s", dataSource.getHostNameInCertificate()));
            System.out.println(String.format("getIPAddressPreference(): %s", dataSource.getIPAddressPreference()));
            System.out.println(String.format("getInstanceName(): %s", dataSource.getInstanceName()));
            System.out.println(String.format("getKeyStoreLocation(): %s", dataSource.getKeyStoreLocation()));
            System.out.println(String.format("getKeyStorePrincipalId(): %s", dataSource.getKeyStorePrincipalId()));
            System.out.println(String.format("getKeyVaultProviderClientId(): %s", dataSource.getKeyVaultProviderClientId()));
            System.out.println(String.format("getServerCertificate(): %s", dataSource.getServerCertificate()));
            System.out.println(String.format("getTrustServerCertificate(): %s", dataSource.getTrustServerCertificate()));
            System.out.println(String.format("getTrustStore(): %s", dataSource.getTrustStore()));
            System.out.println(String.format("getTrustStoreType(): %s", dataSource.getTrustStoreType()));
            System.out.println(String.format("getURL(): %s", dataSource.getURL()));
            System.out.println(String.format("getEncrypt(): %s", dataSource.getEncrypt()));
            System.out.println(String.format("getSSLProtocol(): %s", dataSource.getSSLProtocol()));
            System.out.println(String.format("getUser(): %s", dataSource.getUser()));
            System.out.println(String.format("getPacketSize(): %s", dataSource.getPacketSize()));
            System.out.println(String.format("getDescription(): %s", dataSource.getDescription()));
            System.out.println(String.format("getPortNumber(): %s", dataSource.getPortNumber()));
            System.out.println(String.format("getConnectRetryCount(): %s", dataSource.getConnectRetryCount()));
            System.out.println(String.format("getConnectRetryInterval(): %s", dataSource.getConnectRetryInterval()));
            System.out.println(String.format("getServerSpn(): %s", dataSource.getServerSpn()));
            
            System.out.println("____");
            System.out.println();

        } catch (Exception e){e.printStackTrace();}
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
