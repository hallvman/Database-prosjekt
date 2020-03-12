
package movies;

import java.util.Scanner;
import java.sql.*;
import java.util.*;

public class Main{
	
  public static void main(String[] args) {
		Rolle rolle;
		Selskap selskap;
		Film film;
		Anmeldelse anmelde;

		System.out.println("main class\n");

		queries movies_database = new queries();
		movies_database.create_database();

		System.out.println("Hva vil du gjore (1-5)?");
		System.out.println("1. Finne navnet paa alle rollene en gitt skuespiller har.");
		System.out.println("2. Finne hvilke filmer som en gitt skuespiller opptrer i.");
		System.out.println("3. Finne hvilke filmselskap som lager flest filmer inne hver sjanger (grossere, familie,\r\n" + 
				"//o.l.).");
		System.out.println("4. Sette inn en ny film med regissor, manusforfattere, skuespillere og det som horer med.");
		System.out.println("5. Sette inn ny anmeldelse av en episode i en serie.");
		System.out.println("Skriv inn en ett for for hva du vil gjore: ");

		Scanner scanner = new Scanner(System.in);
		int mulighet = scanner.nextInt();
		
		switch (mulighet) {
			case 1: {
				System.out.println("Hva er ID'n til personen:");
				Scanner scanner1 = new Scanner(System.in);
				int id = scanner.nextInt();
				
				rolle = new Rolle(id);
				movies_database.getRolle(id);
				break;
			}
			
			case 2: {
				System.out.println("Hva er ID'n til personen:");
				Scanner scanner1 = new Scanner(System.in);
				int id = scanner.nextInt();
				
				film = new Film(id);
				film.getFilmForSkuespiller(id, movies_database);
				break;
			}
			case 3: {
				selskap = new Selskap();
				selskap.getFilmer(movies_database);
				break;
			}
			case 4: {
				film = new Film();
				film.setFilm(movies_database);
				break;
			}
			
			case 5: {
				anmelde = new Anmeldelse();
				anmelde.nyAnmeldelse(movies_database);
				break;
			}
			
			default:
				throw new IllegalArgumentException("Ikke en mulighet. Maa vaere 1-5, kan ikke vaere: " + mulighet);
			}
	}
}
