
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpielDAO {
	
	private PreparedStatement statement = null;
	Spiel spiel = new Spiel();
	
	private int id;
	
	
	public Spiel selectSpiel(String ausgewaehltesSpiel) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		Connection conn = ConnectToDB.getConnection();
		try {
			String sql = "SELECT * FROM Spiele WHERE id = '" + ausgewaehltesSpiel + "'";
			// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
			// herzustellen
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			rs.next();
			spiel.setId(rs.getInt("id"));
			spiel.setTitel(rs.getString("titel"));
			spiel.setGenre(rs.getString("genre"));
			spiel.setVeroeffentlichkeitsdatum(rs.getString("veroeffentlichkeitsdatum"));
			spiel.setUsk(rs.getString("usk"));
			spiel.setPreis(rs.getDouble("preis"));
			spiel.setLageranzahl(rs.getInt("lageranzahl"));
			spiel.setVerfuegbarkeit(rs.getString("verfuegbarkeit"));
			spiel.setSprache(rs.getString("sprache"));
			// Gibt Nachricht aus bei funktionierendem SELECT
			System.out.println("SQL-SELECT funzt");
			System.out.println(spiel.getTitel());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			return spiel;
		}
		
		
		public int insert(Spiel spiele) throws ClassNotFoundException {
			Connection conn = ConnectToDB.getConnection();
			PreparedStatement preparedStatement = null;
			try {
				// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
				// herzustellen	
				String sql = "INSERT INTO Spiele (Titel, ******* ) VALUES ( vorname = ?, nachname = ?, email = ? )" ;
				PreparedStatement updateValues = conn.prepareStatement(sql);
				updateValues.setString(1, spiele.getTitel());
				updateValues.setDouble(2, spiele.getPreis());
				updateValues.setString(3, spiele.getVeroeffentlichkeitsdatum());
				updateValues.setString(4, spiele.getGenre());
				updateValues.setString(5, spiele.getUsk());
				updateValues.setInt(6, spiele.getLageranzahl());
				updateValues.setString(7, spiele.getVerfuegbarkeit());
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
		
		public  Spiel delete (String titel) throws ClassNotFoundException  {
			PreparedStatement preparedStatement = null;
			Connection conn = ConnectToDB.getConnection();
			try {
				// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
				// herzustellen
				String sql = "DELETE FROM Spiele WHERE Titel  = ?" ;
				PreparedStatement updateValues = conn.prepareStatement(sql);
				PreparedStatement st = conn.prepareStatement(sql);	
				Spiel spiele = null;
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
		
		public void update(Spiel spiel) throws ClassNotFoundException  {
			PreparedStatement preparedStatement = null;
			Connection conn = ConnectToDB.getConnection();
			try {
				// connect()-Methode wird ausgef�hrt um eine Verbindung zur Datenbank
				// herzustellen
				String sql = "UPDATE ********************  SET vorname = ?, SET nachname = ?, SET email = ?  WHERE id LIKE ?" ;
				PreparedStatement updateValues = conn.prepareStatement(sql);
				updateValues.setString(1, spiel.getTitel());
				updateValues.setDouble(2, spiel.getPreis());
				updateValues.setString(3, spiel.getVeroeffentlichkeitsdatum());
				updateValues.setString(4, spiel.getGenre());
				updateValues.setString(5, spiel.getUsk());
				updateValues.setInt(6, spiel.getLageranzahl());
				updateValues.setString(7, spiel.getVerfuegbarkeit());
				updateValues.setString(9, spiel.getSprache());
				updateValues.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}
		
	/*	public Spiel select (String titel) throws Exception {
			Spiel spiele = null;
			Connection conn = connect.connectToDB();
			PreparedStatement preparedStatement = null;
			try {
				String sql = "select * from email where id = ? ";
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, titel);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				spiele = new Spiel(titel, sql, sql, sql, sql, sql, sql, sql, sql);
				spiele.setTitel(resultSet.getString("titel"));
				spiele.setPreis(resultSet.getDouble("preisProTag"));
				spiele.setVeroeffentlichkeitsdatum(resultSet.getString("veroeffentlichkeitsdatum"));
				spiele.setGenre(resultSet.getString("genre"));
				spiele.setUsk(resultSet.getString("uskFreigabe"));
				spiele.setLageranzahl(resultSet.getInt("lageranzahl"));
				spiele.setVerfuegbarkeit(resultSet.getString("verfuegbarkeit"));
				spiele.setSprache(resultSet.getString("sprache"));
			}catch(SQLException e) {
				System.out.println("Hier l�uft was falsch");
			}

			return spiele;
		}
		
		return spiel;
	}*/
