package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchInformationGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private LoginGUI login;
	private WelcomeGUI welcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		try {
			SearchInformationGUI frame = new SearchInformationGUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public SearchInformationGUI() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 455);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/bomdia2.jpg")));
		label.setBounds(182, 24, 320, 104);
		contentPane.add(label);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Arial", Font.BOLD, 15));
		lblSearch.setBounds(114, 139, 91, 54);
		contentPane.add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(182, 157, 320, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/facebook3.png")));
		label_2.setBounds(114, 253, 91, 75);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/twitter2.png")));
		label_1.setBounds(296, 253, 100, 75);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/gmail.png")));
		label_3.setBounds(473, 253, 91, 75);
		contentPane.add(label_3);
		
		JRadioButton twitterButton = new JRadioButton("");
		twitterButton.setBounds(318, 223, 27, 23);
		contentPane.add(twitterButton);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(136, 223, 27, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(495, 223, 21, 23);
		contentPane.add(radioButton_1);
		
		JButton btnNewButton = new JButton("Search\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(339, 361, 212, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//welcome.run();!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		});
		btnBack.setFont(new Font("Arial", Font.BOLD, 16));
		btnBack.setBounds(68, 361, 212, 29);
		contentPane.add(btnBack);
		
		
	}
}
