package Interface;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SendFacebookGUITest extends TestCase{
	
	private SendFacebookGUI sfg;
	private ArrayList<String> aux = new ArrayList<String>();
	
	public void setUp(){
		sfg = new SendFacebookGUI(aux);
	}
	
	public void testAdd(){
		assertEquals(true, sfg.getPanel().isEnabled());
	}

}
