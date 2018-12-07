package guis;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.sql.*;

public class DBVerbindungHerstellen {
	
	

	// Methode zum Aufbau einer Verbindung mit SQLite
	private static Connection connect() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		// Verzeichnispfad hängt davon ab wo eine Datei ist
		String datei = "H:\\test.db3";
		String url = "jdbc:sqlite:" + datei;
		Connection conn = null;
		// try-catch versucht Verbindung zu SQLite aufzubauen
		try {
			conn = DriverManager.getConnection(url);
			// Gibt Nachricht aus bei funktionierender Verbindung
			System.out.println("DB gefunden!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// Methode zum Anzeigen aller Datensätze der Spalte name
	public static ResultSet getResultSetForKundenName(String kunde) throws ClassNotFoundException {
		try {
			String sql = "SELECT DISTINCT * FROM test WHERE LOWER(vorname) = '" + kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = connect();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			
			System.out.println("SQL-SELECT funzt");

			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// main führt select Befehl zum Testen aus
		// select();
	}
}
