package Interface;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SendEmailGUITest extends TestCase{
	
	private SendEmailGUI seg;
	private ArrayList<String> aux = new ArrayList<String>();
	
	public void  setUp(){
		seg = new SendEmailGUI(aux);
	}
	
	public void testAdd(){
		assertEquals(true, seg.getPanel().isEnabled());
	}

}
