import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//
public class ZurueckgebenFensterDAO {
	KundenSpiele kundenSpiele = new KundenSpiele();
	Connection conn = null;
	private Statement statement = null;

	public void deleteKundeSpiel(String kunde) throws ClassNotFoundException {
		ResultSet resultSet = null;
		try {
			String sql = "Delete * from Kunde-Spiele Where SpieleID  = " + kundenSpiele.getSpieleID()
					+ "AND where KundenID = " + kundenSpiele.getKundenID();

			Statement statement = this.conn.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			System.out.println(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet searchForKundenspiele(String kunde) throws ClassNotFoundException {
		ResultSet rs = null;
		conn = ConnectToDB.getConnection();
		String sql = "SELECT KUNDENSPIELE.* FROM KUNDENSPIELE INNER JOIN KUNDEN ON KUNDENSPIELE.KUNDENID"
				+ " = KUNDEN.ID WHERE KUNDEN.NACHNAME = '" + kunde.toLowerCase() + "'";
		System.out.println(sql);
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println("SQL-SELECT funzt");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
}
