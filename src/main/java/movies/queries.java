
package movies;

import java.io.*;

import java.sql.*;
import java.util.*;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.IOException;

public class queries {
	connect movies;
	Statement stmt;

	public queries(){
		get_connection();
	}
	private void get_connection(){
		try{
			movies = new connect();
			stmt = movies.conn.createStatement();
		} catch (Exception e){}
	}
	private String read_sql_file(){
		Path path = Paths.get("src/main/java/resources/TDT4145_prosjekt.sql");
		//Path path = Paths.get("src/main/java/resources/sql_script");
		try
		{
			String sql_file = new String (Files.readAllBytes(path));
			return sql_file;
		} catch (IOException e){System.out.println("File not found\n");}

		return "";
	}

	public void create_database(){
		String sql = read_sql_file();
		String[] sql_statements = sql.split(";");

		if(sql != ""){
			try{
				System.out.println("Creating database\n");

				for(int i=0; i<sql_statements.length-1; i++){
					sql_statements[i] += ';';
					stmt.execute(sql_statements[i]);
				}
			}	catch (Exception e) {System.out.println("Could not execute sql statements\n");}
		}
	}

	public connect get_connected(){return movies;}
	public void getRolle(int personID){
		try {
			Statement stmt = movies.conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select Rolle.rolleinfo From Rolle inner join Person on Rolle.rolleid = person.personID Where PersonId=" + personID);
			while (rs.next()) {
				System.out.println(rs.getString("rolleinfo"));
			}
			
		} catch (Exception e) {
			System.out.println("Fikk error ved 'Select'");
		}
	}
	public void getFilm(int personID){
		try {
			ResultSet rs = stmt.executeQuery("SELECT film.tittel from film"
					+ "INNER JOIN sjanger ON film.filmID = sjanger.sjangerID "
					+ "INNER JOIN person ON sjanger.sjangerID = person.personID "
					+ "WHERE personID=" + personID);
			while(rs.next()) {
				System.out.println(rs.getString("Navn") + rs.getInt("rolleinfo"));
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Error ved 'Select'");
		}
	}
	public void getFilmFromCompany(){
		try {
			ResultSet rs = stmt.executeQuery("SELECT selskap.navn, count(*) as antall from selskap "
					+ "INNER JOIN film ON selskap.selskapID = film.filmID "
					+ "INNER JOIN sjanger ON film.filmID = sjanger.sjangerID "
					+ "GROUP BY selskap.navn");
			while(rs.next()) {
				System.out.println(rs.getString("Navn") + rs.getInt("Antall"));
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Error ved 'Select'");
		}
	}
	public void insertFilm(){
		String film, sjanger, rolle, person, selskap;
		try {
			film = "INSERT INTO Film" 
					+ " (FilmID, medieID, tittel, Lengde, Lanseringsaar, Storyline, mediaHarSjanger)"
					+ "values ('1', '2', 'Star Wars: A New Hope', '125', '1977', 'After Princess Leia.....', '1')";
			sjanger = "INSERT INTO Sjanger"
					+ " (SjangerID, Navn, Beskrivelse)"
					+ " values (1, 'Action', 'Actionfylt');";
			rolle = "INSERT INTO Rolle"
					+ " (RolleID, RolleType, RolleInfo, RolleAvPerson, RolleIFilm)"
					+ "values (1, 'hovedperson', 'Prinsesse leia', '1', '1');";
			person = "INSERT INTO Person"
					+ " (personID, Navn, Fodselsdato, Nasjonalitet)"
					+ " values (1, 'Carrie Fisher', '21. oktober 1956', 'Amerikansk');";
			selskap = "INSERT INTO Selskap"
					+ " (SelskapsID, Adresse, Navn, Nasjonalitet, FilmID)"
					+ " values ('1', 'Walt Disnet gate 1', 'LucasFilm', 'Amerikansk', '1');";
			
			stmt.execute("USE movies;");
			stmt.execute(sjanger);
		//stmt.executeUpdate(rolle);
		//stmt.executeUpdate(person);
		//stmt.executeUpdate(selskap);
			
			System.out.println("Insert complete");
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Error ved 'Select'");
		}
	}
}
