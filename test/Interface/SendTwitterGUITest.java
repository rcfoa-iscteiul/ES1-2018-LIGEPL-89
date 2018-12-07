package Interface;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SendTwitterGUITest extends TestCase{
	
	private SendTwitterGUI stg;
	private ArrayList<String> aux = new ArrayList<String>();
	
	public void setUp(){
		stg = new SendTwitterGUI(aux);
	}

	public void testAdd(){
		assertEquals(true, stg.getPanel().isEnabled());
	}
}