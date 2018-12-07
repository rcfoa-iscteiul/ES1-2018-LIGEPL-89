package Interface;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SendInformationGUITest extends TestCase{
	
	private SendInformationGUI sigui;
	private ArrayList<String> aux = new ArrayList<String>();
	
	@Override
	public void setUp(){
		sigui = new SendInformationGUI(aux);
	}
		
	public void testAdd(){
		assertEquals(true, sigui.getPanel().isEnabled());
	}

}
