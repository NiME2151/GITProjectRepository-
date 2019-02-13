import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZurueckgebenFensterDAO {
	Kundenverwaltung kundenverwaltung;
	Spiel spiele;
	Spieledetailfenster spielFenster;	
	KundenSpiele kundenSpiele = new KundenSpiele();
	Connection conn = ConnectToDB.getConnection();
	
	public ResultSet deleteKundeSpiel(String kunde) throws ClassNotFoundException {
		try {
			 String sql = "Delete * from Kunde-Spiele Where SpieleID  = " + kundenSpiele.getSpieleID()
			 + "AND where KundenID = " + kundenSpiele.getKundenID();
			
			 Statement statement = this.conn.prepareStatement(sql); 
			 ResultSet resultSet = statement.executeQuery(sql); 
			 resultSet.next(); 
			System.out.println(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public ResultSet selectKundeSpieleDao(String kunde, int spiele) throws ClassNotFoundException {
		ResultSet rs = null;
	
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.strasse FROM KundenSpiele"
					+ " WHERE LOWER(Kunden.vorname) = '"
					+ kunde.toLowerCase() + "'";
			
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
