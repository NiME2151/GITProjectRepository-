import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//
public class ZurueckgebenFensterDAO {
	Kundenverwaltung kundenverwaltung;
	Spiel spiele;
	Spieledetailfenster spielFenster;	
	KundenSpiele kundenSpiele = new KundenSpiele();
	Connection conn = ConnectToDB.getConnection();
	private Statement statement = null;
	
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

	public ResultSet selectKundeSpieleDao(String kunde) throws ClassNotFoundException {
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
	
	public ResultSet searchForKundenspiele(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
			String sql = "SELECT KUNDENSPIELE.*, KUNDEN.VORNAME, FROM KUNDEN INNER JOIN KUNDENSPIELE ON KUNDEN.ID"
					+ " = KUNDENSPIELE.KUNDENID WHERE KUNDEN.VORNAME = KUNDENID"
					+ kunde.toLowerCase() + "'";
			
		try {
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
			
			
					
		}
		
	}

