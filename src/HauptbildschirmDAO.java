import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HauptbildschirmDAO {
	
	private ConnectToDB connect;
	private String alphabetischFilterWert;
	private Spiel spiel;
	private String sortierung;
	private ArrayList<Spiel> spieleliste;

	public HauptbildschirmDAO(String alphabetischFilterWert) {
		this.alphabetischFilterWert = alphabetischFilterWert;
	}
	
	public ResultSet orderBy(String alphabetischFilterWert) {		
		if (alphabetischFilterWert.equalsIgnoreCase("absteigend")) {
			sortierung = "DESC";
		}
		else if (alphabetischFilterWert.equalsIgnoreCase("aufsteigend")) {
			sortierung = "ASC";
		}
		try {
			String sql = "SELECT * FROM Spiele ORDER BY TITEL " + sortierung;
			Connection conn = connect.connectToDB();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			/**
			 * 	for (int i = 0; i < rs.length; i++) {
				spiel = new Spiel();
				spiel.setTitel(rs.getString("titel"));
				spiel.setGenre(rs.getString("genre"));
				spiel.setTitel(rs.getString("veröffentlichkeitsdatum"));
				spiel.setTitel(rs.getString("verfügbarkeit"));
				spieleliste.add(spiel);
			}
			 */


			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}


	


