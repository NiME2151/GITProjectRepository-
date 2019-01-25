
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class KundenDAO {
	
	private Statement statement = null;
	ConnectToDB connect = new ConnectToDB();
	
	// Methode zum Anzeigen aller Datensätze der Spalte name
	public ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		Connection conn = connect.connectToDB();
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.strasse FROM Kunden WHERE LOWER(Kunden.vorname) = '" + kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}
	
	public ResultSet selectKundeAusleihfenster(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		Connection conn = connect.connectToDB();
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.iban, Kunden.strasse FROM Kunden WHERE LOWER(Kunden.vorname) = '" + kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}
}
