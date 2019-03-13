import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//
public class ZurueckgebenFensterDAO {

	KundenSpiele kundenSpiele = new KundenSpiele();
	Spiel spiele = new Spiel();
	Connection conn = ConnectToDB.getConnection();
	Kunde kunde = new Kunde();
	
	private Statement statement = null;

	
	public ResultSet deleteKundeSpiel(String kunden) throws ClassNotFoundException {
		
		try {
			 String sql = "Delete from KundenSpiele Where SpieleID = " + kundenSpiele.getSpieleID();
			 //+ "AND Where KundenSpiele.KundenID = " + kundenSpiele.getKundenID();
			
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

	public ResultSet update(int lageranzahl, String verfuegbarkeit) throws ClassNotFoundException {
		ResultSet rs = null;
		
		if (spiele.getLageranzahl() == 0) {
			String sql = "Delete KundenSpiele.ausleihmenge From KundenSpiele WHERE KundenSpiele =" + kundenSpiele.getAusleihmenge();
			
			
			// Die Daten vom ZurueckgebenFenster m�ssen in einer Methode geschrieben werden und hier �bergeben werden (siehe Unten!)
		} else {
			// Hier kommt nichts mehr hin!
		}
		
		try {
			String sql = "UPDATE Spiele SET Lageranzahl =" + spiele.getLageranzahl() + "SET Verf�gbar =" + spiele.getVerfuegbarkeit();  
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println("SQL-SELECT funzt");
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}
	public ResultSet datenAusgabe(ZurueckgebenFenster zurueck) {
		 	
		
		
		
		return null;
	}

	public ResultSet searchForKundenspiele(String kunde) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		conn = ConnectToDB.getConnection();
		String sql = "SELECT KUNDENSPIELE.* FROM KUNDENSPIELE INNER JOIN KUNDEN ON KUNDENSPIELE.KUNDENID"
				+ " = KUNDEN.ID WHERE KUNDEN.NACHNAME = ?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, kunde.toLowerCase());
		preparedStatement.executeQuery();
		System.out.println(sql);
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
