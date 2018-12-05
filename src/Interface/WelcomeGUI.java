package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomeGUI extends JFrame {

	private JPanel contentPane;
	private LoginGUI logingui;
	private SearchInformationGUI search;
	private SendInformationGUI send;
	private String user;
	/**
	 * Launch the application.
	 */
	 

	
	
	/**
	 * Create the frame.
	 */
	public void constroiJanela() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 357);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome " + user +" to Bom Dia Academia !");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblWelcome.setBounds(82, 11, 353, 52);
		contentPane.add(lblWelcome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(WelcomeGUI.class.getResource("/Image/logobomdia.jpg")));
		label.setBounds(10, 74, 310, 191);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Search Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search.run();
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(330, 74, 144, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send.run();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(330, 148, 144, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close Application");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(330, 221, 144, 44);
		contentPane.add(btnNewButton_2);
		
		setVisible(true);

	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
