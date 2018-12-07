package Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Email.SendMail;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class RespondEmailGUI.
 */
public class RespondEmailGUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The to. */
	private String to;

	/** The subj. */
	private String subj;
	
	public JPanel getPanel(){
		return contentPane;
	}

	/**
	 * Instantiates a new respond email GUI.
	 *
	 * @param to   the to
	 * @param subj the subj
	 */
	public RespondEmailGUI(String to, String subj, String mail, String pass) {
		this.subj = subj;
		this.to = to;

		setBounds(100, 100, 602, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RespondEmailGUI.class.getResource("/Image/bomdia2.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 566, 62);
		contentPane.add(lblNewLabel);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(33, 265, 521, 216);
		contentPane.add(textPane);

		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Arial", Font.BOLD, 14));
		lblSubject.setBounds(33, 198, 78, 43);
		contentPane.add(lblSubject);

		JLabel lblPleaseWriteThe = new JLabel("Please write the email you want to send:");
		lblPleaseWriteThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWriteThe.setFont(new Font("Arial", Font.BOLD, 14));
		lblPleaseWriteThe.setBounds(33, 97, 521, 23);
		contentPane.add(lblPleaseWriteThe);

		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTo.setBounds(61, 150, 62, 43);
		contentPane.add(lblTo);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RespondEmailGUI.class.getResource("/Image/gmail.png")));
		label.setBounds(489, 11, 87, 62);
		contentPane.add(label);

		JLabel lblto = new JLabel(to);
		lblto.setBounds(133, 165, 421, 14);
		contentPane.add(lblto);

		JLabel lblsub = new JLabel("RS:" + subj);
		lblsub.setBounds(133, 213, 421, 14);
		contentPane.add(lblsub);

		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSend.setBounds(183, 492, 230, 23);
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SendMail sm = new SendMail(mail, pass);
				sm.send(to, "RS: " + subj, textPane.getText());
			}
		});
		contentPane.add(btnSend);

	}

	/**
	 * Janela visivel.
	 */
	public void janelaVisivel() {
		setVisible(true);
	}
}
