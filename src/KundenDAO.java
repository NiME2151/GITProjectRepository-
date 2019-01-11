import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class KundenDAO {
	
	ConnectToDB connect = new ConnectToDB();
	
	// Methode zum Anzeigen aller Datens�tze der Spalte name
	public ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		Connection conn = connect.connectToDB();
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.strasse FROM Kunden WHERE LOWER(Kunden.vorname) = '" + kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
			// herzustellen
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
