package Interface;

import junit.framework.TestCase;

public class SearchEmailGUITest extends TestCase{
	
	private String to = new String("to");
	private String subj = new String("subj");
	private String mail = new String("mail");
	private String pass = new String("pass");
	private SearchEmailGUI seg;
	
	public void setUp(){
		seg = new SearchEmailGUI(to, subj,mail,pass);
		seg.constroiJanela();
	}

	public void testAdd(){
		assertEquals(true, seg.getPanel().isEnabled());
	}
}
