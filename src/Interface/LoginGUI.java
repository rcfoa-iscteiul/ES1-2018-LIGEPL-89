package Interface;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import xpath.InfoXPath;

/**
 * The Class LoginGUI.
 */
public class LoginGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The txt username. */
	private JTextField txtUsername;

	/** The txt password. */
	private JPasswordField txtPassword;

	/** The login. */
	private ArrayList<String> login = InfoXPath.getInstance().getTokens();

	/** The w. */
	private WelcomeGUI w = new WelcomeGUI(this);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LoginGUI login = new LoginGUI();
		login.run();
	}

	/**
	 * Run.
	 */
	public void run() {
		try {
			LoginGUI frame = new LoginGUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {

		setBounds(100, 100, 516, 338);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(LoginGUI.class.getResource("/Image/bomdia2.jpg")));
		label.setBounds(10, 33, 480, 55);
		contentPane.add(label);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsername.setBounds(72, 127, 83, 31);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(72, 182, 83, 31);
		contentPane.add(lblPassword);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(320, 236, 89, 31);
		contentPane.add(btnClose);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUsername.setBounds(155, 129, 234, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPassword.setBounds(155, 184, 234, 26);
		contentPane.add(txtPassword);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginClicked();
			}
		});
		btnNewButton.setBounds(85, 236, 89, 31);
		contentPane.add(btnNewButton);
	}

	/**
	 * Action performed when client presses the login button.
	 */
	public void loginClicked() {
		String pass = new String(txtPassword.getPassword());
		login = InfoXPath.getInstance().display(txtUsername.getText(), pass);

		if (login.isEmpty() || txtUsername.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login System", JOptionPane.ERROR_MESSAGE);

		} else {
			w.setUser(txtUsername.getText());
			w.constroiJanela();
			dispose();

		}

	}

	/**
	 * Gets the login list.
	 *
	 * @return the login list.
	 */
	public ArrayList<String> getLogin() {
		return login;
	}

}
