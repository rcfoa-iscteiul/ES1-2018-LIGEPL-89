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

public class SearchFacebookGUI extends JFrame {

	private JPanel contentPane;
	private int likes;
	private int shares;
	private int comments;
	private String post;

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public void constroiJanela() {
		setBounds(100, 100, 633, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(69, 11, 46, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SearchFacebookGUI.class.getResource("/Image/bomdia2.jpg")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 11, 597, 58);
		contentPane.add(label_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 127, 597, 180);
		textArea.setText(post);
		textArea.setLineWrap(true);
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(10, 127, 597, 180);
		contentPane.add(sp);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(187, 318, 242, 23);
		contentPane.add(btnClose);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchFacebookGUI.class.getResource("/Image/facebook3.png")));
		label_2.setBounds(521, 11, 64, 58);
		contentPane.add(label_2);

		JLabel lblNewLabel = new JLabel("Likes: " + likes);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(69, 93, 118, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Shares: " + shares);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(443, 93, 129, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Comments: " + comments);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(237, 93, 167, 23);
		contentPane.add(lblNewLabel_2);
		setVisible(true);
	}
}
