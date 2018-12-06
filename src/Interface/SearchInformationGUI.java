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
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JList;

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
		setBounds(100, 100, 852, 624);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/bomdia2.jpg")));
		label.setBounds(10, 24, 816, 70);
		contentPane.add(label);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Arial", Font.BOLD, 15));
		lblSearch.setBounds(181, 105, 67, 54);
		contentPane.add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(244, 123, 320, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/facebook3.png")));
		label_2.setBounds(723, 443, 91, 75);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/twitter2.png")));
		label_1.setBounds(723, 316, 80, 75);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/gmail.png")));
		label_3.setBounds(723, 196, 80, 70);
		contentPane.add(label_3);
		
		JRadioButton twitterButton = new JRadioButton("");
		twitterButton.setBounds(683, 342, 27, 23);
		contentPane.add(twitterButton);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(683, 465, 27, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(683, 218, 21, 23);
		contentPane.add(radioButton_1);
		
		JButton btnNewButton = new JButton("Search\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(427, 545, 212, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//welcome.run();!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		});
		btnBack.setFont(new Font("Arial", Font.BOLD, 16));
		btnBack.setBounds(135, 545, 212, 29);
		contentPane.add(btnBack);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u00FAltima hora "}));
		comboBox.setBounds(602, 157, -38, 36);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u00DAltima hora", "\u00DAltimas 6 horas", "\u00DAltimas 24 horas"}));
		comboBox_1.setBounds(574, 123, 100, 20);
		contentPane.add(comboBox_1);
		
		JList list = new JList();
		list.setBounds(22, 170, 628, 357);
		contentPane.add(list);
		
		
	}
}