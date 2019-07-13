package com.learning.maven.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
	
	private final String URL;
	private final Properties properties;
	
	public DatabaseConnectionManager(String host,String databasename, String username, String password) {
	this.URL="jdbc:postgresql://"+host+"/"+databasename;
	this.properties=new Properties();
	this.properties.setProperty("user", username);
	this.properties.setProperty("password", password);

	}

	public Connection getConnection() throws SQLException{
		System.out.println();
		return DriverManager.getConnection(this.URL,this.properties);
		
	}

	@Override
	public String toString() {
		return "DatabaseConnectionManager [URL=" + URL + ", properties=" + properties + "]";
	}
	
}
