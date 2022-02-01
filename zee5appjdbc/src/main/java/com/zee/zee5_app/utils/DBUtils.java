package com.zee.zee5_app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class DBUtils {
	
	Connection connection = null;
	public DBUtils() throws IOException {
		// TODO Auto-generated constructor stub
		properties = loadProperties();
	}
	
	public Connection getConnection() {
		
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
						properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
				connection.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Properties properties;
	private Properties loadProperties() throws IOException {
		InputStream inputStream = 
				DBUtils.class.getClassLoader().
				getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties;
	}

}
