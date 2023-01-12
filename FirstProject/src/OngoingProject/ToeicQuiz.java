package OngoingProject;

import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ToeicQuiz {

	public ToeicQuiz() {

		JFrame frame = new JFrame("ToeicQuiz");
		frame.setSize(1200, 1200);
		//frame.setLayout(new FlowLayout());
	frame.setLayout(null);

		JTextArea q1 = new JTextArea("[1] \n \n Mostly exam,test and quizs are contains triger for you to study harder"
				+ "\n since most of those contents are required you to have ability to understand whole contexts");
		q1.setBounds(60, 60, 800, 80);
		q1.setEditable(false);

		JButton btn1 = new JButton("풀이 보기.");
		frame.add(btn1);
		btn1.setVisible(true);
		btn1.setBounds(900, 60, 200, 80);


		JCheckBox q1no1 = new JCheckBox("May", true);
		q1no1.setLocation(120,120);
		q1no1.setVisible(true);

		
		
		JCheckBox q1no2 = new JCheckBox("Could");
		q1no2.setLocation(120,220);
		q1no2.setVisible(true);
		
		JCheckBox q1no3 = new JCheckBox("Shall");
		q1no3.setLocation(120,320);
		q1no3.setVisible(true);

		
		JCheckBox q1no4 = new JCheckBox("Would");
		q1no4.setLocation(120,420);
		q1no4.setVisible(true);
		
		JCheckBox q1no5 = new JCheckBox("Might");
		q1no5.setLocation(120,520);
		q1no5.setVisible(true);

		frame.add(q1);
		frame.add(q1no1);
		frame.add(q1no2);
		frame.add(q1no3);
		frame.add(q1no4);
		frame.add(q1no5);
		frame.add(btn1);
		frame.setVisible(true);

	}
}
