package Twitter;

import java.util.ArrayList;

import Interface.Info;
import junit.framework.TestCase;

public class TwitterTest extends TestCase{
	
	private String procura = new String("procura");
	private String combo = new String("combo");
	private String m = new String("combo");
	private String c = new String("combo");
	private String k = new String("combo");
	private String i = new String("combo");

	private TwitterES tw;
	
	@Override
	public void setUp(){
		tw = new TwitterES(procura, combo,m,c,k,i);
	}
	
	public void testAdd(){
		String test = tw.getProcura();
		assertEquals("procura", test);
	}
}
