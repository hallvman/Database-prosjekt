package movies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Selskap {
	private int selskapsID;
	private String navn;
	private String adresse;
	private String nasjonalitet;
	private String nettside;
	
	public Selskap() {}
	
	public void getFilmer(queries q) {
		q.getFilmFromCompany();
	}
}
