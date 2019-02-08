import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class KundenDAO {

	private Statement statement = null;
	ConnectToDB connect = new ConnectToDB();

	// Methode zum Anzeigen aller Datensätze der Spalte name
	public ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		Connection conn = connect.connectToDB();
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.strasse FROM Kunden WHERE LOWER(Kunden.vorname) = '"
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

	public ResultSet selectKundeAusleihfenster(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		Connection conn = connect.connectToDB();
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
		Connection conn = connect.connectToDB();
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
		Kunde kunde = new Kunde();
		Connection conn = connect.connectToDB();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "SELECT * FROM KUNDEN where id = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet rS = preparedStatement.executeQuery();
			kunde.setId(rS.getString(1));
			System.out.println(kunde.getId());
			kunde.setVorname(rS.getString(2));
			kunde.setNachname(rS.getString(3));
			kunde.setIban(rS.getString(4));
			kunde.setEmail(rS.getString(5));
			kunde.setTelefonnummer(rS.getString(6));
			kunde.setStrasse(rS.getString(7));
			kunde.setPlz(rS.getString(8));
			kunde.setOrt(rS.getString(9));
			System.out.println(kunde.getVorname());
		} catch (Exception e) {
			e.getMessage();
		}
		return kunde;
	}
}
