package Interface;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Twitter.SendTweet;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendTwitterGUI extends JFrame {

	private JPanel contentPane;

	
	public SendTwitterGUI() {
		setBounds(100, 100, 602, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SendTwitterGUI.class.getResource("/Image/bomdia2.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 566, 62);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(46, 151, 514, 68);
		contentPane.add(textPane);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSend.setBounds(187, 230, 230, 23);
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SendTweet st=new SendTweet();
				st.enviaTweet(textPane.getText());
			}
		} );
		contentPane.add(btnSend);
		
		JLabel lblNewLabel_1 = new JLabel("Please write the tweet you want to publish on your Twitter:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 117, 566, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SendTwitterGUI.class.getResource("/Image/twitter2.png")));
		label.setBounds(490, 11, 75, 68);
		contentPane.add(label);
	}
	
	public void janelaVisivel() {
		setVisible(true);
	}
}
