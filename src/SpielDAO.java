
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;


public class SpielDAO {
	
	private PreparedStatement statement = null;
	private Statement statement2 = null;
	Spiel spiel = new Spiel();
	
	private String alphabetischFilterWert;
	private String sortierung;
	private String spalten = "Spiele.id, Spiele.titel, Spiele.genre, Spiele.usk, Spiele.veroeffentlichkeitsdatum, Spiele.preis AS 'Preis (Euro)' , Spiele.verfuegbarkeit";
	

	
	public Spiel selectSpiel(String ausgewaehltesSpiel) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		Connection conn = ConnectToDB.getConnection();
		try {
			String sql = "SELECT * FROM Spiele WHERE ID = '" + ausgewaehltesSpiel + "'";
			// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
			// herzustellen
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			rs.next();
			spiel.setId((rs.getString("id")));
			spiel.setTitel(rs.getString("titel"));
			spiel.setGenre(rs.getString("genre"));
			spiel.setVeroeffentlichkeitsdatum(rs.getString("veroeffentlichkeitsdatum"));
			spiel.setUsk(rs.getString("usk"));
			spiel.setPreis(rs.getDouble("preis"));
			spiel.setLageranzahl(rs.getInt("lageranzahl"));
			spiel.setVerfuegbarkeit(rs.getString("verfuegbarkeit"));
			spiel.setSprache(rs.getString("sprache"));
			spiel.setBeschreibung(rs.getString("beschreibung"));
			spiel.setAusleihCounter(rs.getInt("AusleihCounter"));
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
			System.out.println(spiel.getTitel());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			return spiel;
		}
	
	
	public ResultSet sucheNachSpiel(String eingabe) throws ClassNotFoundException {
		ResultSet rs = null;
		String sql = "SELECT " + spalten + " FROM Spiele WHERE titel LIKE '%" + eingabe + "%'";
		if (eingabe.equalsIgnoreCase("")) {
			sql = "SELECT " + spalten + " FROM Spiele";
		}
		try {
			// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
			// herzustellen
			Connection conn = ConnectToDB.getConnection();
			statement2 = conn.createStatement();
			rs = statement2.executeQuery(sql);
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
		

		public void insert(Spiel spiele) throws ClassNotFoundException {
			Connection conn = ConnectToDB.getConnection();
			PreparedStatement preparedStatement = null;
			try {
				// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
				// herzustellen	
				String sql = "INSERT INTO Spiele (id, titel, genre, veroeffentlichkeitsdatum, usk, preis, lageranzahl, verfuegbarkeit, sprache, beschreibung) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(2, spiele.getTitel());
				preparedStatement.setString(1, spiele.getId());
				preparedStatement.setDouble(6, spiele.getPreis());
				preparedStatement.setString(4, spiele.getVeroeffentlichkeitsdatum());
				preparedStatement.setString(3, spiele.getGenre());
				preparedStatement.setString(5, spiele.getUsk());
				preparedStatement.setInt(7, spiele.getLageranzahl());
				preparedStatement.setString(8, spiele.getVerfuegbarkeit());
				preparedStatement.setString(9, spiele.getSprache());
				preparedStatement.setString(10, spiele.getBeschreibung());
				preparedStatement.executeUpdate();
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				resultSet.next();
				System.out.println("SQL-SELECT funzt");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
		}}
		


		
		
		public void delete(String id) throws ClassNotFoundException  {
			PreparedStatement preparedStatement = null;
			Connection conn = ConnectToDB.getConnection();
			try {
				
				String sql = "DELETE FROM Spiele WHERE ID = " + id ;
				PreparedStatement updateValues = conn.prepareStatement(sql);
				PreparedStatement st = conn.prepareStatement(sql);	
				st.executeUpdate(); 
			}catch(SQLException e) {
				System.out.println();
			}
			finally {
				try {
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void update(Spiel spiel) throws ClassNotFoundException  {
			PreparedStatement preparedStatement = null;
			Connection conn = ConnectToDB.getConnection();
			try {
				// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
				// herzustellen
				String sql = "UPDATE Spiele SET ID, = ?, Titel = ?, Genre = ?, Veroeffentlichkeitsdatum = ?, USK = ?,"
						+ "Preis = ?, Lageranzahl = ?, Verfuegbarkeit = ?, Sprache = ?, Beschreibung = ? WHERE id LIKE ?" ;
				PreparedStatement updateValues = conn.prepareStatement(sql);
				updateValues.setString(1, spiel.getId());
				updateValues.setString(2, spiel.getTitel());
				updateValues.setDouble(6, spiel.getPreis());
				updateValues.setString(4, spiel.getVeroeffentlichkeitsdatum());
				updateValues.setString(5, spiel.getUsk());
				updateValues.setString(3, spiel.getGenre());
				updateValues.setInt(7, spiel.getLageranzahl());
				updateValues.setString(8, spiel.getVerfuegbarkeit());
				updateValues.setString(9, spiel.getSprache());
				updateValues.setString(11, spiel.getId());
				updateValues.setString(10, spiel.getBeschreibung());
				updateValues.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}

