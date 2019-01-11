<<<<<<< HEAD:src/KundenDAO.java
import net.proteanit.sql.DbUtils;
=======
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//import net.proteanit.sql.DbUtils;
>>>>>>> master:src/KundenverwaltungDAO.java

import java.sql.*;

public class KundenDAO {

	// Methode zum Anzeigen aller Datensätze der Spalte name
	public static ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		try {
			String sql = "SELECT DISTINCT * FROM test WHERE LOWER(vorname) = '" + kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = ConnectToDB.connectToDB();
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
	public void Zurueckgeben (Spiele spiele) throws ClassNotFoundException {
		Connection conn = ConnectToDB.connectToDB();
		Spiele spiel = new Spiele();

		try {
			String titel = Spiele.getTitel();
			String kdnnachname = getKdnnachname();
			Statement statement;
			statement = conn.createStatement();
			statement.executeUpdate("SELECT * FROM Kunde-Spiele where Spiel =" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}finally  {
			
		}
		
	}
}
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//import net.proteanit.sql.DbUtils;

import java.sql.*;

public class KundenverwaltungDAO {

	// Methode zum Anzeigen aller Datensätze der Spalte name
	public static ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		try {
			String sql = "SELECT DISTINCT * FROM test WHERE LOWER(vorname) = '" + kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = ConnectToDB.connectToDB();
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
}
>>>>>>> 210b9c96296de825c737a89edf86a3c4b0a4d511
