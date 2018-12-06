package Email;

import java.util.ArrayList;
import java.util.Date;
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
	private ArrayList<String> mails = new ArrayList<String>();
	private Message message;
	private String procura;
	Date today = new Date();
	
	Date today2 = new Date(today.getYear(), today.getMonth(), today.getHours());

	public Mail(String combo, String procura) {
		this.combo = combo;
		this.procura=procura;
		today2.setHours(today.getHours()-6);
	}

	public void check() {
		try {
			String host = "pop.gmail.com";
			String storeType="pop3";
			String user= "bomdiaacademiaiscte@gmail.com";// change accordingly
			String password = "caninas6969";
			
			
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
				
				if(message !=null && message.getFrom()[0].toString().contains(procura) ) {
				
					if(combo.equals("Última hora")) {
						if(message.getSentDate().getYear()== today.getYear() && message.getSentDate().getMonth()== today.getMonth() && message.getSentDate().getDay()== today.getDay() & message.getSentDate().getHours()== today.getHours()   ) {
							mails.add(message.getSentDate()+"	"+message.getFrom()[0].toString()+"	"+message.getSubject());
				
						}
			}else if(combo.equals("Últimas 6 horas")) {
				if(message.getSentDate().getYear()== today.getYear() && message.getSentDate().getMonth()== today.getMonth() && message.getSentDate().getDay()== today.getDay() ) {
					if(message.getSentDate().before(today) && message.getSentDate().after(today2)) {
						mails.add(message.getSentDate()+"	"+message.getFrom()[0].toString()+"	"+message.getSubject());
					}
				}
			}else if(combo.equals("Últimas 24 horas")) {
				if(message.getSentDate().getYear()== today.getYear() && message.getSentDate().getMonth()== today.getMonth()) {
					mails.add(message.getSentDate()+"	"+message.getFrom()[0].toString()+"	"+message.getSubject());
				}
			}
				}}
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
	
	
	public ArrayList<String> getMails() {
		return mails;
	}



}