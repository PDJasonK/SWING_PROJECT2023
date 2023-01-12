package OngoingProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Sounds.PlayMusicJavaSuperSimple;
import ToeicContents.SubmitMain;
import Vocabs.AcceptMain;
import Vocabs.VocabAcceptMain1;

public class ToeicOptions {
	private JButton tbtn1, tbtn2, tbtn3, /* tbtn4 */ tbtn5, tbtn0;

	public ToeicOptions() {

		JFrame toframe = new JFrame("ToeicOptions");
		toframe.setSize(1000, 1000);
		toframe.setLayout(new FlowLayout());

		toframe.setVisible(true);

		tbtn1 = new JButton("지문 독해");
		toframe.add(tbtn1);
		tbtn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new SubmitMain();
				toframe.setVisible(false);

			}
		});

		tbtn2 = new JButton("단어 체크 [Check List of Vocab]");
		toframe.add(tbtn2);
		tbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toframe.setVisible(false);

				new VocabAcceptMain1();
			}
		});

		tbtn3 = new JButton("실력 체크 퀴즈");
		toframe.add(tbtn3);
		tbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AcceptMain();
			}
		});

		tbtn0 = new JButton("듣기");
		toframe.add(tbtn0);
		tbtn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PlayMusicJavaSuperSimple PS = new PlayMusicJavaSuperSimple();
			}

		});

		/*
		 * tbtn4 = new JButton("시험 보기"); toframe.add(tbtn4); tbtn4.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) {
		 * toframe.setVisible(false); new ToeicTest(null);
		 */

		tbtn5 = new JButton("시험 보기");
		toframe.add(tbtn5);
		tbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toframe.setVisible(false);
				new TestOption();
			}

		});

	}

}