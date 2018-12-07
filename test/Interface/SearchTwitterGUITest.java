package Interface;

import Twitter.TwitterES;
import junit.framework.TestCase;

public class SearchTwitterGUITest extends TestCase{
	
	private int fav = 3;
	private SearchTwitterGUI stg;
	String s = new String();
	String z = new String();
	String x = new String();
	String y = new String();
	String i = new String();
	String q = new String();
	private TwitterES tw = new TwitterES(s,z,x,y,i,q);
	
	@Override
	public void setUp(){
		stg = new SearchTwitterGUI(tw);
		stg.setFav(fav);
		stg.constroiJanela();
	}
	
	public void testAdd(){
		int test = stg.getFav();
		assertEquals(3, test);
	}

}
