package LogMains;

import java.awt.Color;
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

public class Signup extends WindowAdapter implements ActionListener {
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
	private JButton signup;

	public Signup() {

		f = new JFrame("Sign up");
		p = new JPanel();
		p.setLayout(new GridLayout(10, 0));

		title = new JLabel("계정 생성");

		lid = new JLabel("ID : ", JLabel.LEFT);
		lpwd = new JLabel("PASSWORD : ", JLabel.LEFT);
		lname = new JLabel("이름 : ", JLabel.LEFT);
		lresi = new JLabel("주소 : ", JLabel.LEFT);
		lnums = new JLabel("휴대폰 번호: ", JLabel.LEFT);

		name = new JTextField(20);
//      name.setSize(10,10);
		resi = new JTextField(20);
		id = new JTextField(20);
		pwd = new JTextField(20);
		PhoneNums = new JTextField(20);

		signup = new JButton("가입하기");
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
	  @Override 
	  public void actionPerformed(ActionEvent e) { 
	 HomeScreen hs = new
	  HomeScreen(); signup.setVisible(false);
	  
	  hs.startFrame(); 
	  }
	  
	  });
	  
	  }
	 */
	public void startframe() {
		f.setSize(600, 400);
		f.add(p, "Center");
		f.add(signup, "South");
		f.add(title, "North");

		p.add(lid);
		p.add(id);
		p.add(lpwd);
		p.add(pwd);
		p.add(lname);
		p.add(name);
		p.add(lresi);
		p.add(resi);
		p.add(lnums);
		p.add(PhoneNums);

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
			SignupDAO dao = new SignupDAO();
			ArrayList<SignupVo> list = dao.list(id.getText(), pwd.getText(), resi.getText(), name.getText(),
					PhoneNums.getText());
			String id = this.id.getText();
			System.out.println(id);
			LoginChecker lc = new LoginChecker(id);
		}
	}
}