package Prosjekt;

import java.sql.Statement;

public class Anmeldelse extends DBConnection {

	
	public Anmeldelse() {
		
	}
	
//	"INSERT INTO Film" 
//	+ " (FilmID, medieID, tittel, Lengde, Lanseringsaar, Storyline, mediaHarSjanger)"
//	+ "values ('1', '2', 'Star Wars: A New Hope', '125', '1977', 'After Princess Leia.....', '1')"
//	
	public void nyAnmeldelse() {
		try {
			Statement stmt = myConn.createStatement();
			
			String sql = "INSERT into kommentarer"
					+ "(MedieID, Kommentar, Dato, BrukerID)"
					+ "values ('1', 'Kommentar', '13. April', '1')"
					+ "INSERT into bruker"
					+ "(BrukerID, BrukerNavn, Score, kommentarer)"
					+ "values ('1', 'Hallvman', '100', 'Heipådeg')"
					+ "INSERT into Episode"
					+ "(EpisodeNr, Navn, spilletid, sesong)"
					+ "values ('1', 'Pilot', '45', '1')";
					
			
			stmt.executeUpdate(sql);
			
			System.out.println("Insert complete");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Error ved 'Select'");
		}
	}
	
}
	

