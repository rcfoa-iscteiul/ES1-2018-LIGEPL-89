package Interface;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchTwitterGUI.
 */
public class SearchTwitterGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The fav. */
	private int fav;
	
	/** The retweets. */
	private int retweets;
	
	/** The tweet. */
	private String tweet;
	
	/**
	 * Constroi janela.
	 */
	public void constroiJanela() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		textArea.setText(tweet);
		textArea.setLineWrap(true);
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(74, 133, 464, 155);
		contentPane.add(sp);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(185, 353, 242, 23);
		contentPane.add(btnClose);
		
		JButton btnRetweet = new JButton("Retweet");
		btnRetweet.setBounds(139, 299, 89, 23);
		contentPane.add(btnRetweet);
		
		JButton btnFavorite = new JButton("Favorite");
		btnFavorite.setBounds(388, 299, 89, 23);
		contentPane.add(btnFavorite);
		
		JLabel lblFavoritescount = new JLabel("Favorites: "+fav);
		lblFavoritescount.setFont(new Font("Arial", Font.BOLD, 14));
		lblFavoritescount.setBounds(126, 99, 145, 23);
		contentPane.add(lblFavoritescount);
		
		JLabel lblRetweetscount = new JLabel("Retweets: "+retweets);
		lblRetweetscount.setFont(new Font("Arial", Font.BOLD, 14));
		lblRetweetscount.setBounds(367, 99, 145, 23);
		contentPane.add(lblRetweetscount);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchTwitterGUI.class.getResource("/Image/twitter2.png")));
		label_2.setBounds(520, 11, 87, 71);
		contentPane.add(label_2);
		
		setVisible(true);
	}

	/**
	 * Gets the fav.
	 *
	 * @return the fav
	 */
	public int getFav() {
		return fav;
	}

	/**
	 * Sets the fav.
	 *
	 * @param fav the new fav
	 */
	public void setFav(int fav) {
		this.fav = fav;
	}

	/**
	 * Gets the retweets.
	 *
	 * @return the retweets
	 */
	public int getRetweets() {
		return retweets;
	}

	/**
	 * Sets the retweets.
	 *
	 * @param retweets the new retweets
	 */
	public void setRetweets(int retweets) {
		this.retweets = retweets;
	}

	/**
	 * Gets the tweet.
	 *
	 * @return the tweet
	 */
	public String getTweet() {
		return tweet;
	}

	/**
	 * Sets the tweet.
	 *
	 * @param tweet the new tweet
	 */
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
}
