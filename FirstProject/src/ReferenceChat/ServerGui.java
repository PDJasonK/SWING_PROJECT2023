package ReferenceChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField jtf;
      private JTextArea jta;
      private ChatServ cs = new ChatServ();
      
      public ServerGui(){
          setTitle("선생");
          setBounds(100, 100, 400, 500);
          jtf = new JTextField(30);
          jta = new JTextArea(40, 30);
          add(jta, BorderLayout.CENTER);
          add(jtf, BorderLayout.SOUTH);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setVisible(true);

           jtf.addActionListener(this);
           cs.setSg(this);
           cs.setting();
        
      } 

      @Override
       public void actionPerformed(ActionEvent e) {
            String msg = jtf.getText() + "\n";
            jta.append("선생:" + msg);

            cs.sendMessage(msg);
            jtf.setText("");
        }

        public void appendMsg(String msg){
            jta.append(msg);
         }


       public static void main(String[] args){
           new ServerGui();

}     
}
           