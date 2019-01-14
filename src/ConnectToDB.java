import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
	
	private static Connection conn;
	
	public static Connection getConnection() {
		if(conn == null) {
			// Connection conn = null;
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// Relativer Pfad zur Datenbank-Datei
			String datei = "DB/ProgrammDB.db3";
			String url = "jdbc:sqlite:" + datei;
			// try-catch versucht Verbindung zu SQLite aufzubauen
			try {
				conn = DriverManager.getConnection(url);
				// Gibt Nachricht aus bei funktionierender Verbindung
				System.out.println("DB gefunden!");
				return conn;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
		} 
		return conn;
	}
	

//	public static void main(String[] args) throws ClassNotFoundException {
//		ConnectToDB connect = new ConnectToDB();
//		connect.connectToDB();
//	}

	// Methode zum Aufbau einer Verbindung mit der Kunden-Datenbank
	public Connection connectToDB() {
		return getConnection();
	}
	
	 

}
