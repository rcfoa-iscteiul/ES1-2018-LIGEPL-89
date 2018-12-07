package Interface;

import java.util.ArrayList;

import junit.framework.TestCase;

public class WelcomeGUITest extends TestCase{
	
	private LoginGUI lg = new LoginGUI();
	private WelcomeGUI wg;
	private ArrayList<String> tokens;
	
	@Override
	public void setUp(){
		wg = new WelcomeGUI(lg);
		wg.setUser("es");
		tokens = new ArrayList<String>();
		wg.LogoutClicked();
		wg.constroiJanela();
	}
	
	public void testAdd(){
		String test = wg.getUser();
		assertEquals("es", test);
	}
	
	public void testAdd2(){
		ArrayList<String> test = wg.getTokens();
		assertEquals(tokens, test);
	}

}
