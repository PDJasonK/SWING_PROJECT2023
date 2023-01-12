package OngoingProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ResultToeic.ResultTest;

public class TestOption {

	public TestOption() {

		JButton tbtn1, tbtn2, tbtn3, tbtn4;
			

		JFrame toframe = new JFrame("ToeicOptions");
		toframe.setSize(1000, 1000);
//		toframe.setLayout(new FlowLayout());
		toframe.setLayout(null);

		toframe.setVisible(true);

		tbtn1 = new JButton(" [리딩 유형 1 ] 단문공란 메우기 (문법/어휘)");
		toframe.add(tbtn1);
		tbtn1.setBounds(60, 60, 800, 180);
		tbtn1.setFont(new Font("Gothic", Font.BOLD, 30));
		tbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultTest RT = new ResultTest(null);
				toframe.setVisible(false);
			}
		});

		tbtn2 = new JButton("[리딩유형 2] 장문 공란 메우기");
		toframe.add(tbtn2);
		tbtn2.setBounds(60, 260, 800, 180);
		tbtn2.setFont(new Font("Gothic", Font.BOLD, 30));
		tbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toframe.setVisible(false);

				new ToeicTest2(null);
			}
		});

		tbtn3 = new JButton("[리딩유형 3] 독해 ");
		toframe.add(tbtn3);
		tbtn3.setBounds(60, 460, 800, 180);
		tbtn3.setFont(new Font("Gothic", Font.BOLD, 30));
		tbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ToeicTest3(null);
				toframe.setVisible(false);
			}
		});

		tbtn4 = new JButton("[ 종합 시험 ]");
		toframe.add(tbtn4);
		tbtn4.setBounds(60, 660, 800, 180);
		tbtn4.setFont(new Font("Gothic", Font.BOLD, 30));

		tbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toframe.setVisible(false);
				new ToeicTest(null);

			}

		});

	}

}