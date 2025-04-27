package com.springbootconnectstomssqldynamically.demo.config;

public class DbConnectionSetUp {

    private static final String user = "adminranducuhylfpicptyhvwhxss";
    private static final String password = "K9WqisQSx9OdUVkFf78W";
    private static final String databaseName = "randqlejmpxpfrtboknoqdks";
    private static final String serverName = "randqlejmpxpfrtboknoqdks";

    public static String getUser(){
        return user;
    }

    public static String getPassword(){
        String passwordAfterWaitingSimulation = "";
        try{
            System.out.println("Start waiting.");
            for (int i = 0; i < 10; i++){
                double msec = 1;
                Thread.sleep((int) msec);
                System.out.println("Waiting for " + msec/1000 + " second(s).");
            }
            System.out.println("Stop waiting.");
            passwordAfterWaitingSimulation = password;

        } catch (Exception e){}
        
        return passwordAfterWaitingSimulation;
    }

    public static String getDatabaseName(){
        return databaseName;
    }

    public static String getServerName(){
        return serverName;
    }

    public static String getURL(){
        //String unencryptedURLSimulation =  "jdbc:sqlserver://localhost:1433;databaseName=customdb;encrypt=false;trustServerCertificate=false;";
        //return unencryptedURLSimulation;
        //String encryptedURLSimulation =  "jdbc:sqlserver://localhost:1433;databaseName=customdb;encrypt=true;trustServerCertificate=true;";
        //return encryptedURLSimulation;
        String encryptedURLSimulationUsingAzureSQLDatabase =  "jdbc:sqlserver://"+getServerName()+".database.windows.net:1433;database="+databaseName+";user="+getUser()+"@"+getServerName()+";password="+getPassword()+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        return encryptedURLSimulationUsingAzureSQLDatabase;
    }

}
