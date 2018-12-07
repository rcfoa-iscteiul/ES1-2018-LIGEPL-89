package Facebook;

import junit.framework.TestCase;

public class FacebookTest extends TestCase{
	
	private String p = new String();
	private String c = new String();
	private String t = new String();
	private Facebook face;
	
	public void setUp(){
		face = new Facebook(p,c,t);
	}
	
	public void testAdd(){
		assertNotNull(face);
	}
}
