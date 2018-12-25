import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HauptbildschirmDAO {
	
	ConnectToDB connect = new ConnectToDB();
	
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
			String sql = "SELECT titel, genre, veröffentlichkeitsdatum, verfügbarkeit FROM Spiele ORDER BY TITEL " + sortierung;
			Connection conn = connect.connectToSpiel();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}


	


