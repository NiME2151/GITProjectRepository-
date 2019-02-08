import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class KundenDAO {
	
	public static void main(String[]args) {
		KundenDAO kd = new KundenDAO();
		try {
			kd.add("7", "Fabian", "Huge", "1234567890123456789012", "HUGE@HUGE.de", "04216737373", "HUGE-Str 77", "28307", "Bremen");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Statement statement = null;
	ConnectToDB connect = new ConnectToDB();
	
	// Methode zum Anzeigen Datensätze der Spalte name
	public ResultSet selectKunde(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		Connection conn = connect.connectToDB();
		try {
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.strasse FROM Kunden WHERE LOWER(Kunden.vorname) = '" + kunde.toLowerCase() + "'";
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
			String sql = "SELECT DISTINCT Kunden.id, Kunden.vorname, Kunden.nachname, Kunden.iban, Kunden.strasse FROM Kunden WHERE LOWER(Kunden.nachname) = '" + kunde.toLowerCase() + "'";
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
	
	public ResultSet delete(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		Connection conn = connect.connectToDB();
		try {
			String sql = "DELETE FROM Kunden WHERE id = "+ kunde.toLowerCase();
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// Gibt Nachricht aus bei Funktionierenden Select
			System.out.println("SQL-SELECT funzt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}
	
	public void add(String id, String vorname, String nachname, String strasse, String iban, String email, String telefonnumer, String plz, String ort) throws ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection conn = connect.connectToDB();
		try{
			String sql = "INSERT INTO Kunden values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, vorname);
			preparedStatement.setString(3, nachname);
			preparedStatement.setString(4, iban);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, telefonnumer);
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
	
	public void change(String vorname, String nachname, String strasse, String iban, String email, String telefonnumer, String plz, String ort) throws ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection conn = connect.connectToDB();
		try {
		String sql = "UPDATE Kunde SET vorname = ?, nachname = ?, strasse = ?, iban = ?, email = ?, telefonnumer = ?, plz = ?, ort = ?";
		preparedStatement.setString(1, vorname);
		preparedStatement.setString(2, nachname);
		preparedStatement.setString(3, iban);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, telefonnumer);
		preparedStatement.setString(6, strasse);
		preparedStatement.setString(7, plz);
		preparedStatement.setString(8, ort);
	

		}
		catch (SQLException e) {
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
}

	
