package Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

/**
 * The Class WelcomeGUI.
 */
public class WelcomeGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The logingui. */
	private LoginGUI logingui;

	/** The user. */
	private String user;

	/** The tokens. */
	private ArrayList<String> tokens;

	/**
	 * Launch the application.
	 *
	 * @param logingui the logingui
	 * @throws HeadlessException the headless exception
	 */

	public WelcomeGUI(LoginGUI logingui) throws HeadlessException {
		this.logingui = logingui;
		tokens = logingui.getLogin();
	}

	/**
	 * Create the frame.
	 */
	public void constroiJanela() {

		setBounds(100, 100, 520, 344);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome " + user + "!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		lblWelcome.setBounds(25, 138, 452, 52);
		contentPane.add(lblWelcome);

		JButton btnNewButton = new JButton("Search Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchInformationGUI gui = new SearchInformationGUI(logingui.getLogin());
				gui.janelaVisivel();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(25, 230, 144, 45);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Send Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendInformationGUI gui = new SendInformationGUI(logingui.getLogin());
				gui.janelaVisivel();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(179, 230, 144, 45);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LogoutClicked();

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

	/**
	 * Action when Client presses Logout button.
	 */
	public void LogoutClicked() {
		logingui.dispose();
		dispose();
		LoginGUI login1 = new LoginGUI();
		login1.run();
	}

	/**
	 * Gets the tokens.
	 *
	 * @return the tokens
	 */
	public ArrayList<String> getTokens() {
		return tokens;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}
}
