package VocabDB;

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


public class VocabToeic1Main extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel PContent1;
//	private JLabel PContent2;
	//private JLabel PContent3;
	private JLabel title;
	private Statement stmt;
	private Connection conn;
	private JButton Submit,btn1,btn2;


	VocabToeic1DAO dao = new VocabToeic1DAO();


	/*
	 * public static JTextArea yoyo1 = new JTextArea(); public static JTextArea
	 * yoyo2 = new JTextArea(); public static JTextArea yoyo3 = new JTextArea();
	 */	
	public static JTextArea Input1 = new JTextArea();
	public static JTextArea Input2= new JTextArea();
	public static JTextArea Input3 = new JTextArea();
	public static JTextArea Input4 = new JTextArea();
	public static JTextArea Input5 = new JTextArea();
	public static JTextArea Input6 = new JTextArea();
	public static JTextArea Input7 = new JTextArea();
	public static JTextArea Input8 = new JTextArea();

	// ----------
	public static JTextArea Output1aa = new JTextArea();
	public static JTextArea Output2aa= new JTextArea();
	public static JTextArea Output3aa = new JTextArea();
	public static JTextArea Output4aa= new JTextArea();
	public static JTextArea Output5aa = new JTextArea();
	public static JTextArea Output6aa = new JTextArea();
	public static JTextArea Output7aa= new JTextArea();
	public static JTextArea Output8aa = new JTextArea();
	public static JTextArea Output9aa = new JTextArea();
	public static JTextArea Output10aa = new JTextArea();
	public static JTextArea Output11aa = new JTextArea();
	public static JTextArea Output12aa = new JTextArea();

	/*
	 * public static void main(String[] args) { SubmitMain sm = new SubmitMain();
	 * sm.startframe(); }
	 */
	public VocabToeic1Main() {
		
		f = new JFrame("Voca");
		p = new JPanel();
		p.setLayout(null);

		// -----
		

		title = new JLabel("단어 [Vocab List] ");
		title.setBounds(30, 1, 800, 50);
		
		Output1aa.setLayout(null);
		Output1aa.setBounds(30, 55, 350, 60);
//		Output1.setEditable(false);
		

		Output2aa.setLayout(null);
		Output2aa.setBounds(430, 55, 350, 60);
	//	Output2.setEditable(false);
		
		Output3aa.setLayout(null);
		Output3aa.setBounds(30, 155, 350, 60);
	//	Output3.setEditable(false);
		
		Output4aa.setLayout(null);
		Output4aa.setBounds(430, 155, 350, 60);
		//Output4.setEditable(false);
		
		
		Output5aa.setLayout(null);
		Output5aa.setBounds(30, 255, 350, 60);
		//Output5.setEditable(false);
		
		Output6aa.setLayout(null);
		Output6aa.setBounds(430, 255, 350, 60);
		//Output6.setEditable(false);
		
		Output7aa.setLayout(null);
		Output7aa.setBounds(30, 355, 350, 60);
		//Output7.setEditable(false);
		
		Output8aa.setLayout(null);
		Output8aa.setBounds(430, 355, 350, 60);
		//Output8.setEditable(false);
		
		Output9aa.setLayout(null);
		Output9aa.setBounds(30, 455, 350, 60);
		//Output8.setEditable(false);
		
		Output10aa.setLayout(null);
		Output10aa.setBounds(430, 455, 350, 60);
		//Output8.setEditable(false);
		
		Output11aa.setLayout(null);
		Output11aa.setBounds(30, 555, 350, 60);
		//Output8.setEditable(false);
		
		Output12aa.setLayout(null);
		Output12aa.setBounds(430, 555, 350, 60);
		//Output8.setEditable(false);
		
		
		PContent1 = new JLabel("첫번째 문단의 해석문", JLabel.LEFT);
		PContent1.setBounds(30, 400, 500, 500);
		/*PContent2 = new JLabel("두번째 문단의 해석문", JLabel.LEFT);
		PContent2.setBounds(30, 380, 500, 500);
		PContent3 = new JLabel("세번째 첫번째 문단의 해석문 ", JLabel.LEFT);
		PContent3.setBounds(30, 520, 500, 500);
*/
	Input1 = new JTextArea();
		Input1.setBounds(30, 680, 800, 180 );
		Input1.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input1.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input1.setBackground(Color.YELLOW);
		         }
		      });
		/*		
		Input2 = new JTextArea();
		Input2.setBounds(30, 640, 50, 90);
		Input2.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input2.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input2.setBackground(Color.YELLOW);
		         }
		      });
		
		Input3 = new JTextArea();
		Input3.setBounds(30, 780, 50, 90);
		Input3.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input3.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input3.setBackground(Color.YELLOW);
		         }
		      });
		
		Input4 = new JTextArea();
		Input4.setBounds(90, 500, 50, 90);
		Input4.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input4.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input4.setBackground(Color.YELLOW);
		         }
		      });
		
		Input5 = new JTextArea();
		Input5.setBounds(90, 640, 50, 90);
		Input5.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input5.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input5.setBackground(Color.YELLOW);
		         }
		      });
		
		Input6 = new JTextArea();
		Input6.setBounds(90, 780, 50, 90);
		Input6.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input6.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input6.setBackground(Color.YELLOW);
		         }
		      });
		
		
		Input7 = new JTextArea();
		Input7.setBounds(150, 500, 50, 90);
		Input7.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input7.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input7.setBackground(Color.YELLOW);
		         }
		      });
		
		Input8 = new JTextArea();
		Input8.setBounds(150, 640, 50 ,90);
		Input8.addFocusListener(new FocusAdapter() {
	         public void focusGained(FocusEvent e) {
	        	 Input8.setBackground(Color.ORANGE);
		         }
		         
		         @Override
		         public void focusLost(FocusEvent e) {
		        	 Input8.setBackground(Color.YELLOW);
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
		

		
		startframe();

		

//		Submit.setBackground(Color.gray);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Output1aa.getSelectedText() + Output2aa.getSelectedText() + Output3aa.getSelectedText()
				+Output4aa.getSelectedText() + Output5aa.getSelectedText() + Output6aa.getSelectedText() + Output7aa.getSelectedText()
				+ Output8aa.getSelectedText());
				
				if (Output1aa.getText() != null && Output2aa.getText() != null && Output3aa.getText() != null
						&&Output4aa.getText()!= null && Output5aa.getText() != null && Output6aa.getText()!= null
						&&Output7aa.getText()!= null && Output8aa.getText() !=null) {
					String Output1a = Output1aa.getText();
					String Output2b = Output2aa.getText();
					String Output3c= Output3aa.getText();
					String Output4d = Output4aa.getText();
					String Output5e = Output5aa.getText();
					String Output6f= Output6aa.getText();
					String Output7g = Output7aa.getText();
					String Output8h = Output8aa.getText();

					dao.list(Output1a, Output2b, Output3c
							,Output4d,Output5e,Output6f,Output7g,
							Output8h);
				}
			}

		});

	

	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new InstructionTwo();
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
		p.add(title);

		p.add(PContent1);
	//	p.add(PContent2);
		//p.add(PContent3);
		p.add(Submit);

		p.add(Input1);
	/*	p.add(Input2);
		p.add(Input3);
		p.add(Input4);
		p.add(Input5);
		p.add(Input6);
		p.add(Input7);
		p.add(Input8);
*/
		
		p.add(Output1aa);
		p.add(Output2aa);
		p.add(Output3aa);
		p.add(Output4aa);
		p.add(Output5aa);
		p.add(Output6aa);
		p.add(Output7aa);
		p.add(Output8aa);
		p.add(Output9aa);
		p.add(Output10aa);
		p.add(Output11aa);
		p.add(Output12aa);

		
		p.add(btn1);
		p.add(btn2);
		

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
	new VocabToeic1Main();
	}

	
	public void method() {
		//String list = "";
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

			String sql2 = "SELECT Output1, Output2, Output3"
					+ "Output4,Output5,Output6,Output7,Output8 , Output9 , Output10 , Output11 , Output12"
					+ " FROM VocabOut";

			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {

				System.out.print(rs2.getString("Output1") + "\t");
				System.out.print(rs2.getString("Output2") + "\t");
				System.out.print(rs2.getString("Output3"));

				Output1aa.setText(rs2.getString("Output1"));
				Output2aa.setText(rs2.getString("Output2"));
				Output3aa.setText(rs2.getString("Output3"));
				Output4aa.setText(rs2.getString("Output4"));
				Output5aa.setText(rs2.getString("Output5"));
				Output6aa.setText(rs2.getString("Output6"));
				Output7aa.setText(rs2.getString("Output7"));
				Output8aa.setText(rs2.getString("Output8"));
				Output9aa.setText(rs2.getString("Output9"));
				Output10aa.setText(rs2.getString("Output10"));
				Output11aa.setText(rs2.getString("Output11"));
				Output12aa.setText(rs2.getString("Output12"));

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