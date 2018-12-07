/*
 * 
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterGUI.
 */
public class RegisterGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The txt email. */
	private JTextField txtEmail;
	
	/** The txt username. */
	private JTextField txtUsername;
	
	/** The txt password. */
	private JPasswordField txtPassword;
	
	/** The txt repeat password. */
	private JPasswordField txtRepeatPassword;
	
	/** The registos. */
	private HashMap<String, String> registos = new HashMap<String, String>();
	
	/** The text field. */
	private JTextField textField;
	
	/** The text field 1. */
	private JTextField textField_1;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The text field 3. */
	private JTextField textField_3;
	
	/** The text field 4. */
	private JTextField textField_4;
	
	/** The text field 5. */
	private JTextField textField_5;
	
	/** The text field 6. */
	private JTextField textField_6;
	
	/** The txt email password. */
	private JPasswordField txtEmailPassword;
	

	
	/**
	 * Gets the panel.
	 *
	 * @return the panel
	 */
	public JPanel getPanel(){
		return contentPane;
	}
	
	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
			run();
			
	
	}


/**
 * Run.
 */
public static void run() {
	try {
		RegisterGUI frame = new RegisterGUI();
		
		frame.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	/**
	 * Create the frame.
	 */
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 593);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		registos.put("user", "user");
		
		JButton btnRegister = new JButton("Register");
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = txtUsername.getText();
				String password = new String (txtPassword.getPassword());
				String repeatpassword = new String (txtRepeatPassword.getPassword());
				
				System.out.println(registos.toString());
				
				for(String entrada : registos.keySet()) {
				if(!username.equals("") && !password.equals("")){
					if(password.equals(repeatpassword)) {
						if(!entrada.equals(username)) {
							registos.put(username, password);
							System.out.println(registos.toString());
					}else {
					JOptionPane.showMessageDialog(null, "Username already Registed!", "Register Failed", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
					
				}
						
		}else {
			JOptionPane.showMessageDialog(null, "Passwords does not Match!", "Register Failed", JOptionPane.ERROR_MESSAGE);
			txtPassword.setText(null);
			txtUsername.setText(null);
			
		}
				
			}else {
				JOptionPane.showMessageDialog(null, "Your must fill the fields!", "Register Failed", JOptionPane.ERROR_MESSAGE);
				txtPassword.setText(null);
				txtUsername.setText(null);
			}
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setBounds(144, 504, 100, 23);
		contentPane.add(btnRegister);
		
		JButton btnCancelRegistration = new JButton("Cancel Registration");
		btnCancelRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmLoginSystem = new JFrame("Close");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Your really want to cancel registration?", "Login System", JOptionPane.YES_NO_OPTION)
						== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnCancelRegistration.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelRegistration.setBounds(358, 504, 155, 23);
		contentPane.add(btnCancelRegistration);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(120, 332, 182, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(120, 146, 182, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUsername.setBounds(120, 121, 58, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPassword.setBounds(120, 180, 56, 20);
		contentPane.add(lblPassword);
		
		JLabel lblRepassword = new JLabel("Repeat Password");
		lblRepassword.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRepassword.setBounds(120, 239, 124, 20);
		contentPane.add(lblRepassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmail.setBounds(120, 304, 59, 20);
		contentPane.add(lblEmail);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(120, 208, 182, 20);
		contentPane.add(txtPassword);
		
		txtRepeatPassword = new JPasswordField();
		txtRepeatPassword.setBounds(120, 270, 182, 20);
		contentPane.add(txtRepeatPassword);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(RegisterGUI.class.getResource("/Image/bomdia2.jpg")));
		label.setBounds(10, 11, 643, 68);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(351, 146, 249, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(351, 208, 249, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(351, 270, 249, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(351, 332, 249, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(351, 395, 249, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(351, 451, 249, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(120, 451, 182, 20);
		contentPane.add(textField_6);
		
		JLabel lblTwitterConsumerKey = new JLabel("Email Password");
		lblTwitterConsumerKey.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTwitterConsumerKey.setBounds(120, 370, 182, 14);
		contentPane.add(lblTwitterConsumerKey);
		
		JLabel lblTwitterConsumerSecret = new JLabel("Twitter Consumer Secret:");
		lblTwitterConsumerSecret.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTwitterConsumerSecret.setBounds(351, 124, 249, 14);
		contentPane.add(lblTwitterConsumerSecret);
		
		JLabel lblTwitterAccessToken = new JLabel("Twitter Access Token:\r\n");
		lblTwitterAccessToken.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTwitterAccessToken.setBounds(351, 183, 249, 14);
		contentPane.add(lblTwitterAccessToken);
		
		JLabel lblTwitterAccessToken_1 = new JLabel("Twitter Access Token Secret:");
		lblTwitterAccessToken_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTwitterAccessToken_1.setBounds(351, 245, 249, 14);
		contentPane.add(lblTwitterAccessToken_1);
		
		JLabel lblFacebookUserAccess = new JLabel("Facebook User Access Token:");
		lblFacebookUserAccess.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFacebookUserAccess.setBounds(351, 307, 249, 14);
		contentPane.add(lblFacebookUserAccess);
		
		JLabel lblFacebookPageAccess = new JLabel("Facebook Page Access Token:");
		lblFacebookPageAccess.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFacebookPageAccess.setBounds(351, 370, 249, 14);
		contentPane.add(lblFacebookPageAccess);
		
		JLabel lblFacebookUserAccess_1 = new JLabel("Facebook User Access Token:\r\n");
		lblFacebookUserAccess_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFacebookUserAccess_1.setBounds(351, 426, 249, 14);
		contentPane.add(lblFacebookUserAccess_1);
		
		JLabel lblTwitterConsumerKey_1 = new JLabel("Twitter Consumer Key:");
		lblTwitterConsumerKey_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTwitterConsumerKey_1.setBounds(120, 426, 182, 14);
		contentPane.add(lblTwitterConsumerKey_1);
		
		txtEmailPassword = new JPasswordField();
		txtEmailPassword.setBounds(120, 395, 182, 20);
		contentPane.add(txtEmailPassword);
	}

	/**
	 * Gets the registos.
	 *
	 * @return the registos
	 */
	public HashMap<String, String> getRegistos() {
		return registos;
	}
}
