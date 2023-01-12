package ReferenceChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField jtf;
	private JTextArea jta;
	private ChatCli cc;

	public ClientGui() {
		setTitle("강습생");

		jta = new JTextArea(40, 25);
		jtf = new JTextField(25);
		cc = new ChatCli();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText() + "\n";
		jta.append("강습생:" + msg);
		cc.sendMessage(msg);
		jtf.setText("");
	}

	public void appendMsg(String msg) {
		jta.append(msg);
	}

	public void startframe() {

		cc.connect();
		setBounds(500, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		jtf.addActionListener(this);
		cc.setCg(this);

		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		
		
		setVisible(true);

	}

	public static void main(String[] args) {
		new ClientGui();
	}
}
