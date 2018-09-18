package fr.rasen.jdbc.accesBaseDonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SdzConnection{

	private static String url = "jdbc:postgresql://localhost:5432/Ecole";
	private static String user = "postgres";
	private static String passwd = "postgres";
	private static Connection connect;

	public static Connection getInstance(){
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}      
		return connect;
	}   
}