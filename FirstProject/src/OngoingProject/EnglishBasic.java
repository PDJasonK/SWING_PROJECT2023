package OngoingProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EnglishBasic {
	public EnglishBasic() {
		JButton tbtn1, tbtn2, tbtn3, tbtn4;

		JFrame toframe = new JFrame("ToeicOptions");
		toframe.setSize(1000, 1000);
		toframe.setLayout(new FlowLayout());

		toframe.setVisible(true);

		tbtn1 = new JButton("지문 독해");
		toframe.add(tbtn1);
		tbtn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Instruction();
			}
		});

		tbtn2 = new JButton("필수 단어 리스트");
		toframe.add(tbtn2);
		tbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ToeicVocab();
			}
		});
		
		 
		
		  tbtn3 = new JButton("실력 체크 퀴즈"); 
		  toframe.add(tbtn3);
		  tbtn3.addActionListener(new ActionListener() {  
		  public void actionPerformed(ActionEvent e) {
		  new ToeicQuiz();
		 
		  }
		  }); 
		  
		tbtn4 = new JButton("시험 보기"); 
		toframe.add(tbtn4);
		tbtn4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) { 
		new ToeicTest(null);

		
	}
		  
		  });

}

}