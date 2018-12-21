import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpieleverwaltungDAO {
	
	private int id;
	private Connection conn;

	
	public int insert(Spiele spiele) throws ClassNotFoundException {
		PreparedStatement preparedStatement = null;
		try {
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			conn = DBVerbindungHerstellen.connect();	
			String sql = "INSERT INTO Spiele (Titel, ******* ) VALUES ( vorname = ?, nachname = ?, email = ? )" ;
			PreparedStatement updateValues = conn.prepareStatement(sql);
			updateValues.setString(1, spiele.getTitel());
			updateValues.setDouble(2, spiele.getPreisProTag());
			updateValues.setString(3, spiele.getVeroeffentlichkeitsdatum());
			updateValues.setString(4, spiele.getGenre());
			updateValues.setInt(5, spiele.getUskFreigabe());
			updateValues.setInt(6, spiele.getLageranzahl());
			updateValues.setInt(7, spiele.getVerfuegbarkeit());
			updateValues.setDouble(8, spiele.getSpielzeit());
			updateValues.setString(9, spiele.getSprache());
			updateValues.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			id = resultSet.getInt(1);
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	
	public  Spiele delete (String titel) throws ClassNotFoundException  {
		PreparedStatement preparedStatement = null;
		try {
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			conn = DBVerbindungHerstellen.connect();
			String sql = "DELETE FROM Spiele WHERE Titel  = ?" ;
			PreparedStatement updateValues = conn.prepareStatement(sql);
			PreparedStatement st = conn.prepareStatement(sql);	
			Spiele spiele = null;
			st.setString(1, spiele.getTitel());
			st.executeUpdate(); 
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
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
		return null;
	}
	
	public void update(Spiele spiele) throws ClassNotFoundException  {
		PreparedStatement preparedStatement = null;
	
		try {
			// connect()-Methode wird ausgeführt um eine Verbindung zur Datenbank
			// herzustellen
			conn = DBVerbindungHerstellen.connect();
			String sql = "UPDATE ********************  SET vorname = ?, SET nachname = ?, SET email = ?  WHERE id LIKE ?" ;
			PreparedStatement updateValues = conn.prepareStatement(sql);
			updateValues.setString(1, spiele.getTitel());
			updateValues.setDouble(2, spiele.getPreisProTag());
			updateValues.setString(3, spiele.getVeroeffentlichkeitsdatum());
			updateValues.setString(4, spiele.getGenre());
			updateValues.setInt(5, spiele.getUskFreigabe());
			updateValues.setInt(6, spiele.getLageranzahl());
			updateValues.setInt(7, spiele.getVerfuegbarkeit());
			updateValues.setDouble(8, spiele.getSpielzeit());
			updateValues.setString(9, spiele.getSprache());
			updateValues.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	public Spiele select (String titel) throws Exception {
		Spiele spiele = null;
				PreparedStatement preparedStatement = null;
		try {
			conn = DBVerbindungHerstellen.connect();
			String sql = "select * from email where id = ? ";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, titel);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			spiele = new Spiele(titel, sql, sql, sql, sql, sql, sql, sql, sql);
			spiele.setTitel(resultSet.getString("titel"));
			spiele.setPreisProTag(resultSet.getDouble("preisProTag"));
			spiele.setVeroeffentlichkeitsdatum(resultSet.getString("veroeffentlichkeitsdatum"));
			spiele.setGenre(resultSet.getString("genre"));
			spiele.setUskFreigabe(resultSet.getInt("uskFreigabe"));
			spiele.setLageranzahl(resultSet.getInt("lageranzahl"));
			spiele.setVerfuegbarkeit(resultSet.getInt("verfuegbarkeit"));
			spiele.setSpielzeit(resultSet.getDouble("spielzeit"));
			spiele.setSprache(resultSet.getString("sprache"));
		}catch(SQLException e) {
			System.out.println("Hier läuft was falsch");
		}

		return spiele;

	}
	
	

}
