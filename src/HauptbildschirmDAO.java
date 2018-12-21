import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HauptbildschirmDAO {
	
	private ConnectToDB connect;
	private String alphabetischFilterWert;

	public HauptbildschirmDAO(String alphabetischFilterWert) {
		this.alphabetischFilterWert = alphabetischFilterWert;
	}
	
	public void orderBy(String alphabetischFilterWert) {		
		String sortierung = null;
		if (alphabetischFilterWert.equalsIgnoreCase("absteigend")) {
			sortierung = "DESC";
		}
		else if (alphabetischFilterWert.equalsIgnoreCase("aufsteigend")) {
			sortierung = "ASC";
		}
		try {
			String sql = "SELECT TITEL FROM spieledaten ORDER BY TITEL " + sortierung;
			Connection conn = connect.connectToDB();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


	


