package Interface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchProviderException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.tutorialspoint.Mail;

import facebookexample.Facebook;
import twitterexample.TwitterES;


public class Appl extends JFrame {
	private JPanel panel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox checkTwitter=new JCheckBox("Twitter");
	private JCheckBox checkFacebook = new JCheckBox("Facebook");
	private JCheckBox checkEmail = new JCheckBox("Email");
	private JTextArea textarea= new JTextArea();
	private JButton btnNewButton = new JButton("Procurar");
	
	
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

	public Appl(){
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		setBounds(200, 200, 850, 600);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(228, 22, 237, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);

		btnNewButton = new JButton("Procurar");
		btnNewButton.setBounds(475, 25, 100, 26);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				textarea.setText("");
				if(checkTwitter.isSelected()) {
					TwitterES t=new TwitterES(textField_1.getText());
					ArrayList<String> temp=t.getTweets();
					
					for (String s : temp) {
						textarea.append(s+"\n");
					}
				}
				
				if(checkFacebook.isSelected()) {
					Facebook f=new Facebook();
					ArrayList<String> temp=f.getPosts();
					
					for (String s : temp) {
						textarea.append(s+"\n");
					}
				}
				
				if(checkEmail.isSelected()) {
					Mail f=new Mail();
					try {
						f.check();
					} catch (NoSuchProviderException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ArrayList<String> temp=f.getMails();
					
					for (String s : temp) {
						textarea.append(s+"\n");
						textarea.append("\n");
					}
				}
				
				}
				
			
		});


		checkFacebook.setBounds(96, 58, 97, 23);
		panel.add(checkFacebook);

		
		checkTwitter.setBounds(264, 58, 97, 23);
		panel.add(checkTwitter);

		checkEmail.setBounds(402, 58, 97, 23);
		panel.add(checkEmail);

		
		textarea.setBounds(0, 88, 834, 440);
		panel.add(textarea);

		textField_2 = new JTextField();
		textField_2.setBounds(230, 539, 205, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("Responder");
		btnNewButton_1.setBounds(445, 539, 89, 20);
		panel.add(btnNewButton_1);
		
		String[] op= {"Últimas 24h","Última hora","Últimos 30min","Últimos 15min","Últimos 5min"};
		JComboBox comboBox = new JComboBox(op);
		
		comboBox.setBounds(595, 57, 136, 25);
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);
		
		


	}
}
