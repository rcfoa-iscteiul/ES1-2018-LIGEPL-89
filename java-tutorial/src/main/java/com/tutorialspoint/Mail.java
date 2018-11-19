package com.tutorialspoint;

import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class Mail {
	 ArrayList<String>mails=new ArrayList<String>();
	 
	 
   public void check() throws NoSuchProviderException 
   {
	   String host1 = "pop.outlook.com";
	      String mailStoreType = "pop3";
	      String username = "fmsml@iscte-iul.pt";
	      String password1 = "Benficas15";
	     
	      
      try {

      Properties properties = new Properties();

      properties.put("mail.pop3.host", host1);
      properties.put("mail.pop3.port", "995");
      properties.put("mail.pop3.starttls.enable", "true");
      Session emailSession = Session.getDefaultInstance(properties);
  
      Store store = emailSession.getStore("pop3s");

      store.connect(host1, username, password1);

      Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_ONLY);

      Message[] messages = emailFolder.getMessages();

      for (int i = 0, n = messages.length; i < 10; i++) {
         Message message = messages[i];
         System.out.println("---------------------------------");
         System.out.println("Email Number " + (i + 1));
         System.out.println("Subject: " + message.getSubject());
         System.out.println("From: " + message.getFrom()[0]);
         System.out.println("Text: " + message.getContent().toString());
         mails.add(message.getSubject()+"-"+message.getFrom()[0]+"-"+message.getContentType().toString());

      }
      

      emailFolder.close(false);
      store.close();

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
