import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class KundenverwaltungDAO {
	
	ConnectToDB connect = new ConnectToDB();
	
	// Methode zum Anzeigen aller Datensätze der Spalte name
	public ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		try {
			String sql = "SELECT DISTINCT * FROM test WHERE LOWER(vorname) = '" + kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = connect.connectToDB();
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
