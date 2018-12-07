package Interface;

import junit.framework.TestCase;

public class SearchFacebookGUITest extends TestCase{
	
	private SearchFacebookGUI sfg;
	
	@Override
	public void setUp(){
		sfg = new SearchFacebookGUI();
		sfg.constroiJanela();
	}
	
	public void testAdd(){
		assertEquals(true, sfg.getPanel().isEnabled());
	}

}
