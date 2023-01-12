package ToeicContents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ReadingMain3DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<ReadingMain3Vo> list(String SendC1, String SendC2, String SendC3) {
		ArrayList<ReadingMain3Vo> list = new ArrayList<ReadingMain3Vo>();
		try {

			System.out.println(SendC1 + " " + SendC2 + " " + SendC3);
			connDB();
			String query;
			String cta = SendC1;
			String ctb = SendC2;
			String ctc = SendC3;

				query = "insert into ReadingMainSend3( sendC1,   sendC2, SendC3)" + " VALUES('" + cta + "', '" + ctb
					+ "', '" + ctc + "')";

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection success.");

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");

			String sql2 = "SELECT sendC1, sendC2, sendC3 FROM ReadingMainSend3";

			ResultSet rs = stmt.executeQuery(sql2);
//--------------------------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------------
	}
}