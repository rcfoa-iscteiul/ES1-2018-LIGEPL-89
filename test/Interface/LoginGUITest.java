package Interface;

import java.util.ArrayList;

import junit.framework.TestCase;

public class LoginGUITest extends TestCase{
	
	private LoginGUI lg;
	private ArrayList<String> login;
	
	@Override
	public void setUp(){
		lg = new LoginGUI();
		login = new ArrayList<String>();
		lg.loginClicked();
		lg.run();
	}
	
	public void testAdd(){
		ArrayList<String> test = lg.getLogin();
		assertEquals(login, test);
	}

}
