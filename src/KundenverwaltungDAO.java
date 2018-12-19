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
	public void Zurueckgeben (Kundenverwaltung kundenverwaltung) {
		//Connection conn = ConnectToDB.connectToDB();
		
		try {
			Kundenverwaltung kunde = new Kundenverwaltung();
			/*int id = kunde.getId();
			String name = kunde.getName();
			String fsk = kunde.getFsk();
			String datum = kunde.getDatum();
			String beschreibung = kunde.getBeschreibung();
			Statement statement;
			statement = this.conn.createStatement();
			statement.executeUpdate("INSERT INTO EMAIL VALUES (" + id + ", " + name + ", " + fsk + ", " + datum + ", "+ beschreibung + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); */ 
		}finally {
			
		}
		
	}
}
