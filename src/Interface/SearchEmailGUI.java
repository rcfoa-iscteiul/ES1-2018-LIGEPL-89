package Interface;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Email.SendMail;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchEmailGUI.
 */
public class SearchEmailGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The content. */
	private String content;
	
	/** The to. */
	private String to;
	
	/** The subj. */
	private String subj;
	
	

	
	/**
	 * Instantiates a new search email GUI.
	 *
	 * @param to the to
	 * @param subj the subj
	 * @throws HeadlessException the headless exception
	 */
	public SearchEmailGUI(String to, String subj) throws HeadlessException {
		super();
		this.to = to;
		this.subj = subj;
	}


	/**
	 * Instantiates a new search email GUI.
	 *
	 * @throws HeadlessException the headless exception
	 */
	public SearchEmailGUI() throws HeadlessException {
	}


	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
			return content;
		}




		/**
		 * Sets the content.
		 *
		 * @param content the new content
		 */
		public void setContent(String content) {
			this.content = content;
		}




	/**
	 * Constroi janela.
	 */
	public void constroiJanela() {
		setBounds(100, 100, 633, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(69, 11, 46, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SearchEmailGUI.class.getResource("/Image/bomdia2.jpg")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 11, 597, 58);
		contentPane.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 100, 597, 303);
		textArea.setText(content);
		textArea.setLineWrap(true);
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(10, 100, 597, 303);
		contentPane.add(sp);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(325, 414, 242, 23);
		contentPane.add(btnClose);
		
		JButton answerButton = new JButton("Answer");
		answerButton.setBounds(45, 414, 221, 23);
		answerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RespondEmailGUI gui=new RespondEmailGUI(to, subj);
				gui.janelaVisivel();
			}
		});
		
		contentPane.add(answerButton);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchEmailGUI.class.getResource("/Image/gmail.png")));
		label_2.setBounds(515, 11, 81, 58);
		contentPane.add(label_2);
		setVisible(true);
	}
}
