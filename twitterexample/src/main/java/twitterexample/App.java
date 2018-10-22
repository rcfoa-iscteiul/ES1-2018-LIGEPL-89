package twitterexample;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class App extends JFrame {
	

	private JTextField textField;

	private JPanel panel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox checkTwitter=new JCheckBox("Twitter");
	private JTextArea textarea= new JTextArea();
	private JButton btnNewButton = new JButton("Procurar");
	private List<Status> statuses;

	
	

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JCheckBox getCheckTwitter() {
		return checkTwitter;
	}

	public void setCheckTwitter(JCheckBox checkTwitter) {
		this.checkTwitter = checkTwitter;
	}

	public JTextArea getTextarea() {
		return textarea;
	}

	public void setTextarea(JTextArea textarea) {
		this.textarea = textarea;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App() throws TwitterException {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	.setOAuthConsumerKey("oUMmyUS7gyRAZfbRj5zYk86t9")
    	  .setOAuthConsumerSecret("wzhAtgLCdDHReB6wpdguYKFxwXmyJXDDDaSnlnLk9M15ICDNAu")
    	  .setOAuthAccessToken("1054165924197122049-yEMHGHuRzHXaHUfeBhmWEzSZ60MErb")
    	  .setOAuthAccessTokenSecret("GkMie9MJeKcPRSvpWDPZu08g3IcBRk5PsoVv9QiB9QpCs");
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();        		
        statuses = twitter.getHomeTimeline();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		setBounds(200, 200, 850, 600);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(228, 22, 237, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);

		btnNewButton = new JButton("Procurar");
		btnNewButton.setBounds(475, 25, 100, 26);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int counter=0;
				int counterTotal = 0;
				
				textarea.setText("");
				if(checkTwitter.isSelected()) {

				    for (Status status : statuses) {
						if (status.getUser().getName() != null && status.getUser().getName().contains(textField_1.getText())) {
							System.out.println("3");

							textarea.append(status.getUser().getName() + ":" + status.getText()+"\n");
							System.out.println(status.getUser().getName() + ":" + status.getText()+"\n");
							counter++;
						}
						counterTotal++;
				    }
					System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
				}
				}
				
			
		});

//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(checkTwitter.isSelected()) {
//					//textarea.setText(arg0);
//					try {
//						searchTweets();
//					} catch (TwitterException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//				
//
//			}
//		});

		JCheckBox chckbxNewCheckBox = new JCheckBox("Facebook");
		chckbxNewCheckBox.setBounds(96, 58, 97, 23);
		panel.add(chckbxNewCheckBox);

		
		checkTwitter.setBounds(264, 58, 97, 23);
		panel.add(checkTwitter);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Email");
		chckbxNewCheckBox_2.setBounds(402, 58, 97, 23);
		panel.add(chckbxNewCheckBox_2);

		
		textarea.setBounds(0, 88, 834, 440);
		panel.add(textarea);

		textField_2 = new JTextField();
		textField_2.setBounds(230, 539, 205, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("Responder");
		btnNewButton_1.setBounds(445, 539, 89, 20);
		panel.add(btnNewButton_1);
		
		String[] opcoes= {"Últimas 24h","Última hora","Últimos 30min","Últimos 15min"};
		JComboBox comboBox = new JComboBox(opcoes);
		comboBox.setBounds(595, 57, 136, 25);
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);
		
		


	}
}
