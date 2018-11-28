package Datenbankverbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {
	private String url;
	private String datei;
	
	
	public SQLite() throws SQLException {
		this.datei = "h:/SQLite";
		this.url = "jdbc:sqlite:" + datei;
		 
		try {
			Class.forName("org.sqlite.JDBC");
		 Connection connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
