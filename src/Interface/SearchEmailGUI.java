package Interface;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class SearchEmailGUI extends JFrame {

	private JPanel contentPane;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmailGUI frame = new SearchEmailGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchEmailGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(69, 11, 46, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SearchEmailGUI.class.getResource("/Image/bomdia2.jpg")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 11, 597, 58);
		contentPane.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 100, 597, 303);
		contentPane.add(textArea);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(325, 414, 242, 23);
		contentPane.add(btnClose);
		
		JButton btnNewButton = new JButton("Answer");
		btnNewButton.setBounds(45, 414, 221, 23);
		contentPane.add(btnNewButton);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchEmailGUI.class.getResource("/Image/gmail.png")));
		label_2.setBounds(515, 11, 81, 58);
		contentPane.add(label_2);
	}
}
