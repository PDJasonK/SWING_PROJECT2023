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
import OngoingProject.InstructionTwo;
import OngoingProject.ToeicOptions;

/*
 * DAO 를 하나만들고 현재 본창에도 DAO의기능을하는 구현들을 넣어놓은 이유는
 * 아직 실력이 조금 미숙하다고 판단하여
 * 작성자인 본인이 DB 사용법을 즉각적으로 확인 하기위해서이다. 
 * */

public class ReadingMain2 extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel title1;
	private JLabel title2;
	private JLabel title3;
	private JLabel title4;
	private JButton Submit,btn1,btn2, btn0;


	ReadingMain2DAO dao = new ReadingMain2DAO();
/*
	private JTextArea gainer1 = new JTextArea();
//	private JTextArea gainer2 = new JTextArea();
//	private JTextArea gainer3 = new JTextArea();

	
	private JTextArea sending1 = new JTextArea();
	private JTextArea sending2 = new JTextArea();
	private JTextArea sending3 = new JTextArea();
*/
	
	public static JTextArea gainer1 = new JTextArea();
	public static JTextArea gainer2 = new JTextArea();
	public static JTextArea gainer3 = new JTextArea();
	
	
	public static JTextArea sending1 = new JTextArea();
	public static JTextArea sending2 = new JTextArea();
	public static JTextArea sending3 = new JTextArea();
	

	private Statement stmt;
	private Connection conn;

	
	public ReadingMain2() {
		
		f = new JFrame("[토익 두뻔째 지문] - First Reading");
		f.setBackground(Color.GRAY);
		p = new JPanel();
		p.setLayout(null);

		// -----
		

		title1 = new JLabel("리딩 파트 ");
		title1.setBounds(30, 1, 800, 90);

		title2 = new JLabel("첫번째 문단의 해석문", JLabel.LEFT);
		title2.setBounds(30, 240, 500, 500);
	/*	title3 = new JLabel("두번째 문단의 해석문", JLabel.LEFT);
		title3.setBounds(30, 380, 500, 500);
		title4 = new JLabel("세번째 첫번째 문단의 해석문 ", JLabel.LEFT);
		title4.setBounds(30, 520, 500, 500);
*/
		
		
		
		
		gainer1.setLayout(null);
		gainer1.setBounds(30, 55, 800, 400);
		
		gainer1.setEditable(false);

	/*	gainer2.setLayout(null);
		gainer2.setBounds(30, 140, 800, 90);
		gainer3.setLayout(null);
		gainer3.setBounds(30, 230, 800, 90);
*/
		sending1 = new JTextArea();
		sending1.setBounds(30, 500, 800, 300);
		sending1.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 sending1.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 sending1.setBackground(Color.YELLOW);
		         }
		      });
	/*	
		sending2 = new JTextArea();
		sending2.setBounds(30, 640, 800, 90);
		sending2.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 sending2.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 sending2.setBackground(Color.YELLOW);
		         }
		      });
		
		sending3= new JTextArea();
		sending3.setBounds(30, 780, 800, 90);
		sending3.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 sending3.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 sending3.setBackground(Color.YELLOW);
		         }
		      });
		*/
		Submit = new JButton("SUBMIT");
		Submit.setLayout(null);
		Submit.setBounds(400, 890, 100, 60);
		
		
		btn1 = new JButton("NEXT");
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
				new SubmitMain();
				p.setVisible(false);
				f.setVisible(false);
				
			}
			
		});
		
		startframe();
		method();
		

//		Submit.setBackground(Color.gray);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(sending1.getSelectedText() + sending2.getSelectedText() + sending3.getSelectedText());
				if (sending1.getText() != null && sending2.getText() != null && sending3.getText() != null) {
					String variable1 = sending1.getText();
					String variable2 = sending2.getText();
					String variable3 = sending3.getText();
					
					dao.list(variable1, variable2, variable3);

			/*		String syoyo4 = yoyo4.getText();
					String syoyo5 = yoyo5.getText();
					String syoyo6 = yoyo6.getText();
					dao.list(syoyo4, syoyo5, syoyo6);*/
				}
			}

		});

	

	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new ReadingMain3();
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
		f.add(title1);
		f.add(title2);

		/*
f.add(title3);

		f.add(title4);
			*/
		f.add(Submit);

		f.add(gainer1);
	//	p.add(gainer2);
		//p.add(gainer);
		f.add(sending1);
	/*
		f.add(sending2);
		f.add(sending3);
		*/
		p.add(btn1);
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
		ReadingMain2 RM2= new ReadingMain2();
		RM2.startframe();
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

			String sql2 = "SELECT gain1, gain2, gain3 FROM ReadingMainGain";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("gain1") + "\t");
				System.out.print(rs2.getString("gain2") + "\t");
				System.out.print(rs2.getString("gain3"));

				gainer1.setText(rs2.getString("gain1"));
			//	gainer2.setText(rs2.getString("gain2"));
				//gainer3.setText(rs2.getString("gain3"));

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