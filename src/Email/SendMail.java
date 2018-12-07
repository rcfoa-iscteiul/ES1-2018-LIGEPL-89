package Email;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendMail {

   private final String senderEmailID = "bomdiaacademiaiscte@gmail.com";
   private final String senderPassword = "caninas6969";
   private final String emailSMTPserver = "smtp.gmail.com";
   private final String emailServerPort = "465";
   private String receiverEmailID = null;
   private static String emailSubject = "Test Mail";
   private static String emailBody = ":)";
   private Properties props= new Properties();
   
   
  public SendMail(){
  props.put("mail.smtp.user",senderEmailID);
  props.put("mail.smtp.host", emailSMTPserver);
  props.put("mail.smtp.port", emailServerPort);
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.socketFactory.port", emailServerPort);
  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.socketFactory.fallback", "false");
  SecurityManager security = System.getSecurityManager();
  
  }
  
  public void send(String receiverEmailID,String subject, String body) {
	  try{  
		  Authenticator auth = new SMTPAuthenticator();
		  Session session = Session.getInstance(props, auth);
		  MimeMessage msg = new MimeMessage(session);
		  msg.setText(body);
		  msg.setSubject(subject);
		  msg.setFrom(new InternetAddress(senderEmailID));
		  msg.addRecipient(Message.RecipientType.TO,
		  new InternetAddress(receiverEmailID));
		  Transport.send(msg);
		  System.out.println("Message send Successfully:)"); 
		  
		  }catch (Exception mex){
		  mex.printStackTrace();
		  }
  }
  
  
  public class SMTPAuthenticator extends javax.mail.Authenticator
  {
  public PasswordAuthentication getPasswordAuthentication()
  {
  return new PasswordAuthentication(senderEmailID, senderPassword);
  }
  }
  

     }