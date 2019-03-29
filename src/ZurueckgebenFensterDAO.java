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
	PreparedStatement preparedStatement = null;
	GetWertInZeile getAusleihCounter = new GetWertInZeile();

	private Statement statement = null;

	public ResultSet deleteKundeSpiel(String kunden) throws ClassNotFoundException {

		try {
			String sql = "Delete from KundenSpiele Where SpieleID = " + kundenSpiele.getSpieleID();
			// + "AND Where KundenSpiele.KundenID = " + kundenSpiele.getKundenID();

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
			String sql = "Delete KundenSpiele.ausleihmenge From KundenSpiele WHERE KundenSpiele ="
					+ kundenSpiele.getAusleihmenge();

			// Die Daten vom ZurueckgebenFenster mï¿½ssen in einer Methode geschrieben
			// werden und hier ï¿½bergeben werden (siehe Unten!)
		} else {
			// Hier kommt nichts mehr hin!
		}

		try {
			String sql = "UPDATE Spiele SET Lageranzahl =" + spiele.getLageranzahl() + "SET Verfï¿½gbar ="
					+ spiele.getVerfuegbarkeit();
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
		System.out.println(kunde);
		ResultSet rs = null;
		String sql = "SELECT KUNDENSPIELE.* FROM KUNDENSPIELE INNER JOIN KUNDEN ON KUNDENSPIELE.KUNDENID"
				+ " = KUNDEN.ID WHERE LOWER(KUNDEN.NACHNAME) = '" + kunde.toLowerCase() + "'";
		try {
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println(sql);
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}

	public void decreaseCounter(String spieleID, String ausleihmenge) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		String sqlAusleihmenge = "UPDATE Spiele SET Lageranzahl = Lageranzahl+" + ausleihmenge +  " WHERE ID = '" + spieleID + "'";
		String sqlVerfuegbarkeit = "UPDATE Spiele SET Verfuegbarkeit = 'verfügbar' WHERE ID = '" + spieleID + "'";
		int lageranzahl = new SpielDAO().selectSpiel(spieleID).getLageranzahl();
		System.out.println("lageranzahl: " + lageranzahl);
		if (Integer.valueOf(lageranzahl) > 0) {
			try {
				// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
				// herzustellen
				Connection conn = ConnectToDB.getConnection();
				preparedStatement = conn.prepareStatement(sqlAusleihmenge);
				statement.executeUpdate(sqlAusleihmenge);
				// Gibt Nachricht aus bei funktionierendem SELECT
				System.out.println("SQL-SELECT funzt");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (Integer.valueOf(lageranzahl) <= 0) {
			try {
				// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
				// herzustellen
				Connection conn = ConnectToDB.getConnection();
				preparedStatement = conn.prepareStatement(sqlVerfuegbarkeit);
				statement.executeUpdate(sqlVerfuegbarkeit);
				preparedStatement = conn.prepareStatement(sqlAusleihmenge);
				statement.executeUpdate(sqlAusleihmenge);
				// Gibt Nachricht aus bei funktionierendem SELECT
				System.out.println("SQL-SELECT funzt");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void zurueckgeben(String spieleID, String kundenID, String faelligkeitsdatum, String ausleihdatum) {
		ResultSet rs = null;
		System.out.println(spieleID + " " + kundenID + " " + faelligkeitsdatum + " " + ausleihdatum);
		String sql = "DELETE FROM KundenSpiele WHERE SpieleID = '" + spieleID + "' AND KundenID = '" + kundenID 
		+ "' AND Faelligkeitsdatum = '" + faelligkeitsdatum + "' AND Ausleihdatum = '" + ausleihdatum + "'";
		System.out.println(sql);
		try {
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = ConnectToDB.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			statement.executeUpdate(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
