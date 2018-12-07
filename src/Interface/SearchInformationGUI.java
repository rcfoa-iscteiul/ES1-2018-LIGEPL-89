package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Email.Mail;
import Facebook.Facebook;
import Twitter.TwitterES;
import xpath.InfoXPath;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class SearchInformationGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Facebook f;
	private TwitterES t;
	private Mail m;
	private JRadioButton twitterButton = new JRadioButton("");
	private JRadioButton facebookButton = new JRadioButton("");
	private JRadioButton emailButton = new JRadioButton("");
	private JList<Info> jlist;
	private DefaultListModel<Info> model = new DefaultListModel<>();

	public SearchInformationGUI() {
		System.out.println(InfoXPath.getInstance().getTokens());
		setBounds(100, 100, 852, 624);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(SearchInformationGUI.class.getResource("/Image/bomdia2.jpg")));
		label.setBounds(10, 24, 816, 54);
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

		twitterButton.setBounds(683, 342, 27, 23);
		contentPane.add(twitterButton);

		facebookButton.setBounds(683, 465, 27, 23);
		contentPane.add(facebookButton);

		emailButton.setBounds(683, 218, 21, 23);
		contentPane.add(emailButton);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u00DAltima hora", "\u00DAltimas 6 horas", "\u00DAltimas 24 horas" }));
		comboBox.setBounds(574, 123, 100, 20);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Search\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();

				if (twitterButton.isSelected()) {
					t = new TwitterES(textField.getText(), comboBox.getSelectedItem().toString());

					for (Info s : t.getTweets()) {
						model.addElement(s);
					}
				}

				else if (facebookButton.isSelected()) {
					f = new Facebook(textField.getText(), comboBox.getSelectedItem().toString());

					for (Info s : f.getPosts()) {
						model.addElement(s);
					}

				}

				else if (emailButton.isSelected()) {
					m = new Mail(comboBox.getSelectedItem().toString(), textField.getText());
					m.check();

					for (Info mails : m.getMails()) {
						model.addElement(mails);
					}

				}

			}

		});

		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(318, 545, 212, 29);
		contentPane.add(btnNewButton);

		jlist = new JList<>(model);
		jlist.setBounds(49, 170, 612, 348);
		JScrollPane sp = new JScrollPane(jlist);
		sp.setBounds(49, 170, 612, 348);
		contentPane.add(sp);

		jlist.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Info clicked = jlist.getSelectedValue();
				System.out.println(clicked);
				if (clicked != null) {
					if (clicked.getRedeSocial().equals("twitter")) {
						SearchTwitterGUI tgui = new SearchTwitterGUI();
						tgui.setFav(clicked.getLikes());
						tgui.setRetweets(clicked.getShares());
						tgui.setTweet("DATE: " + clicked.getDate() + "\n" + "FROM: " + clicked.getFrom() + "\n" + "\n"
								+ "TWEET: " + clicked.getContent());
						tgui.constroiJanela();
					}
				}
				if (clicked.getRedeSocial().equals("email")) {
					SearchEmailGUI tgui = new SearchEmailGUI(clicked.getFrom(),clicked.getContent());
					tgui.setContent("DATE: " + clicked.getDate() + "\n" + "FROM: " + clicked.getFrom() + "\n" + "\n"
							+ "Mail: " +"POR FAZER");
					tgui.constroiJanela();

				}
				if (clicked.getRedeSocial().equals("facebook")) {
					SearchFacebookGUI tgui = new SearchFacebookGUI();
					tgui.setLikes(clicked.getLikes());
					tgui.setShares(clicked.getShares());
					tgui.setComments(clicked.getComments());
					tgui.setPost("DATE: " + clicked.getDate() + "\n" + "\n" + "POST: " + clicked.getContent());
					tgui.constroiJanela();

				}

			}
		});

	}
	
	
	public void janelaVisivel() {
		setVisible(true);
	}
}