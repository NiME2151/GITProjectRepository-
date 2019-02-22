import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
//
public class ZurueckgebenFensterDAO {
	Kundenverwaltung kundenverwaltung;
	Spiel spiele = new Spiel();
	Spieledetailfenster spielFenster;
	GetWertInZeile f = new GetWertInZeile();
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
			// Die Daten vom ZurueckgebenFenster müssen in einer Methode geschrieben werden und hier übergeben werden (siehe Unten!)
		} else {
			// Hier kommt nichts mehr hin!
		}
		
		try {
			String sql = "UPDATE Spiele SET Lageranzahl =" + spiele.getLageranzahl() + "SET Verfügbar =" + spiele.getVerfuegbarkeit();  
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
