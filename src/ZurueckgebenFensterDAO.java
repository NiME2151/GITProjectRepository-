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
	
	public static ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		try {
			String sql = "SELECT DISTINCT * FROM Kunde WHERE LOWER(vorname) = '" + kunde.toLowerCase() + "'";
			
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
	public ResultSet deleteKundeSpiel(String kunde) throws ClassNotFoundException {
		try {
			 String sql = "Delete * from Kunde-Spiele Where ID = " + kundenSpiele.getId();
			
			 Statement statement = this.conn.prepareStatement(sql); 
			 ResultSet resultSet = statement.executeQuery(sql); 
			 resultSet.next(); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
