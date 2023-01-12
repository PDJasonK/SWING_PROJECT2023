package OngoingProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Speaking {
	public Speaking() {
		JButton tbtn1, tbtn2, tbtn3, tbtn4;

		JFrame toframe = new JFrame("ToeicOptions");
		toframe.setSize(1000, 1000);
		toframe.setLayout(new FlowLayout());

		toframe.setVisible(true);

		tbtn1 = new JButton("스피킹 패턴 [Dialogue Patterns]");
		toframe.add(tbtn1);
		tbtn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Instruction();
			}
		});

		tbtn2 = new JButton("토익스피킹 패턴 [Paaterns From Toeic Speaking]");
		toframe.add(tbtn2);
		tbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ToeicVocab();
			}
		});

		
		 
		  tbtn3 = new JButton("오픽 테스트 대비 [OPIC Speaking Test]"); toframe.add(tbtn3);
		  tbtn3.addActionListener(new ActionListener() { public void
		  actionPerformed(ActionEvent e) { new ToeicQuiz();
		  
		  } });
		 /* 
		 * tbtn4 = new JButton("시험 보기"); toframe.add(tbtn4); tbtn4.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) { new
		 * ToeicTest();
		 * 
		 * 
		 * }
		 * 
		 * });
		 */
	}

}