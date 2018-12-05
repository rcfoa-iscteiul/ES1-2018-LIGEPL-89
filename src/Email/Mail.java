package Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class Mail {
	private String combo;
	private List<String> mails = new ArrayList<String>();
	private Message message;

	public Mail(String combo) {
		this.combo = combo;
	}

	public void check(String host, String storeType, String user, String password) {
		try {

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + (messages.length - 1));

			for (int i = messages.length - 1; i > 0; i--) {
				message = messages[i];

				mails.add(message.getSubject()+"-"+message.getFrom()[0].toString() + "-" + message.getSentDate());
				// mails.add(message.getContent().toString());
				System.out.println(mails);
				// System.out.println(mails.size());

			}

			// close the store and folder objects
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

	public static void main(String[] args) {

		String host = "pop.gmail.com";// change accordingly
		String mailStoreType = "pop3";
		String username = "bomdiaacademiaiscte@gmail.com";// change accordingly
		String password = "caninas6969";// change accordingly

		Mail a = new Mail("Este dia");

		a.check(host, mailStoreType, username, password);

	}

}