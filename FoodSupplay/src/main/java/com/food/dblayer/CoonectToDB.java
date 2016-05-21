package com.food.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CoonectToDB {
	
	public static void main(String[] args){
	try { 
		
		String url = "jdbc:postgresql://localhost:9091/"; 
		String dbName = "FoodChain";
		String userName = "postgres"; 
		String password = "root";
		String driver = "org.postgresql.Driver";
		Statement stmt = null;
		Class.forName(driver).newInstance(); 
		Connection conn = DriverManager.getConnection(url+dbName,userName,password);
		
		System.out.println("connection sucess");
		stmt = conn.createStatement();
		String sql = "CREATE TABLE FOODCHINE"
		+ "(ID INT PRIMARY KEY     NOT NULL,"+
                "FIRSTNAME    VARCHAR(45)    NOT NULL,"+
                "MIDDLENAME   VARCHAR(45)    NOT NULL ,"+
                "LASTNAME       VARCHAR(45)    NOT NULL ,"+
                "EMAIL       VARCHAR(45)    NOT NULL ,"+ 
                "USERID      VARCHAR(45)    NOT NULL ,"+ 
                "PASSWORD    VARCHAR(45)    NOT NULL ); ";
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	} catch (Exception e)
	{
		e.printStackTrace();
		 System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
	}
	   System.out.println("Table created successfully");
	

}
}
