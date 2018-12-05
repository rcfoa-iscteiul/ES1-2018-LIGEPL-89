package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendInformationGUI extends JFrame {

	private JPanel contentPane;
	private WelcomeGUI welcome;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		run();
	}
	public static void run() {
		try {
			SendInformationGUI frame = new SendInformationGUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public SendInformationGUI() {
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
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(380, 361, 184, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblChooseWhichApplication = new JLabel("Choose which Application you want to send information");
		lblChooseWhichApplication.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblChooseWhichApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseWhichApplication.setBounds(114, 165, 450, 29);
		contentPane.add(lblChooseWhichApplication);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//welcome.run(); !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		});
		btnBack.setFont(new Font("Arial", Font.BOLD, 16));
		btnBack.setBounds(76, 361, 184, 29);
		contentPane.add(btnBack);
		
			}

}
