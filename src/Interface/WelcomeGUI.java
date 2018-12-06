package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class WelcomeGUI extends JFrame {

	private JPanel contentPane;
	private LoginGUI logingui;
	private SearchInformationGUI search;
	private SendInformationGUI send;
	private String user;
	private ArrayList<String> tokens;
	/**
	 * Launch the application.
	 */

	
	public WelcomeGUI(LoginGUI logingui) throws HeadlessException {
		this.logingui = logingui;
		tokens=logingui.getLogin();
	}
	
	
	/**
	 * Create the frame.
	 */
	public void constroiJanela() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 344);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome " + user +"!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		lblWelcome.setBounds(25, 138, 452, 52);
		contentPane.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Search Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search.run();
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(25, 230, 144, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send.run();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(179, 230, 144, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				logingui.dispose();
				dispose();
				LoginGUI login1 = new LoginGUI();
				login1.run();
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(333, 230, 144, 44);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(WelcomeGUI.class.getResource("/Image/bomdia4.png")));
		label.setBounds(25, 11, 452, 116);
		contentPane.add(label);
		setVisible(true);
	}
	
	
	
	

	public ArrayList<String> getTokens() {
		return tokens;
	}


	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
