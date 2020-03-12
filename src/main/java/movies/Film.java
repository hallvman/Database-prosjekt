package movies;

import java.sql.ResultSet;
import java.sql.Statement;

public class Film {
	private int personID;
	
	public Film() {}
	
	public Film(int personID) {
		this.personID = personID;
	}
	
	public void getFilmForSkuespiller(int personID, queries q) {
		q.getFilm(personID);
	}
	
	public void setFilm(queries q){
		q.insertFilm();
	}
}
