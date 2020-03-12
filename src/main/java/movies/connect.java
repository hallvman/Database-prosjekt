package movies;

import java.sql.*;
import java.util.*;

public class connect extends DBConn{

	public connect(){
		connect();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("db error during setAutoCommit of connect="+e);
		return;
		}
	}
}
