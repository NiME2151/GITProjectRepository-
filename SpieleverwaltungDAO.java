import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpieleverwaltungDAO {
	
	

	
	public int insert(SpielverwaltungSetAndGet spielverwaltungSetAndGet) {
		//conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORT);
			String sql = "INSERT INTO email (vorname, nachname, email) VALUES ( vorname = ?, nachname = ?, email = ? )" ;
			PreparedStatement updateValues = conn.prepareStatement(sql);
			updateValues.setString(1, emailKontakt.getVorname());
			updateValues.setString(2, emailKontakt.getNachname());
			updateValues.setString(3, emailKontakt.getEmail());
			updateValues.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			id = resultSet.getInt(1);
		}catch(SQLException e) {
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
		return id;
	}
	
	}

}
