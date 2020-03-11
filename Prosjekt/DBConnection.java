package Prosjekt;

import java.sql.*;
import java.util.Properties;

public abstract class DBConnection {
	
	protected Connection myConn;
	
	public DBConnection() {
	
	}
	
	public void connect() {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Properties p = new Properties();
	        	p.put("user", "root");
	        	p.put("password", "myPassword");  
			
	        	myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosjektdel2", p);

		} catch (Exception e) {
			throw new RuntimeException("Unable to connect.");
		}
	}
	
}

	

