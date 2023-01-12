package OngoingProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class OracleInsert {
	static JFrame frame = new JFrame("테스트");
	static JTextArea yoyo1 = new JTextArea(" ");
	static JTextArea yoyo2 = new JTextArea(" ");
	static JTextArea yoyo3 = new JTextArea(" ");
	
	
 	JTextArea hk = new JTextArea();

	public static void startframe() {
		frame.setLayout(null);
		frame.setSize(900, 1200);
		yoyo1.setLayout(null);
		yoyo2.setLayout(null);
		yoyo3.setLayout(null);

		yoyo1.setBounds(30, 50, 500, 90);
		yoyo2.setBounds(30, 140, 500, 90);
		yoyo3.setBounds(30, 230, 500, 90);
		
		frame.add(yoyo1);
		frame.add(yoyo2);
		frame.add(yoyo3);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
	   OracleInsert oi = new OracleInsert();
	   oi.startframe();
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "c##green";
		String pwd = "green1234";
      try {
         Class.forName(driver);
         System.out.println("jdbc driver loading success.");
         Connection conn = DriverManager.getConnection(url, user, pwd);
         System.out.println("oracle connection succexx.\n");
         Statement stmt = conn.createStatement();

        
         String sql2 = "SELECT contentsA, contentsB, contentsC FROM instruction1";

         ResultSet rs = stmt.executeQuery(sql2);
         while (rs.next()) {
        	 
            System.out.print(rs.getString("contentsA") + "\t");
            System.out.print(rs.getString("contentsB") + "\t");
            System.out.print(rs.getString("contentsC") );
            
            yoyo1.setText(rs.getString("contentsA"));
            yoyo2.setText(rs.getString("contentsB"));
            yoyo3.setText(rs.getString("contentsC"));
            
//            yoyo.setText(rs.getString("contentsB"));
  //          yoyo.setText(rs.getString("contentsC"));

     
         }
      } catch (ClassNotFoundException e) {
         System.out.println(e);
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println(e);
         e.printStackTrace();
      }

   }

}