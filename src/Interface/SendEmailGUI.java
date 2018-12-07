package Interface;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Email.SendMail;

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
 * The Class SendEmailGUI.
 */
public class SendEmailGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	
	/**
	 * Instantiates a new send email GUI.
	 */
	public SendEmailGUI() {
		
		setBounds(100, 100, 602, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SendEmailGUI.class.getResource("/Image/bomdia2.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 566, 62);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(33, 265, 521, 216);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(98, 198, 315, 37);
		contentPane.add(textPane_1);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Arial", Font.BOLD, 14));
		lblSubject.setBounds(33, 198, 78, 43);
		contentPane.add(lblSubject);
		
		JLabel lblPleaseWriteThe = new JLabel("Please write the email you want to send:");
		lblPleaseWriteThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWriteThe.setFont(new Font("Arial", Font.BOLD, 14));
		lblPleaseWriteThe.setBounds(33, 97, 521, 23);
		contentPane.add(lblPleaseWriteThe);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(98, 150, 315, 37);
		contentPane.add(textPane_2);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTo.setBounds(61, 150, 62, 43);
		contentPane.add(lblTo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SendEmailGUI.class.getResource("/Image/gmail.png")));
		label.setBounds(489, 11, 87, 62);
		contentPane.add(label);
		

		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSend.setBounds(183, 492, 230, 23);
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SendMail sm=new SendMail();
				sm.send(textPane_2.getText(), textPane_1.getText(), textPane.getText());
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
