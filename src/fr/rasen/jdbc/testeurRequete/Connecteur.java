package fr.rasen.jdbc.testeurRequete;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connecteur {

	private static String url = "jdbc:postgresql://localhost:5432/Ecole";
	private static String pass = "sebastien";
	private static String user = "postgres";
	
	private static Connection connect;
	
	public static Connection getInstance() {
		if (connect == null) {
			try {
				connect = DriverManager.getConnection(url,user,pass);
			} catch (Exception e) {
				System.out.println("Problème de connection");
			}
		}
		return connect;
	}
}
