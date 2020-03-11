package Prosjekt;

import java.util.Scanner;

public class Main extends DBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rolle rolle;
		Selskap selskap;
		Film film;
		Anmeldelse anmelde;
		
		try {
			film = new Film();
			film.connect();
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Gjør koden ordentlig!!!");
		}
		
		System.out.println("Hva vil du gjøre (1-5)?");
		System.out.println("1. Finne navnet på alle rollene en gitt skuespiller har.");
		System.out.println("2. Finne hvilke filmer som en gitt skuespiller opptrer i.");
		System.out.println("3. Finne hvilke filmselskap som lager flest filmer inne hver sjanger (grøssere, familie,\r\n" + 
				"//o.l.).");
		System.out.println("4. Sette inn en ny film med regissør, manusforfattere, skuespillere og det som hører med.");
		System.out.println("5. Sette inn ny anmeldelse av en episode i en serie.");
		System.out.println("Skriv inn en ett for for hva du vil gjøre: ");
		Scanner scanner = new Scanner(System.in);
		int mulighet = scanner.nextInt();
		
		switch (mulighet) {
			case 1: {
				System.out.println("Hva er ID'n til personen:");
				Scanner scanner1 = new Scanner(System.in);
				int id = scanner.nextInt();
				
				rolle = new Rolle(id);
				rolle.getRolle(id);
				break;
			}
			
			case 2: {
				System.out.println("Hva er ID'n til personen:");
				Scanner scanner1 = new Scanner(System.in);
				int id = scanner.nextInt();
				
				film = new Film(id);
				film.getFilmForSkuespiller(id);
				break;
			}
			
			case 3: {
				selskap = new Selskap();
				selskap.getFilmer();
				break;
			}
			
			case 4: {
				film = new Film();
				film.setFilm();	
				break;
			}
			
			case 5: {
				anmelde = new Anmeldelse();
				anmelde.nyAnmeldelse();
				break;
			}
			
			default:
				throw new IllegalArgumentException("Ikke en mulighet. Må være 1-5, kan ikke være: " + mulighet);
			}
		}

}

