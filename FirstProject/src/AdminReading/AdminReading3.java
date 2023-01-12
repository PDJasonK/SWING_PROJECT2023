package AdminReading;

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

import AdminOptions.AdminOptionPage;
import OngoingProject.HomeScreen;
import OngoingProject.InstructionTwo;
import OngoingProject.ToeicOptions;
import ToeicContents.ReadingMain3DAO;



public class AdminReading3 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel PContent1;
	private JLabel title;
	private Statement stmt;
	private Connection conn;

	AdminReading3DAO dao = new AdminReading3DAO();

	private JButton Submit,btn1,btn2 , btn3 , btn0;

	public static JTextArea gain1 = new JTextArea();
	public static JTextArea gain2 = new JTextArea();
	public static JTextArea gain3 = new JTextArea();
	public static JTextArea giving1 = new JTextArea();
	public static JTextArea giving2 = new JTextArea();
	public static JTextArea giving3 = new JTextArea();

	public AdminReading3() {
		
		f = new JFrame("Add Article by Admin 3rd");
		f.setLayout(null);
		p = new JPanel();
		p.setLayout(null);

		// -----

		title = new JLabel("[Third Parapgraphs]이전에 입력했던 내용확인");
		title.setBounds(30, 0, 800, 90);

		gain1.setLayout(null);
		gain1.setBounds(30, 50, 800, 350);
	
		/*
		gain2.setLayout(null);
		gain2.setBounds(30, 140, 800, 90);
		gain3.setLayout(null);
		gain3.setBounds(30, 230, 800, 90);
*/
		PContent1 = new JLabel("[Write First] 첫번째 문단 작성", JLabel.LEFT);
		PContent1.setBounds(30, 240, 500, 500);
		/*PContent2 = new JLabel("[Write Second] 두 번째 문단 작성 ", JLabel.LEFT);
		PContent2.setBounds(30, 380, 500, 500);
		PContent3 = new JLabel("[Write Third] 세번째 문단 작성", JLabel.LEFT);
		PContent3.setBounds(30, 520, 500, 500);
*/
		giving1 = new JTextArea();
		giving1.setBounds(30, 500, 800, 370);

		//giving2 = new JTextArea();
		//giving2.setBounds(30, 640, 8000, 90);

		//giving3 = new JTextArea();
		//giving3.setBounds(30, 780, 8000, 90);

		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);
		
		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);
		
		btn1 = new JButton("NEXT");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);
		
		btn3 = new JButton("뒤로 ");
		btn3.setLayout(null);
		btn3.setBounds(850, 750, 100, 60);
		
		btn0 = new JButton("관리자 페이지로 돌아가기");
		btn0.setLayout(null);
		btn0.setBounds(600, 890, 200, 60);
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new AdminSubmit ();
			f.setVisible(false);
			}
			
		});
		
		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminOptionPage AP = new AdminOptionPage();
				AP.startFrame();
				f.setVisible(false);
			}
			
		});
		
		startframe();
		method();
		

//		Submit.setBackground(Color.gray);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(giving1.getSelectedText() + giving2.getSelectedText() + giving3.getSelectedText());
				if (giving1.getText() != null && giving2.getText() != null && giving3.getText() != null) {
					String give1 = giving1.getText();
					String give2 = giving2.getText();
					String give3 = giving3.getText();
					dao.list(give1, give2, give3);
				}
			}

		});
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminReading3();
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
		
//		 f.getContentPane().add(btn1);
//	     f.getContentPane().add(btn2);
	        
		f.setSize(1000, 1200);
		
		f.add(title);
	

		f.add(PContent1);
	//	f.add(PContent2);
		//f.add(PContent3);
		f.add(btn3);
		f.add(Submit);
		f.add(btn1);
		f.add(btn2);
		f.add(btn0);

		f.add(giving1);
		//f.add(giving2);
		//f.add(giving3);
		f.add(gain1);
		//f.add(gain2);
	//	f.add(gain3);
		

		// f.add(title, "North");

		f.add(p, "Center");

		f.addWindowListener(this);
		Submit.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		
		// p.add(Practice);

		f.setVisible(true);
		p.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		AdminReading3 AM = new AdminReading3();
		AM.startframe();
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

			String sql2 = "SELECT gainC1, gainC2, gainC3 FROM ReadingMainGain3";
//String sql2 = "SELECT contentsAr, contentsBr, contentsCr FROM ReadingMainGain3";
			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("gainC1") + "\t");
				System.out.print(rs2.getString("gainC2") + "\t");
				System.out.print(rs2.getString("gainC3"));

/*				yoyo1.setText(rs2.getString("contentsAr"));
				yoyo2.setText(rs2.getString("contentsBr"));
				yoyo3.setText(rs2.getString("contentsCr"));
*/
				gain1.setText(rs2.getString("gainC1"));
				//gain2.setText(rs2.getString("adminRead2"));
				//gain3.setText(rs2.getString("adminRead3"));
				
				
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
