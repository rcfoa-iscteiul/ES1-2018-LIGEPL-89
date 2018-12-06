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
import java.awt.Font;

public class SearchTwitterGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchTwitterGUI frame = new SearchTwitterGUI();
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
	public SearchTwitterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(69, 11, 46, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SearchTwitterGUI.class.getResource("/Image/bomdia2.jpg")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 11, 597, 58);
		contentPane.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(74, 133, 464, 155);
		contentPane.add(textArea);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(185, 353, 242, 23);
		contentPane.add(btnClose);
		
		JButton btnRetweet = new JButton("Retweet");
		btnRetweet.setBounds(139, 299, 89, 23);
		contentPane.add(btnRetweet);
		
		JButton btnFavorite = new JButton("Favorite");
		btnFavorite.setBounds(388, 299, 89, 23);
		contentPane.add(btnFavorite);
		
		JLabel lblFavoritescount = new JLabel("Favorites: @count");
		lblFavoritescount.setFont(new Font("Arial", Font.BOLD, 14));
		lblFavoritescount.setBounds(126, 99, 145, 23);
		contentPane.add(lblFavoritescount);
		
		JLabel lblRetweetscount = new JLabel("Retweets: @count");
		lblRetweetscount.setFont(new Font("Arial", Font.BOLD, 14));
		lblRetweetscount.setBounds(367, 99, 145, 23);
		contentPane.add(lblRetweetscount);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchTwitterGUI.class.getResource("/Image/twitter2.png")));
		label_2.setBounds(520, 11, 87, 71);
		contentPane.add(label_2);
	}
}
