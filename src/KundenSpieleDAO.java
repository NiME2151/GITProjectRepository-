import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KundenSpieleDAO {
	
	private Connection conn = null;
	private PreparedStatement statement = null;
	
	public void insertToKundenSpiele(KundenSpiele kundenSpiele) throws SQLException, ClassNotFoundException {
		try {
			String spieleID = kundenSpiele.getSpieleID();
			String kundenID = kundenSpiele.getKundenID();
			double ausleihpreis = kundenSpiele.getPreis();
			String ausleihmenge = kundenSpiele.getAusleihmenge();
			String faelligkeitsdatum = kundenSpiele.getFaelligkeitsdatum();
			String ausleihdatum = kundenSpiele.getAusleihdatum();
			String sql = "INSERT INTO KundenSpiele VALUES ('" + spieleID + "', '" + kundenID + "', '" + ausleihpreis + "', '" + ausleihmenge + "', '" + faelligkeitsdatum + "', " + "CURRENT_DATE)";
			Connection conn = ConnectToDB.getConnection();
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println(spieleID + "\n" + kundenID+ "\n" + ausleihpreis + "\n" + ausleihmenge + "\n" + faelligkeitsdatum+ "\n" + ausleihdatum + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public ResultSet selectKundeSpieleDao(String string) throws ClassNotFoundException {
		ResultSet rs = null;
	
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.strasse FROM KundenSpiele"
					+ " WHERE LOWER(Kunden.vorname) = '"+ kunde.toLowerCase() + "'";
			
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}
}

