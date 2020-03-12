
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
	Statement stmnt;

	public queries(){
		movies = new connect();
	}

	private String read_sql_file(){
		Path path = Paths.get("src/main/java/resources/sql_script");
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
				stmnt = movies.conn.createStatement();
				System.out.println("Creating database\n");

				for(int i=0; i<sql_statements.length-1; i++){
					sql_statements[i] += ';';
					stmnt.execute(sql_statements[i]);
				}
			}	catch (Exception e) {System.out.println("Could not execute sql statements\n");}
		}
	}
}


/*
			for(int i=1; i<(sql.length()); i++){
				sql_statement = "";
				while(sql_statement.charAt(i)!=';'){ i++;
					sql_statement += String.valueOf(sql.charAt(i));
				}
				System.out.println("statement: " + sql_statement);
				stmnt.execute(sql_statement);
			}
			} catch(Exception e){
				System.out.println("Could not create database\n");
			}
*/
