package com.tutorialspoint;

import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

/**
 * @author ES2018
 * 
 *         
 *
 */

public class Mail {
	 ArrayList<String>mails=new ArrayList<String>();
	 String procura;
	 
	 /**
		 * Construtor da classe
		 * 
		 * @param  procura no qual podemos selcionar um filtro para especificar o nosso output
		 * 
		 */
	 public Mail(String procura) {
		 this.procura=procura;
	 }
	 
	 
	
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
         
         if(message.getSubject().contains(procura) || message.getFrom()[0].toString().contains(procura) ||message.getContentType().toString().contains(procura)) {
         mails.add(message.getSubject()+"-"+message.getFrom()[0]+"-"+message.getContentType().toString());
         }
         
      }
      

      emailFolder.close(false);
      store.close();

      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
	 * Função que retorna a lista com todos os emails conforme o filtro selecionado
	 * 
	 * 
	 * @return retorna a ArrayList com todos os emails.
	 */
 
   public ArrayList<String> getMails() {
 		return mails;
 	}

}
