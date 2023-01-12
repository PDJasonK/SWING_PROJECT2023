package ToeicContents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import OngoingProject.HomeScreen;
import ResultToeic.ReadingResult;


public class ReadingMain3 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel title1 , title2, title3 , title4;
	private Statement stmt;
	private Connection conn;
	private JButton Submit,btn1,btn2, btn0;


	ReadingMain3DAO dao = new ReadingMain3DAO();

	public static JTextArea Gainer1 = new JTextArea();
	public static JTextArea Gainer2 = new JTextArea();
	public static JTextArea Gainer3 = new JTextArea();
	
	
	public static JTextArea Sender1 = new JTextArea();
	public static JTextArea Sender2 = new JTextArea();
	public static JTextArea Sender3 = new JTextArea();

	public ReadingMain3() {
		
		f = new JFrame("[토익 세뻔째 지문] -sss First Reading");
		f.setBackground(Color.GRAY);
		p = new JPanel();	
		p.setLayout(null);

		// -----
		

		title1 = new JLabel("3rd 본문");
		title1.setBounds(30, 1, 800, 90);
		
		Gainer1.setLayout(null);
		Gainer1.setBounds(30, 55, 800, 400);
		Gainer1.setEditable(false);

	/*	yoyo2.setLayout(null);
		yoyo2.setBounds(30, 140, 800, 90);
		yoyo3.setLayout(null);
		yoyo3.setBounds(30, 230, 800, 90);
*/
		title2 = new JLabel("첫번째 문단의 해석문", JLabel.LEFT);
		title2.setBounds(30, 240, 500, 500);
	/*
		title3 = new JLabel("두번째 문단의 해석문", JLabel.LEFT);
		title3.setBounds(30, 380, 500, 500);
		title4 = new JLabel("세번째 첫번째 문단의 해석문 ", JLabel.LEFT);
		title4.setBounds(30, 520, 500, 500);
*/
		Sender1 = new JTextArea();
		Sender1.setBounds(30, 500, 800, 300);
		Sender1.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
		            Sender1.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		            Sender1.setBackground(Color.YELLOW);
		         }
		      });
	/*	
		Sender2 = new JTextArea();
		Sender2.setBounds(30, 640, 800, 90);
		Sender2.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
		            Sender2.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		            Sender2.setBackground(Color.YELLOW);
		         }
		      });
		
		Sender3 = new JTextArea();
		Sender3.setBounds(30, 780, 800, 90);
		Sender3.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
		            Sender3.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		            Sender3.setBackground(Color.YELLOW);
		         }
		      });
		*/
		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);
		
		
		btn1 = new JButton("Result");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);
		
		
		
		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);
		
		btn0 = new JButton("뒤로 돌아가기");
		btn0.setLayout(null);
		btn0.setBounds(600, 890, 200, 60);
		
		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ReadingMain2();
				p.setVisible(false);
				f.setVisible(false);
				
			}
			
		});
		
		startframe();
		method();
		

//		Submit.setBackground(Color.gray);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Gainer1.getSelectedText() + Gainer2.getSelectedText() + Gainer3.getSelectedText());
				
				
				if (Sender1.getText() != null && Sender2.getText() != null && Sender3.getText() != null) {
					String sending1 = Sender1.getText();
					String sending2= Sender2.getText();
					String sending3 = Sender3.getText();
					dao.list(sending1, sending2, sending3);
				}
			}

		});

	

	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new ReadingResult();
			p.setVisible(false);
			f.setVisible(false);

		}
	});

	
	
	btn2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			HomeScreen hs = new HomeScreen();
			f.setVisible(false);
			hs.startFrame();
			
		}

	});

}
	/*
	 * @Override public void actionPerformed(ActionEvent e) { HomeScreen hs = new
	 * HomeScreen(); signup.setVisible(false);
	 * 
	 * hs.startFrame(); }
	 * 
	 * });
	 * 
	 * }
	 */
	public void startframe() {
		f.setSize(1000, 1200);
		p.add(title1);
		p.add(title2);
	/*
		p.add(title3);
		p.add(title4);
		*/
		p.add(Submit);

		p.add(Gainer1);
	//	p.add(yoyo2);
		//p.add(yoyo3);
		p.add(Sender1);
		/*
		p.add(Sender2);
		p.add(Sender3);
*/		p.add(btn1);
		p.add(btn2);
		p.add(btn0);
		

		// f.add(title, "North");

		f.add(p, "Center");

		f.addWindowListener(this);
		Submit.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		// p.add(Practice);

		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		ReadingMain3 RM3 = new ReadingMain3();
		RM3.startframe();
	}

	
	public void method() {
		String list = "";
		String driver1 = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "c##green";
		String pwd = "green1234";

		try {
			Class.forName(driver1);
			System.out.println("jdbc driver loading success.");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("oracle connection succexx.\n");
			stmt = conn.createStatement();

			String sql2 = "SELECT GainC1, GainC2, gainC3 FROM ReadingMainGain3";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("gainC1") + "\t");
				System.out.print(rs2.getString("gainC2") + "\t");
				System.out.print(rs2.getString("gainC3"));

				Gainer1.setText(rs2.getString("gainC1"));
			//	yoyo2.setText(rs2.getString("contentsBr"));
				//yoyo3.setText(rs2.getString("contentsCr"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}