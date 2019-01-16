import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KundenSpieleDAO {
	
	private Connection conn = null;
	private PreparedStatement statement = null;
	
	public void insertToKundenSpiele(KundenSpiele kundenSpiele) throws SQLException, ClassNotFoundException {
		//Spiel spiel = new Spiel();
		//KundenSpiele kundenSpiele = new KundenSpiele();
		try {
			int spielID = kundenSpiele.getId();
			String spieltitel = kundenSpiele.getSpieltitel();
			String spielRelease = kundenSpiele.getSpielRelease();
			String kundennachname = kundenSpiele.getKundennachname();
			String kundenIBAN = kundenSpiele.getKundenIBAN();
			double preis = kundenSpiele.getPreis();
			String menge = kundenSpiele.getMenge();
			String faelligkeitsdatum = kundenSpiele.getFaelligkeitsdatum();
			//String ausleihdatum = kundenSpiele.getAusleihdatum();
			String sql = "INSERT INTO KundenSpiele VALUES ('"  + spielID + "', '" + spieltitel + "', '" + spielRelease + "', '" + kundennachname + "', '" + kundenIBAN + 
					"', '" + preis + "', '" + menge + "', '" + faelligkeitsdatum + "', 'CURRENT_DATE')";
			Connection conn = ConnectToDB.getConnection();
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println(spielID + "\n" + spieltitel + "\n" + spielRelease + "\n" + kundennachname + "\n" + kundenIBAN + "\n" + preis + "\n" + menge + "\n" + faelligkeitsdatum + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
