import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpielDAO {
	
	ConnectToDB connect = new ConnectToDB();
	Spiel spiel = new Spiel();
	
	public Spiel selectSpiel(String ausgewaehltesSpiel) throws ClassNotFoundException, SQLException {
		Connection conn = connect.connectToDB();
		try {
			String sql = "SELECT * FROM Spiele WHERE id = '" + ausgewaehltesSpiel + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			rs.next();
			spiel.setId(rs.getString("id"));
			spiel.setTitel(rs.getString("titel"));
			spiel.setGenre(rs.getString("genre"));
			spiel.setVeroeffentlichkeitsdatum(rs.getString("veroeffentlichkeitsdatum"));
			spiel.setUsk(rs.getString("usk"));
			spiel.setPreis(rs.getDouble("preis"));
			spiel.setLageranzahl(rs.getInt("lageranzahl"));
			spiel.setVerfuegbarkeit(rs.getString("verfuegbarkeit"));
			spiel.setSprache(rs.getString("sprache"));
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
			System.out.println(spiel.getTitel());
			return spiel;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
