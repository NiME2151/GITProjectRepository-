package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class DBVerbindungHerstellen {

	// Methode zum Aufbau einer Verbindung mit SQLite
	private static Connection connect() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		// Verzeichnispfad h�ngt davon ab wo eine Datei ist
		String datei = "C:\\Users\\supervisor\\Desktop\\Programme\\test.db3";
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

	// Methode zum Anzeigen aller Datens�tze der Spalte name
	public static void select() throws ClassNotFoundException {
		try {
			String sql = "SELECT * FROM test";
			// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank herzustellen
			Connection conn = connect();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			// while zeigt alle Datens�tze der Spalte name an
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// main f�hrt select Befehl zum Testen aus
		select();
	}
}
