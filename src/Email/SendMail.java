/*
 * 
 */
package Email;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class SendMail.
 */
public class SendMail {
	
	/** The mail. */
	private String mail;
	
	/** The pass. */
	private String pass;

	/**
	 * Instantiates a new send mail.
	 *
	 * @param mail the mail
	 * @param pass the pass
	 */
	public SendMail(String mail, String pass) {
		this.mail = mail;
		this.pass = pass;
	}

	/**
	 * function that sends the emails to a certain destination
	 * @param mailDestino the mail destino
	 * @param sub the sub
	 * @param message the message
	 */
	public void send(String mailDestino, String sub, String message) {
		String senderEmail = mail;
		String password = pass;
		String host = "smtp.gmail.com";

		if (host.contains("iscte-iul.pt")) {
			host = "smtp.office365.com";
		}

		Properties propvls = new Properties();
		propvls.put("mail.smtp.auth", "true");
		propvls.put("mail.smtp.starttls.enable", "true");
		propvls.put("mail.smtp.host", host);
		propvls.put("mail.smtp.port", "587");

		Session sessionobj = Session.getInstance(propvls, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, password);
			}
		});

		try {
			Message messageobj = new MimeMessage(sessionobj);
			messageobj.setFrom(new InternetAddress(senderEmail));
			messageobj.setSubject(sub);
			messageobj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailDestino));
			messageobj.setText(message);
			Transport.send(messageobj);
			JOptionPane.showMessageDialog(null, "Email send!");

		} catch (MessagingException exp) {
			JOptionPane.showMessageDialog(null, "Bom Dia Academia", "Email NOT send!", JOptionPane.ERROR_MESSAGE);

			throw new RuntimeException(exp);
		}
	}

}