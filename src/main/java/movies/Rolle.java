package movies;

import java.sql.ResultSet;
import java.sql.Statement;

public class Rolle {
	private int rolleID;
	private String rolleInfo;
	private String rolleType;
	private int mediaID;
	private int personID;
	
	public Rolle(int rolleID) {
		this.rolleID = rolleID;
	}
	
	public String getRolleInfo() {
		return rolleInfo;
	}
}

