import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//
public class ZurueckgebenFensterDAO {

	KundenSpiele kundenSpiele = new KundenSpiele();
	Connection conn = null;
	private Statement statement = null;

  public void deleteKundeSpiel(String kunde) throws ClassNotFoundException {
		ResultSet resultSet = null;
		try {
			String sql = "Delete * from Kunde-Spiele Where SpieleID  = " + kundenSpiele.getSpieleID()
					+ "AND where KundenID = " + kundenSpiele.getKundenID();

			Statement statement = this.conn.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			System.out.println(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet selectKundeSpieleDao(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
	
		try {
			String sql = "SELECT DISTINCT Kunden.id, Spiele.id, FROM KundenSpiele" + 
					"Kunden.nachname" + kundenSpiele.getKundenID() + "FROM ((Kunden" + 
					"INNER JOIN Spiele ON Kunden.id = Spiele.id)" + 
					"INNER JOIN KundenSpiele ON Spiele.id = Kunden.id)"
					+ "WHERE KundenSpiele.Spiel = )" + kundenSpiele.getSpieleID(); 
					
			
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}

	public ResultSet update(int lageranzahl, String verfuegbarkeit) throws ClassNotFoundException {
		ResultSet rs = null;
		
		if (spiele.getLageranzahl() == 0) {
			String sql = "Delete KundenSpiele.ausleihmenge From KundenSpiele WHERE KundenSpiele =" + kundenSpiele.getAusleihmenge();
			//String daten = f.getZurueckgebenFenster();
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
	public String datenAusgabe(ZurueckgebenFenster zurueck) {
		
		// Wird noch bearbeitet!
		
		
		
		return null;
		
	}
}
	public ResultSet searchForKundenspiele(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		conn = ConnectToDB.getConnection();
		String sql = "SELECT KUNDENSPIELE.* FROM KUNDENSPIELE INNER JOIN KUNDEN ON KUNDENSPIELE.KUNDENID"
				+ " = KUNDEN.ID WHERE KUNDEN.NACHNAME = '" + kunde.toLowerCase() + "'";
		System.out.println(sql);
		try {
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
