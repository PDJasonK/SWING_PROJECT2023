package OngoingProject;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.JButton;

public class CheckboxTest {
    public static void main(String[] args) {
        Frame frame = new Frame("Questions");
        frame.setSize(305, 250);
        frame.setLayout(new FlowLayout());
 
        Label q1 = new Label("1. 당신의 관심 분야는?(여러개 선택가능)");
        Checkbox news = new Checkbox("news", true);
        Checkbox sports = new Checkbox("sports");
        Checkbox movie = new Checkbox("movie");
        Checkbox music = new Checkbox("music");
        JButton btn1 = new JButton("NEXT");
        frame.add(q1);
        frame.add(news);
        frame.add(sports);
        frame.add(movie);
        frame.add(music);
        frame.add(btn1);
        

       Label q2 = new Label("2. 얼마나 자주 극장에 가십니까?");
       CheckboxGroup group1 = new CheckboxGroup();
       Checkbox movie1 = new Checkbox("한 달에 한 번 갑니다.", group1, true);
       Checkbox movie2 = new Checkbox("일주일에 한 번 갑니다.", group1, true);
       Checkbox movie3 = new Checkbox("일주일에 두 번 갑니다.", group1, true);
       JButton btn2 = new JButton("NEXT");
       frame.add(q2);
       frame.add(movie1);
       frame.add(movie2);
       frame.add(movie3);
       frame.add(btn2);
       
       
       Label q3 = new Label("3. 하루에 얼마나 컴퓨터를 사용하십니까?");
       CheckboxGroup group2 = new CheckboxGroup();
       Checkbox com1 = new Checkbox("5시간 이하", group2, true);
       Checkbox com2 = new Checkbox("10시간 이하", group2, false);
       Checkbox com3 = new Checkbox("15시간 이상", group2, false);
       JButton btn3 = new JButton("NEXT"); 
       
       frame.add(q3);
       frame.add(com1);
       frame.add(com2);
       frame.add(com3);
       frame.add(btn3);
       
       frame.setVisible(true);
   }
}
