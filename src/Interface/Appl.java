package Interface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchProviderException;
import java.util.ArrayList;

import javax.mail.SendFailedException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Email.Mail;
import Facebook.Facebook;
import Facebook.SendPosts;
import Twitter.TwitterES;
import xpath.InfoXPath;

/**
 * @author ES2018
 * 
 * 
 *
 */
public class Appl extends JFrame {
	private JPanel panel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox checkTwitter = new JCheckBox("Twitter");
	private JCheckBox checkFacebook = new JCheckBox("Facebook");
	private JCheckBox checkEmail = new JCheckBox("Email");
	private JTextArea textarea = new JTextArea();
	private JButton btnNewButton = new JButton("Procurar");
	private JList<String> jlist;
	 
	
	
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appl frame = new Appl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor que inicializa a interface e exibe as respetivas informações
	 * conforme o filtro selecionado
	 * 
	 * 
	 * 
	 */
	public Appl() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 999, 600);

		panel = new JPanel();
		panel.setBounds(200, 200, 850, 600);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		textarea.setBounds(10, 88, 834, 440);
		JScrollPane sp = new JScrollPane(textarea);
		sp.setBounds(10, 88, 834, 440);
		panel.add(sp);

		textField_1 = new JTextField();
		textField_1.setBounds(228, 22, 237, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);

		String[] op = { "Este dia", "Este mês", "Este ano" };
		JComboBox comboBox = new JComboBox(op);

		comboBox.setBounds(595, 57, 136, 25);
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);

		btnNewButton = new JButton("Procurar");
		btnNewButton.setBounds(475, 25, 100, 26);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				textarea.setText("");
				if (checkTwitter.isSelected()) {
					TwitterES t = new TwitterES(textField_1.getText(), comboBox.getSelectedItem().toString());

					for (String s : t.getTweets()) {
						textarea.append(s + "\n");
					}
				}

				if (checkFacebook.isSelected()) {
					Facebook f = new Facebook(textField_1.getText(), comboBox.getSelectedItem().toString());

					System.out.println(comboBox.getSelectedItem().toString());

					for (String s : f.getPosts()) {
						textarea.append(s + "\n");
					}

				}

				if (checkEmail.isSelected()) {
					Mail f=new Mail(textField_1.getText());
					f.check();
					
					for(String mails:f.getMails()) {
						textarea.append(mails+"\n");
					}
					
				}

			}

		});

		JButton responder = new JButton("Responder");
		responder.setBounds(445, 539, 89, 20);
		panel.add(responder);

		responder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkFacebook.isSelected()) {
					SendPosts a = new SendPosts(textField_2.getText());
				}
			}
		});

		checkFacebook.setBounds(96, 58, 97, 23);
		panel.add(checkFacebook);

		checkTwitter.setBounds(264, 58, 97, 23);
		panel.add(checkTwitter);

		checkEmail.setBounds(402, 58, 97, 23);
		panel.add(checkEmail);

		textField_2 = new JTextField();
		textField_2.setBounds(230, 539, 205, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

	}
}
