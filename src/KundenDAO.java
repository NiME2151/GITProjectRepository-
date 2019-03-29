
//
import java.sql.Statement;
import java.sql.*;

public class KundenDAO {

	private Statement statement = null;
	ConnectToDB connect = new ConnectToDB();
	PreparedStatement preparedStatement = null;
	Kunde kunde = new Kunde();

	// Methode zum Anzeigen aller Datensätze der Spalte name
	public ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		Connection conn = ConnectToDB.connectToDB();
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.strasse FROM Kunden WHERE LOWER(Kunden.nachname) = '"
					+ kunde.toLowerCase() + "'";

			

			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen

			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}

	public ResultSet selectKundeAusleihfenster(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		Connection conn = ConnectToDB.connectToDB();
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.iban, Kunden.strasse FROM Kunden WHERE LOWER(Kunden.nachname) = '"
					+ kunde.toLowerCase() + "'";
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}

	public void delete(String kundenID) throws ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		Connection conn = ConnectToDB.connectToDB();
		try {
			String sql = "DELETE FROM Kunden WHERE id = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, kundenID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Kunde selectKundeKundenverwaltung(String id) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		Connection conn = ConnectToDB.connectToDB();
		try {
			String sql = "SELECT * FROM KUNDEN WHERE ID = '" + id + "'";
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			rs.next();
			// preparedStatement.setString(1, id);
			kunde.setId(rs.getString("id"));
			kunde.setVorname(rs.getString("vorname"));
			kunde.setNachname(rs.getString("nachname"));
			kunde.setIban(rs.getString("iban"));
			kunde.setEmail(rs.getString("email"));
			kunde.setTelefonnummer(rs.getString("telefonnummer"));
			kunde.setStrasse(rs.getString("strasse"));
			kunde.setPlz(rs.getString("plz"));
			kunde.setOrt(rs.getString("ort"));
			System.out.println(kunde.getEmail());
		} catch (Exception e) {
			e.getMessage();
		}
		return kunde;
	}
	public void add(String id, String vorname, String nachname, String iban, String email, String telefonnummer, String strasse, String plz, String ort) throws ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection conn = ConnectToDB.connectToDB();
		try{
			String sql = "INSERT INTO Kunden values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, vorname);
			preparedStatement.setString(3, nachname);
			preparedStatement.setString(4, iban);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, telefonnummer);
			preparedStatement.setString(7, strasse);
			preparedStatement.setString(8, plz);
			preparedStatement.setString(9, ort);
			preparedStatement.executeUpdate();
	}  catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			preparedStatement.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
}
		
		}
	
	}
	public void update(Kunde kunde) throws ClassNotFoundException  {
		

		try {
			// connect()-Methode wird ausgefï¿½hrt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = ConnectToDB.getConnection();
			String sql = "UPDATE Kunden SET vorname = ?, nachname = ?, iban = ?,"
					+ "email = ?, telefonnummer = ?,  strasse = ?, ort = ?, plz  = ? WHERE id LIKE ?" ;
			PreparedStatement updateValues = conn.prepareStatement(sql);
			updateValues.setString(9, kunde.getId());
			updateValues.setString(1, kunde.getVorname());
			updateValues.setString(2, kunde.getNachname());
			updateValues.setString(3, kunde.getIban());
			updateValues.setString(4,kunde.getEmail());
			updateValues.setString(5, kunde.getTelefonnummer());
			updateValues.setString(6, kunde.getStrasse());
			updateValues.setString(7, kunde.getOrt());
			updateValues.setString(8, kunde.getPlz());
			updateValues.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
