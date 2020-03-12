package movies;

import java.sql.*;
import java.util.Properties;

public abstract class DBConn {
    protected Connection conn;
    public DBConn () {
    }
    public void connect() {
    	try {
				// This driver works with mariadb
        Class.forName("java.sql.Driver");

				// Use this driver if you are using MySql
        // Class.forName("com.mysql.jdbc.Driver").newInstance();

				// Use this driver if you are using MySQL 8.0.
	    	//Class.forName("com.mysql.cj.jdbc.Driver");

	    // Properties for user and password.
			// Change properties of username and password accordingly to be able to
			// connect to local server
            Properties p = new Properties();
            p.put("user", "username");
            p.put("password", "mypassword");           
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1?autoReconnect=true&useSSL=false", p);
        } catch (Exception e)
    	{
            throw new RuntimeException("Unable to connect", e);
    	}
    }
}
