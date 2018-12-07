package Interface;

import junit.framework.TestCase;

public class RegisterGUITest extends TestCase{
	
	private RegisterGUI rg;
	
	public void setUp(){
		rg = new RegisterGUI();
		
	}

	public void testAdd(){
		assertEquals(true, rg.getPanel().isEnabled());
	}
}
