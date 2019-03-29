
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Top10SpieleFensterDAO {

	Statement statement = null;

	public ResultSet getTop10Games() throws SQLException {
		ResultSet rs = null;
		String sql = "SELECT id, titel, ausleihcounter, veroeffentlichkeitsdatum FROM Spiele ORDER BY ausleihcounter DESC LIMIT 10";
		try {
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}

}
