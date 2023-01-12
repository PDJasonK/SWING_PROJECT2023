package OngoingProject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class InstructionTwo {

	public InstructionTwo() {
		Frame frame = new Frame("Instruction Two");
	//	frame.setBackground(Color.GRAY);
		frame.setSize(1200, 1200);
		frame.setResizable(false);
		frame.setLayout(null);
//		frame.setLayout(BoxLayout());
// 		frame.setLayout(new FlowLayout());

		JTextArea txtA = new JTextArea("(A)\nMostly exam,test and quizs are contains triger for you to study harder"
				+ "\n since most of those contents are required you to have ability to understand whole contexts"
				+ "\n nand let you show your skills of taking outputs on little paper"
				+ "\n for others to check who you are and it's beginning of social communication"
				+ "\n We know that kids and most of attendants of exam are saying that"
				+ "\n it could be waste of time but it's all comming from people who are"
				+ "\n struggling from beginning of learning" + "\n there are massive of fun facts of studying."
				+ "\n \n (B)\nFirst, there are so many people who are having job inquired to instruct their skills"
				+ "\n but that doesn't mean that they like to study another fields like what they did to their own attendants of classes"
				+ "\n So am I. " + "\n I'm the one who instructed English for variety of ages and enjoyed it."
				+ "\n but didn't like it when I studied it. But at the same time I am now learning new stuffs"
				+ "\n (C)\nbut that doesn't mean that they like to study another fields like what they did to their own attendants of classes"
				+ "\n So am I. " + "\n I'm the one who instructed English for variety of ages and enjoyed it."
				+ "\n but didn't like it when I studied it. But at the same time I am now learning new stuffs"
				+ "\n it's sort of Programming but won't be easy to attatch learning and instructing skills that I used"
				+ "\n to apply on English subjects." + "\n my one wordcomment and recommendation towrd to you guys "
				+ "\n is " + "''Fuck you and just do it''");

		JTextArea txtB = new JTextArea(
				"아래의 칸을 활용하여 지문 독해 내용을 작성 후 Submit 작성 완료한 후" + "NEXT버튼으로 다음단계 진행 및 HOME 버튼으로 돌아가실 수 있습니다.");

		JTextArea txtC = new JTextArea("각 문단 별로의 내용을 해석하여 작성해주세요." + "\n(A)\n\n\n\n\n");

		JTextArea txtD = new JTextArea("작성가능");

		JTextArea txtE = new JTextArea("(B)");

		JTextArea txtF = new JTextArea("작성가능");
		JTextArea txtG = new JTextArea("(C)");

		JTextArea txtH = new JTextArea("작성가능");
		JTextArea txtI = new JTextArea("-page 2 -");
//-------------------------------------------------------------------------------------------------

		txtA.setLayout(null);
		txtA.setBounds(60, 60, 1090, 380);
		txtA.setEditable(false);

		/*
		 * txtA.setLineWrap(false); txtA.setWrapStyleWord(false);
		 * 
		 */
		txtB.setBounds(60, 450, 1090, 20);
		txtB.setEditable(false);
		txtB.setLayout(null);

		txtC.setBounds(60, 490, 1090, 50);
		txtC.setVisible(true);
		txtC.setEditable(false);

		txtD.setBounds(60, 540, 1090, 50);
		txtD.setVisible(true);
		txtD.setEditable(true);

		txtE.setBounds(60, 590, 1090, 50);
		txtE.setVisible(true);
		txtE.setEditable(false);

		txtF.setBounds(60, 640, 1090, 50);
		txtF.setVisible(true);
		txtF.setEditable(true);

		txtG.setBounds(60, 690, 1090, 50);
		txtG.setVisible(true);
		txtG.setEditable(false);

		txtH.setBounds(60, 740, 1090, 50);
		txtH.setVisible(true);
		txtH.setEditable(true);

		txtI.setBounds(600, 800, 60, 20);
		txtI.setVisible(true);
		txtI.setEditable(false);
		
		txtD.addFocusListener(new FocusAdapter() {
	         @Override
	         public void focusGained(FocusEvent e) {
	            txtD.setBackground(Color.ORANGE);
	         }
	         
	         @Override
	         public void focusLost(FocusEvent e) {
	            txtF.setBackground(Color.WHITE);
	         }
	      });
		
		txtH.addFocusListener(new FocusAdapter() {
	         @Override
	         public void focusGained(FocusEvent e) {
	            txtH.setBackground(Color.ORANGE);
	         }
	         
	         @Override
	         public void focusLost(FocusEvent e) {
	            txtH.setBackground(Color.WHITE);
	         }
	      });
		
//-----------------------------------------------------



		JButton btn2 = new JButton("HOME");
		btn2.setVisible(true);
		btn2.setBounds(20, 900, 100, 50);
		btn2.setVisible(true);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();
				frame.setVisible(false);
				hs.startFrame();
			}
		});

		JButton btn3 = new JButton("SUBMIT");
		btn3.setBounds(600, 900, 100, 50);
		btn3.setVisible(true);
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen hs = new HomeScreen();
				frame.setVisible(false);
				hs.startFrame();
			}
		});


		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				new InstructionTwo();

			}
		});
		JButton btn1 = new JButton("NEXT");
		btn1.setVisible(true);
		btn1.setBounds(1050, 900, 100, 50);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InstructionTwo();
			}
		});
		JButton btn4 = new JButton("BACK");
		btn4.setBounds(900, 900, 100, 50);
		btn4.setVisible(true);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Instruction();
				frame.setVisible(false);
			}
		});
		
		
//--------------------------------------------------

		frame.add(txtA);
		frame.add(txtB);
		frame.add(txtC);
		frame.add(txtD);
		frame.add(txtE);
		frame.add(txtF);
		frame.add(txtG);
		frame.add(txtH);
		frame.add(txtI);

		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);

		frame.setVisible(true);
	}
}