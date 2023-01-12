package VocabDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VocabToeic1DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "c##green";
	String pwd = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<VocabToeic1Vo> list(String Output1, String Output2, String Output3, String Output4, String Output5,
			String Output6, String Output7, String Output8) {
		ArrayList<VocabToeic1Vo> list = new ArrayList<VocabToeic1Vo>();
		try {

			System.out.println(Output1 + " " + Output2 + " " + Output3 + " " + Output4 + " " + Output5 + " " + Output6
					+ " " + Output7 + " " + Output8);
			connDB();
			String query;
			String cta1 = Output1;
			String cta2 = Output2;
			String cta3 = Output3;
			String cta4 = Output4;
			String cta5 = Output5;
			String cta6 = Output6;
			String cta7 = Output7;
			String cta8 = Output8;

//				query = "select * from instruction1  where contentsA = '" + contentsA + "'"+
//				" and contentsB = '" + contentsB.toLowerCase() + "'"+
//				" and contentsC = '" + contents3.toLowerCase() + "'";
			query = "insert into VocabOut(Output1, Output2,Output3,Output4,Output5,Output6,Output7,Output8) "
					+ "VALUES('" + cta1 + "', '" + cta2
					+ "', '" + cta3 + "', '" + cta4 + "', '" + cta5 + "', '" + cta6 + "', '" + cta7 + "', '" + cta8
					+ "')";

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);

//			if (rs.getRow() == 0) {
//				System.out.println("0 row selected....");
//				
//				System.out.println(query);
//
//				System.out.println("Join complete");
//
//			} else {
//				System.out.println(rs.getRow() + "rows selected...");
//				System.out.println("can not join");
//			}

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

			String sql2 = "SELECT Output1, Output2, Output3 ,Output4,Output5,Output6,Output7,Output8 FROM VocabOut";

			ResultSet rs = stmt.executeQuery(sql2);
//--------------------------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------------
	}
}