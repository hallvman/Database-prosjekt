package Prosjekt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Selskap extends DBConnection {
	private int selskapsID;
	private String navn;
	private String adresse;
	private String nasjonalitet;
	private String nettside;
	
	public Selskap() {
		
	}
	
	public void getFilmer() {
		try {
			Statement stmt = myConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT selskap.navn, count(*) as antall from selskap "
					+ "INNER JOIN film ON selskap.selskapID = film.filmID "
					+ "INNER JOIN sjanger ON film.filmID = sjanger.sjangerID "
					+ "GROUP BY selskap.navn");
			while(rs.next()) {
				System.out.println(rs.getString("Navn") + rs.getInt("Antall"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Error ved 'Select'");
		}
	}

}
