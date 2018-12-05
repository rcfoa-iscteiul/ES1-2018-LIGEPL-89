package Interface;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.WebServiceClient;

import xpath.InfoXPath;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel label;
	private InfoXPath xpath =new InfoXPath();
	ArrayList<String> login;

	public static void main(String[] args) {
		run();
	}
	public static void run() {
		try {
			LoginGUI frame = new LoginGUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBounds(111, 113, 247, 32);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(111, 156, 247, 32);
		contentPane.add(txtPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass=new String(txtPassword.getPassword());
				login=xpath.display(txtUsername.getText(), pass);
				
				if(login.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login System", JOptionPane.ERROR_MESSAGE);

				}else {
					WelcomeGUI w=new WelcomeGUI();
					w.setUser(txtUsername.getText());
					w.constroiJanela();
					 
				}
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(126, 227, 89, 44);
		contentPane.add(btnNewButton);
		
	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginGUI.class.getResource("/Image/ohmano.png")));
		lblNewLabel.setBounds(368, 113, 58, 44);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(LoginGUI.class.getResource("/Image/lock.png")));
		label.setBounds(368, 156, 46, 32);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Bom Dia Academia Login Page");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setBackground(SystemColor.activeCaptionBorder);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(111, 43, 247, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		lblUsername.setBounds(21, 112, 91, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		lblPassword.setBounds(21, 155, 80, 32);
		contentPane.add(lblPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 210, 387, 8);
		contentPane.add(separator);
		
		JLabel lblClose = new JLabel("      X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
				
			}
		});
		lblClose.setFont(new Font("Arial", Font.PLAIN, 16));
		lblClose.setBounds(404, 11, 46, 14);
		contentPane.add(lblClose);
		setUndecorated(true);
	}
	
}
