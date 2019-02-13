import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZuruckgebenFensterDAO {
	Kundenverwaltung kundenverwaltung;
	Spiel spiele;
	Connection conn = ConnectToDB.getConnection();
	
	public static ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		try {
			String sql = "SELECT DISTINCT * FROM Kunden-Spiele WHERE LOWER(vorname) = '" + kunde.toLowerCase() + "'";
			
			Connection conn = ConnectToDB.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println("SQL-SELECT funzt");
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
