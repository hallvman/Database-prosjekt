package Prosjekt;

import java.sql.*;

public abstract class DBConnection {
	
	protected Connection myConn;
	
	public DBConnection() {
	}
	
	public void connect() {
		try {
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosjektdel2");

		} catch (Exception e) {
			throw new RuntimeException("Uable to connect.");
		}
	}
	
}

	

