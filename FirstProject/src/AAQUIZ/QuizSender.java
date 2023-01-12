package AAQUIZ;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LogDatas.SignupDAO;
import LogDatas.SignupVo;
import LogMains.LoginChecker;

public class QuizSender extends WindowAdapter implements ActionListener {
	private JFrame f;
	private JPanel p;

	private JLabel lname;
	private JLabel lresi;
	private JLabel lid;
	private JLabel lpwd;
	private JLabel title;
	private JLabel lnums;

	private JTextField name;
	private JTextField resi;
	private JTextField id;
	private JTextField pwd;
	private JTextField PhoneNums;

	private JTextField Reading1;
	private JTextField Reading2;
	private JTextField Reading3;

	private JButton signup;

	public QuizSender() {

		f = new JFrame("Sign up");
		f.setLayout(null);
		f.setSize(1200,1200);
		p = new JPanel();
 

		title = new JLabel("첫번째 문제");
		title.setFont(new Font("Gothic", Font.BOLD, 20));
		title.setBounds(20,-10,300,100);


		Reading1 = new JTextField();
		Reading1.setLayout(null);
		Reading1.setBounds(20,60,650,280);
		Reading1.setEditable(false);


		Reading2 = new JTextField();
		Reading2.setLayout(null);
		Reading2.setBounds(20,360,650,280);
		Reading2.setEditable(false);
		
		Reading3 = new JTextField();
		Reading3.setLayout(null);
		Reading3.setBounds(20,660,650,280);
		Reading3.setEditable(false);


		
		signup = new JButton("가입하기");
		signup.setBounds(800,800,100,100);
		signup.setBackground(Color.gray);
//		signup.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			 new LoginChecker();
//				signup.setVisible(false);
//				f.setVisible(false);
//
//			}
//
//		});

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
		f.setSize(1200, 1200);
		f.add(p, "Center");
		f.add(signup, "South");
		f.add(title, "North");

		f.add(Reading1);
		f.add(Reading2);
		f.add(Reading3);
 


		f.setVisible(true);

		f.addWindowListener(this);
		signup.addActionListener(this);

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("가입하기")) {
			QuizSenderDAO dao = new QuizSenderDAO();
			ArrayList<QuizSenderVo> list = dao.list(Reading1.getText(), Reading2.getText(), Reading3.getText());
			String id = this.id.getText();
			System.out.println(id);
			LoginChecker lc = new LoginChecker(id);
		}

	}
}