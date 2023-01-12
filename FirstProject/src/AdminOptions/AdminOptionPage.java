package AdminOptions;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import AdminReading.AdminSubmit;
import AdminVocab.VocabToeic1MainOut;
import OngoingProject.HighSchoolGrammar;
import ReferenceChat.ServerGui;
import Vocabs.VocabAcceptMain1;

public class AdminOptionPage implements ActionListener {

	private JFrame frameAP;
	private JButton b3, b4, b5, b6, b7;
	private JTextArea MainNotice;

	public AdminOptionPage() {

		frameAP = new JFrame("Admin Option Maker");
//		frame.setLayout(new FlowLayout());
		frameAP.setLayout(null);
		frameAP.setSize(1050, 1200);

		ScrollPane sp = new ScrollPane();
		JPanel p = new JPanel();
		p.setBackground(Color.yellow);

		MainNotice = new JTextArea(
				"              출제하실 과목 및 내용을 선택해주세요.\n                                          (토익)");
		MainNotice.setBounds(150, 30, 800, 90);
		MainNotice.setFont(new Font("Gothic", Font.BOLD, 30));

//--------------------------------------b3-----------------------------------------------------------
		b3 = new JButton("[지문 독해 해석] - Explanation of Reading ");
		b3.setBounds(60, 360, 400, 180);
		b3.setFont(new Font("Gothic", Font.BOLD, 15));

		// b3.setSize(100, 80);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// f3.setVisible(true);
				frameAP.setVisible(false);
				new HighSchoolGrammar();

			}

		});

//--------------------------------------b4-----------------------------------------------------------

		b4 = new JButton("[업로드한 단어 확인] - Vocab Check");
		b4.setBounds(560, 360, 400, 180);
		b4.setFont(new Font("Gothic", Font.BOLD, 20));
		// b4.setSize(100, 80);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				f4.setVisible(true);
				frameAP.setVisible(false);
				new VocabToeic1MainOut();
			}

		});

//--------------------------------------b5-----------------------------------------------------------

		b5 = new JButton("[채팅] - 채팅보내기");
		b5.setBounds(300, 600, 400, 200);
		b5.setFont(new Font("Gothic", Font.BOLD, 30));

		// b5.setSize(100, 80);
		b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ServerGui SG = new ServerGui();
			}
		});

		b6 = new JButton("[단어 리스트 넣기 ]  \n add Lists of Vocab");
		b6.setBounds(560, 160, 400, 180);
		b6.setFont(new Font("Gothic", Font.BOLD, 15));

		// b5.setSize(100, 80);
		b6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new VocabToeic1MainOut();
				// f5.setVisible(true);

//				frame.setVisible(false);

			}
		});

		b7 = new JButton("[토익 지문 넣기 ] \n Add reading article");
		b7.setBounds(60, 160, 400, 180);
		b7.setFont(new Font("Gothic", Font.BOLD, 15));

		// b5.setSize(100, 80);
		b7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frameAP.setVisible(false);
				new AdminSubmit();

			}
		});

	}

	public void startFrame() {

//		frameAP.add(b1);
//		frameAP.add(b2);
		frameAP.add(b3);
		frameAP.add(b4);
		frameAP.add(b5);
		frameAP.add(b6);
		frameAP.add(b7);
		frameAP.add(MainNotice);

		frameAP.setVisible(true);
	}

	public static void main(String[] args) {
		AdminOptionPage AP = new AdminOptionPage();

		AP.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frameAP.setVisible(true);

	}
}