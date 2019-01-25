
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpielDAO {
	
	private PreparedStatement statement = null;
	Spiel spiel = new Spiel();
	
	public Spiel selectSpiel(String ausgewaehltesSpiel) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		Connection conn = ConnectToDB.getConnection();
		try {
			String sql = "SELECT * FROM Spiele WHERE id = '" + ausgewaehltesSpiel + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			rs.next();
			spiel.setId(rs.getInt("id"));
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return spiel;
	}
}
