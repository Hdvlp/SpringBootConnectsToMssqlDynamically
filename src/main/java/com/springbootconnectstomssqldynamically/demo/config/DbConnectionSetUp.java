package com.springbootconnectstomssqldynamically.demo.config;

public class DbConnectionSetUp {

    public static String getUser(){
        return "sa";
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
            passwordAfterWaitingSimulation = "YourPassword";

        } catch (Exception e){}
        
        return passwordAfterWaitingSimulation;
    }

    public static String getURL(){
        //String unencryptedURLSimulation =  "jdbc:sqlserver://localhost:1433;databaseName=customdb;encrypt=false;trustServerCertificate=false;";
        //return unencryptedURLSimulation;
        String encryptedURLSimulation =  "jdbc:sqlserver://localhost:1433;databaseName=customdb;encrypt=true;trustServerCertificate=true;";
        return encryptedURLSimulation;
    }

}
