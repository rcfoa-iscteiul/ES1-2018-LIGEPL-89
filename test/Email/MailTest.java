package Email;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Message;
import javax.mail.MessagingException;

import Interface.Info;
import junit.framework.TestCase;

public class MailTest extends TestCase{
	
	private String combo = new String("xxx");
	private ArrayList<Info> mails;
	private String procura = new String("hhh");
	private Mail mail;
	private String maill = new String();
	private String pass = new String();
	
	@Override
	public void setUp(){
		mails = new ArrayList<Info>();
		mail = new Mail(combo, procura, maill,pass);
		mail.check();
	}
	
	public void testAdd(){
		ArrayList<Info> test = mail.getMails();
		assertEquals(mails, test);
	}
	


}
