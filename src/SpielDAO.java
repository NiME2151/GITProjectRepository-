import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpielDAO {
	
	ConnectToDB connect = new ConnectToDB();
	
	public Spiel selectSpiel(String titel) throws ClassNotFoundException, SQLException {
		Spiel spiel = new Spiel();
		try {
			String sql = "SELECT * FROM Spiel WHERE titel = " + titel;
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = connect.connectToDB();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			rs.next();
			spiel.setId(rs.getInt("id"));
			spiel.setTitel(rs.getString("titel"));
			spiel.setVeroeffentlichkeitsdatum(rs.getString("veröffentilichkeitsdatum"));
			spiel.setUsk(rs.getString("usk"));
			spiel.setPreis(rs.getDouble("preis"));
			spiel.setLageranzahl(rs.getInt("lageranzahl"));
			spiel.setVerfuegbarkeit(rs.getString("verfügbarkeit"));
			spiel.setSprache(rs.getString("sprache"));
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
			return spiel;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
