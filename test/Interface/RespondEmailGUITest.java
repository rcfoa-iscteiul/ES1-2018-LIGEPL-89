package Interface;

import junit.framework.TestCase;

public class RespondEmailGUITest extends TestCase{
	
	private String to = new String("to");
	private String subj = new String("subj");
	private String mail = new String("mail");
	private String pass = new String("pass");
	private RespondEmailGUI reg;
	
	@Override
	public void setUp(){
		reg = new RespondEmailGUI(to, subj, mail, pass);
	}
	
	public void testAdd(){
		assertEquals(true, reg.getPanel().isEnabled());
	}

}
