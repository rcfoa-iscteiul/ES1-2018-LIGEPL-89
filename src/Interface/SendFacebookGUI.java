package Interface;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Facebook.SendPosts;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class SendFacebookGUI.
 */
public class SendFacebookGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;


	/**
	 * Instantiates a new send facebook GUI.
	 */
	public SendFacebookGUI() {
		setBounds(100, 100, 602, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SendFacebookGUI.class.getResource("/Image/bomdia2.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 566, 62);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 139, 566, 167);
		contentPane.add(textPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SendFacebookGUI.class.getResource("/Image/facebook3.png")));
		label.setBounds(495, 11, 70, 62);
		contentPane.add(label);
		
		JLabel lblPleaseWriteThe = new JLabel("Please write the post you want to publish on your Facebook:");
		lblPleaseWriteThe.setFont(new Font("Arial", Font.BOLD, 14));
		lblPleaseWriteThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWriteThe.setBounds(10, 105, 566, 23);
		contentPane.add(lblPleaseWriteThe);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSend.setBounds(191, 318, 230, 23);
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SendPosts s=new SendPosts(textPane.getText());
				s.sendPost();
			}
		});
		contentPane.add(btnSend);
	}
	
	/**
	 * Janela visivel.
	 */
	public void janelaVisivel() {
		setVisible(true);
	}
}
