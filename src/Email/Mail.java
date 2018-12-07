/*
 * 
 */
package Email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import Interface.Info;

// TODO: Auto-generated Javadoc
/**
 * The Class Mail.
 */
public class Mail {
	
	/** The combo. */
	private String combo;
	
	/** The mails. */
	private ArrayList<Info> mails = new ArrayList<Info>();
	
	/** The procura. */
	private String procura;
	
	/** The today. */
	private Date today = new Date();
	
	/** The today 2. */
	private Date today2 = new Date(today.getYear(), today.getMonth(), today.getDay());
	
	/** The mail. */
	private String mail;
	
	/** The pass. */
	private String pass;

	/**
	 * Instantiates a new mail.
	 *
	 * @param combo the combo
	 * @param procura the procura
	 * @param mail the mail
	 * @param pass the pass
	 */
	public Mail(String combo, String procura, String mail, String pass) {
		this.combo = combo;
		this.procura = procura;
		this.mail = mail;
		this.pass = pass;
		today2.setHours(today.getHours() - 6);
	}

	/**
	 *function that receives and shows emails based on a filter
	 */
	public void check() {
		try {
			String storeType = "pop3";
			String user = mail;
			String password = pass;
			String host = "pop.gmail.com";

			if (mail.contains("iscte-iul.pt")) {
				host = "outlook.office365.com";
			}

			Properties properties = new Properties();
			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("pop3s");
			store.connect(host, user, password);
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + (messages.length - 1));

			for (int i = messages.length - 1; i > 0; i--) {
				Message message = messages[i];

				String conteudo = "";

				if (message.isMimeType("text/*")) {
					conteudo = message.getContent().toString();
				} else if (message.isMimeType("multipart/*")) {
					MimeMultipart messag = (MimeMultipart) message.getContent();
					conteudo = getTextFromMimeMultipart(messag);
				}

				if (message != null && message.getFrom()[0].toString().contains(procura)) {

					if (combo.equals("Última hora")) {
						if (message.getSentDate().getYear() == today.getYear()
								&& message.getSentDate().getMonth() == today.getMonth()
								&& message.getSentDate().getDay() == today.getDay()
										& message.getSentDate().getHours() == today.getHours()) {
							mails.add(new Info(message.getSentDate(), message.getFrom()[0].toString(),
									message.getSubject(), conteudo, -1, -1, -1, -1, "email"));

						}
					} else if (combo.equals("Últimas 6 horas")) {
						if (message.getSentDate().getYear() == today.getYear()
								&& message.getSentDate().getMonth() == today.getMonth()
								&& message.getSentDate().getDay() == today.getDay()) {
							if (message.getSentDate().before(today) && message.getSentDate().after(today2)) {
								mails.add(new Info(message.getSentDate(), message.getFrom()[0].toString(),
										message.getSubject(), conteudo, -1, -1, -1, -1, "email"));
							}
						}
					} else if (combo.equals("Últimas 24 horas")) {
						if (message.getSentDate().getYear() == today.getYear()
								&& message.getSentDate().getMonth() == today.getMonth()) {
							mails.add(new Info(message.getSentDate(), message.getFrom()[0].toString(),
									message.getSubject(), conteudo, -1, -1, -1, -1, "email"));
						}
					} else if (combo.equals("Todos")) {
						mails.add(new Info(message.getSentDate(), message.getFrom()[0].toString(), message.getSubject(),
								conteudo, -1, -1, -1, -1, "email"));
					}
				}
			}
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the text from mime multipart.
	 *
	 * @param mimeMultipart the mime multipart
	 * @return the text from mime multipart
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
		String conteudo = null;
		for (int i = 0; i < mimeMultipart.getCount(); i++) {
			BodyPart tipo = mimeMultipart.getBodyPart(i);
			if (tipo.isMimeType("text/plain")) {
				conteudo = (String) tipo.getContent();
				break;

			} else if (tipo.getContent() instanceof MimeMultipart) {
				conteudo = getTextFromMimeMultipart((MimeMultipart) tipo.getContent());
			}

			else if (tipo.isMimeType("text/html")) {
				conteudo = (String) tipo.getContent();
				break;
			}
		}

		return conteudo;
	}

	/**
	 * Gets the mails.
	 *
	 * @return the mails
	 */
	public ArrayList<Info> getMails() {
		return mails;
	}

}