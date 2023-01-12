package AdminReading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AdminSubmit extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel PContent1;
		private JLabel title;
	private Statement stmt;
	private Connection conn;

	AdmintSubmitDAO dao = new AdmintSubmitDAO();

	private JButton Submit,btn1,btn2 , btn0;

	public static JTextArea yoyo1 = new JTextArea();
	public static JTextArea yoyo2 = new JTextArea();
	public static JTextArea yoyo3 = new JTextArea();
	public static JTextArea yoyo4 = new JTextArea();
	public static JTextArea yoyo5 = new JTextArea();
	public static JTextArea yoyo6 = new JTextArea();

	public AdminSubmit() {
		
		f = new JFrame("Add Article by Admin");
		f.setLayout(null);
		p = new JPanel();
		p.setLayout(null);

		// -----

		title = new JLabel("이전에 입력했던 내용확인");
		title.setBounds(30, 0, 800, 90);

		yoyo1.setLayout(null);
		yoyo1.setBounds(30, 50, 800, 350);
		yoyo2.setLayout(null);
		yoyo2.setBounds(30, 140, 800, 90);
		yoyo3.setLayout(null);
		yoyo3.setBounds(30, 230, 800, 90);

		PContent1 = new JLabel("[Write First] 첫번째 문단 작성", JLabel.LEFT);
		PContent1.setBounds(30, 240, 500, 500);
		/*PContent2 = new JLabel("[Write Second] 두 번째 문단 작성 ", JLabel.LEFT);
		PContent2.setBounds(30, 380, 500, 500);
		PContent3 = new JLabel("[Write Third] 세번째 문단 작성", JLabel.LEFT);
		PContent3.setBounds(30, 520, 500, 500);
*/
		yoyo4 = new JTextArea();
		yoyo4.setBounds(30, 500, 800, 370);

		//yoyo5 = new JTextArea();
		//yoyo5.setBounds(30, 640, 8000, 90);

		//yoyo6 = new JTextArea();
		//yoyo6.setBounds(30, 780, 8000, 90);

		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);
		
		btn2 = new JButton("HOME");
		btn2.setLayout(null);
		btn2.setBounds(20, 890, 100, 60);
		
		btn1 = new JButton("NEXT");
		btn1.setLayout(null);
		btn1.setBounds(850, 890, 100, 60);
		
		btn0 = new JButton("관리자 페이지로 돌아가기");
		btn0.setLayout(null);
		btn0.setBounds(600, 890, 200, 60);
		
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
				System.out.println(yoyo4.getSelectedText() + yoyo5.getSelectedText() + yoyo6.getSelectedText());
				if (yoyo4.getText() != null && yoyo5.getText() != null && yoyo6.getText() != null) {
					String syoyo4 = yoyo4.getText();
					String syoyo5 = yoyo5.getText();
					String syoyo6 = yoyo6.getText();
					dao.list(syoyo4, syoyo5, syoyo6);
				}
			}

		});
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminReading2();
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
		f.add(Submit);
		f.add(btn1);
		f.add(btn2);
		f.add(btn0);

		f.add(yoyo1);
		//f.add(yoyo2);
		//f.add(yoyo3);
		f.add(yoyo4);
		//f.add(yoyo5);
	//	f.add(yoyo6);
		

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
		AdminSubmit sm = new AdminSubmit();
		sm.startframe();
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

			String sql2 = "SELECT contentsAr, contentsBr, contentsCr FROM instruction1Read";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("contentsAr") + "\t");
				System.out.print(rs2.getString("contentsBr") + "\t");
				System.out.print(rs2.getString("contentsCr"));

				yoyo1.setText(rs2.getString("contentsAr"));
				yoyo2.setText(rs2.getString("contentsBr"));
				yoyo3.setText(rs2.getString("contentsCr"));

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
