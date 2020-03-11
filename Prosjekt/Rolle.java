package Prosjekt;

import java.sql.ResultSet;
import java.sql.Statement;

public class Rolle extends DBConnection {
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
	
	public void getRolle(int personID) {
		try {
			Statement stmt = myConn.createStatement();
			ResultSet rs = stmt.executeQuery("Select Rolle.rolleinfo From Rolle inner join Person on Rolle.rolleid = person.personID Where PersonId=" + personID);
			while (rs.next()) {
				System.out.println(rs.getString("rolleinfo"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Fikk error ved 'Select'");
		}
	}
}
