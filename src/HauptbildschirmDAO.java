import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.*;
import javax.sql.rowset.CachedRowSet;

public class HauptbildschirmDAO {
	
	ConnectToDB connect = new ConnectToDB();
	
	private String alphabetischFilterWert;
	private Spiel spiel;
	private String sortierung;
	private ArrayList<Spiel> spieleliste;
	private Connection conn = null;
	private ResultSet rs = null;
	private Statement statement = null;

	public HauptbildschirmDAO(String eingabe) {
		this.alphabetischFilterWert = eingabe;
	}
	
	// Funzt grade nicht. Es kann kein ResultSet zurückgegeben werden und die Verbindung geschlossen werden!
	// Herr Heidemann muss um Rat gebeten werden
	public ResultSet orderBy(String eingabe) throws SQLException {		
		if (eingabe.equalsIgnoreCase("absteigend")) {
			sortierung = "DESC";
		}
		else if (eingabe.equalsIgnoreCase("aufsteigend")) {
			sortierung = "ASC";
		}
		try {
			String sql = "SELECT Spiele.id, Spiele.titel, Spiele.genre, Spiele.veroeffentlichkeitsdatum, Spiele.verfuegbarkeit FROM Spiele ORDER BY TITEL " + sortierung;
			conn = connect.connectToDB();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			conn.close();
			rs.close();
			statement.close();
		}
		return rs;
	}
	
	public ResultSet sucheNachSpiel(String eingabe) throws ClassNotFoundException {
		String sql = "SELECT Spiele.id, Spiele.titel, Spiele.genre, Spiele.veroeffentlichkeitsdatum, Spiele.verfuegbarkeit FROM Spiele WHERE titel LIKE '%" + eingabe + "%' LIMIT 10";
		if (eingabe.equalsIgnoreCase("")) {
			sql = "SELECT Spiele.id, Spiele.titel, Spiele.genre, Spiele.veroeffentlichkeitsdatum, Spiele.verfuegbarkeit FROM Spiele";
		}
		try {
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = connect.connectToDB();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}


	


