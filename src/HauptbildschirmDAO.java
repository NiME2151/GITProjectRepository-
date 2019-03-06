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
//
public class HauptbildschirmDAO {
		
	private String alphabetischFilterWert;
	private Spiel spiel;
	private String sortierung;
	private ArrayList<Spiel> spieleliste;
	private Statement statement = null;
	private String spalten = "Spiele.id, Spiele.titel, Spiele.genre, Spiele.usk, Spiele.veroeffentlichkeitsdatum, Spiele.preis AS 'Preis (Euro)' , Spiele.verfuegbarkeit";
	
	public ResultSet orderBy(String eingabe) throws SQLException {		
		ResultSet rs = null;
		if (eingabe.equalsIgnoreCase("absteigend")) {
			sortierung = "DESC";
		}
		else if (eingabe.equalsIgnoreCase("aufsteigend")) {
			sortierung = "ASC";
		}
		try {
			String sql = "SELECT " + spalten + " FROM Spiele ORDER BY TITEL " + sortierung;
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public ResultSet sucheNachSpiel(String eingabe) throws ClassNotFoundException {
		ResultSet rs = null;
		String sql = "SELECT " + spalten + " FROM Spiele WHERE titel LIKE '%" + eingabe + "%'";
		if (eingabe.equalsIgnoreCase("")) {
			sql = "SELECT " + spalten + " FROM Spiele";
		}
		try {
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public ResultSet sucheVerfuegbareSpiele(boolean eingabe) {
		ResultSet rs = null;
		String eingabeString = null;
		
		if (eingabe) {
			eingabeString = "verfügbar";
		}
		else if (!eingabe) {
			eingabeString = "verliehen";
		}
		else {
			System.out.println("fehler");
		}
		try {
			String sql = "SELECT " + spalten + " FROM Spiele WHERE verfuegbarkeit = '" + eingabeString + "'";
			System.out.println(sql);
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public ResultSet sortiereNachPreis(String eingabe) {
		ResultSet rs = null;
		if (eingabe.equalsIgnoreCase("teuerste")) {
			sortierung = "DESC";
		}
		else if (eingabe.equalsIgnoreCase("billigste")) {
			sortierung = "ASC";
		}
		try {
			String sql = "SELECT " + spalten + " FROM Spiele ORDER BY PREIS " + sortierung;
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	
	public ResultSet sortiereNachGenre(String eingabe) {
		ResultSet rs = null;
		if (eingabe.equalsIgnoreCase("Action")) {
			sortierung = "Action";
		}
		else if (eingabe.equalsIgnoreCase("Action-Adventures")) {
			sortierung = "Action-Adventures";
		}
		else if (eingabe.equalsIgnoreCase("Adventures")) {
			sortierung = "Adventures";
		}
		else if (eingabe.equalsIgnoreCase("Textadventures")) {
			sortierung = "Textadventures";
		}
		else if (eingabe.equalsIgnoreCase("Horror")) {
			sortierung = "Horror";
		}
		else if (eingabe.equalsIgnoreCase("Shooter")) {
			sortierung = "Shooter";
		}
		else if (eingabe.equalsIgnoreCase("Erotik")) {
			sortierung = "Erotik";
		}
		else if (eingabe.equalsIgnoreCase("Geschicklichtkeitsspiele")) {
			sortierung = "Geschicklichtkeitsspiele";
		}
		else if (eingabe.equalsIgnoreCase("Jump 'n' Runs")) {
			sortierung = "Jump 'n' Runs";
		}
		else if (eingabe.equalsIgnoreCase("Lernspiele")) {
			sortierung = "Lernspiele";
		}
		else if (eingabe.equalsIgnoreCase("Open-World")) {
			sortierung = "Open-World";
		}
		else if (eingabe.equalsIgnoreCase("Musikspiele")) {
			sortierung = "Musikspiele";
		}
		else if (eingabe.equalsIgnoreCase("R\\u00E4tselspiele")) {
			sortierung = "R\\u00E4tselspiele";
		}
		else if (eingabe.equalsIgnoreCase("RPG")) {
			sortierung = "RPG";
		}
		else if (eingabe.equalsIgnoreCase("Simulation")) {
			sortierung = "Simulation";
		}
		else if (eingabe.equalsIgnoreCase("Sport")) {
			sortierung = "Sport";
		}
		else if (eingabe.equalsIgnoreCase("Strategie")) {
			sortierung = "Strategie";
		}
		try {
			String sql = "SELECT " + spalten + " FROM Spiele WHERE Genre= " + sortierung;
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}	
	
	
	public ResultSet sortiereNachUSK(String eingabe) {
		String sortierung = null;
		String sql = null;
		int welcherSQLBefehl = 0;
		
		ResultSet rs = null;
		if (eingabe.equalsIgnoreCase("Von USK 18 bis USK 0")) {
			sortierung = "DESC";
			welcherSQLBefehl = 1;
		}
		else if (eingabe.equalsIgnoreCase("Von USK 0 bis USK 18")) {
			sortierung = "ASC";
			welcherSQLBefehl = 1;
		}
		else if (eingabe.equalsIgnoreCase("Nur USK 0")) {
			eingabe = "0";
			welcherSQLBefehl = 2;
		}
		else if (eingabe.equalsIgnoreCase("Nur USK 6")) {
			eingabe = "6";
			welcherSQLBefehl = 2;
		}
		else if (eingabe.equalsIgnoreCase("Nur USK 12")) {
			eingabe = "12";
			welcherSQLBefehl = 2;
		}
		else if (eingabe.equalsIgnoreCase("Nur USK 16")) {
			eingabe = "16";
			welcherSQLBefehl = 2;
		}
		else if (eingabe.equalsIgnoreCase("Nur USK 18")) {
			eingabe = "18";
			welcherSQLBefehl = 2;
		}
		else {
			System.out.println("fehler in HauptbildschirmDAO (itemState-Check)");
		}
		
		String sqlWHERE = "SELECT " + spalten + " FROM Spiele WHERE usk = " + eingabe;
		String sqlOrderBy = "SELECT " + spalten + " FROM Spiele ORDER BY usk " + sortierung;
		
		if (welcherSQLBefehl == 1) {
			sql = sqlOrderBy;
		}
		else if (welcherSQLBefehl == 2) {
			sql = sqlWHERE;
		}
		else {
			System.out.println("fehler in HauptbildschirmDAO (sqlBefehl-Check)");
		}
		
		try {
			System.out.println(sql);
			Connection conn = ConnectToDB.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
}


	


