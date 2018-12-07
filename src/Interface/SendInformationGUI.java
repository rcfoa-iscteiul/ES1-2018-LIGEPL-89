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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class SendInformationGUI.
 */
public class SendInformationGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The welcome. */
	private WelcomeGUI welcome;
	
	private ArrayList<String> tokens;

 
	
	/**
	 * Instantiates a new send information GUI.
	 */
	public SendInformationGUI(ArrayList<String> tokens) {
		this.tokens=tokens;
		
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
		
		JRadioButton facebookButton = new JRadioButton("");
		facebookButton.setBounds(136, 223, 27, 23);
		contentPane.add(facebookButton);
		
		JRadioButton emailButton = new JRadioButton("");
		emailButton.setBounds(495, 223, 21, 23);
		contentPane.add(emailButton);
		
		JButton nextButton = new JButton("Next");
		nextButton.setFont(new Font("Arial", Font.BOLD, 16));
		nextButton.setBounds(233, 360, 184, 29);
		
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(twitterButton.isSelected()||facebookButton.isSelected()||emailButton.isSelected()) {
				if(twitterButton.isSelected()) {
					SendTwitterGUI gui=new SendTwitterGUI(tokens);
					gui.janelaVisivel();
				}if(facebookButton.isSelected()) {
					SendFacebookGUI gui=new SendFacebookGUI(tokens);
					gui.janelaVisivel();
				}if(emailButton.isSelected()) {
					SendEmailGUI gui=new SendEmailGUI(tokens);
					gui.janelaVisivel();
				}
				}else {
					JOptionPane.showMessageDialog(null, "Please select social etwork", "Bom Dia Academia", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		
		contentPane.add(nextButton);
		
		JLabel lblChooseWhichApplication = new JLabel("Choose which Application you want to send information");
		lblChooseWhichApplication.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblChooseWhichApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseWhichApplication.setBounds(114, 165, 450, 29);
		contentPane.add(lblChooseWhichApplication);
		
			}
	
	/**
	 * Janela visivel.
	 */
	public void janelaVisivel() {
		setVisible(true);
	}

}
