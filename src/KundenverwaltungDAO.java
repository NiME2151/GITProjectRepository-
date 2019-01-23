

//import net.proteanit.sql.DbUtils;

import java.sql.*;

public class KundenverwaltungDAO {
	Kundenverwaltung kundenverwaltung;
	ConnectToDB conn = new ConnectToDB();
	
	public static ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		try {
			String sql = "SELECT DISTINCT * FROM test WHERE LOWER(vorname) = '" + kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = ConnectToDB.getConnection();
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
	
	/*public void delete(Kundenverwaltung kundenVerwaltung) {
		Connection conn = ConnectToDB.getConnection();
		kundenverwaltung = new Kundenverwaltung();
		try {
			String sql = "DELETE FROM Kunde WHERE id = " + kundenverwaltung.getId();
			PreparedStatement statement = ((Connection) this.conn).prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
