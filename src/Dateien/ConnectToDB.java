package Dateien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

	// Methode zum Aufbau einer Verbindung mit SQLite
		public static Connection connectToDB() throws ClassNotFoundException {
			Class.forName("org.sqlite.JDBC");
			// Verzeichnispfad hängt davon ab wo eine Datei ist
			String dateiNico = "C:\\Users/supervisor/Desktop/Programme/test.db3";
			String datei = "H:\\test.db3";
			String url = "jdbc:sqlite:" + dateiNico;
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

}
