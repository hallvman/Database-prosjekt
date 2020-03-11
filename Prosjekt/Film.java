package Prosjekt;


import java.sql.ResultSet;
import java.sql.Statement;

public class Film extends DBConnection {
	private int personID;
	
	public Film() {
		
	}
	
	public Film(int personID) {
		this.personID = personID;
	}
	
	
	public void getFilmForSkuespiller(int personID) {
		try {
			Statement stmt = myConn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT film.tittel from film"
					+ "INNER JOIN sjanger ON film.filmID = sjanger.sjangerID "
					+ "INNER JOIN person ON sjanger.sjangerID = person.personID "
					+ "WHERE personID=" + personID);
			while(rs.next()) {
				System.out.println(rs.getString("Navn") + rs.getInt("rolleinfo"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Error ved 'Select'");
		}
	}
	
	public void setFilm() {
		try {
			Statement stmt = myConn.createStatement();
			
			String sql = "INSERT INTO Film" 
					+ " (FilmID, medieID, tittel, Lengde, Lanseringsaar, Storyline, mediaHarSjanger)"
					+ "values ('1', '2', 'Star Wars: A New Hope', '125', '1977', 'After Princess Leia.....', '1')"
					+ "INSERT INTO Sjanger"
					+ " (SjangerID, Navn, Beskrivelse)"
					+ "values (1, Action, Actionfylt)"
					+ "INSERT INTO Rolle"
					+ " (RolleID, RolleType, RolleInfo, RolleAvPerson, RolleIFilm)"
					+ "values ('1', 'hovedperson', 'Prinsesse leia', '1', '1')"
					+ "INSERT INTO Person"
					+ "(personID, Navn, Fodselsdato, Nasjonalitet)"
					+ "values ('1', 'Carrie Fisher', '21. oktober 1956', 'Amerikansk')"
					+ "INSERT INTO Selskap"
					+ "(SelskapsID, Adresse, Navn, Nasjonalitet, FilmID)"
					+ "values ('1', 'Walt Disnet gate 1', 'LucasFilm', 'Amerikansk', '1')";
			
			stmt.executeUpdate(sql);
			
			System.out.println("Insert complete");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Error ved 'Select'");
		}
	}
}
