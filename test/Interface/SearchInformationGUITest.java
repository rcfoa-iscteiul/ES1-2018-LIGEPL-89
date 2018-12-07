package Interface;

import java.util.ArrayList;

import com.sun.glass.events.MouseEvent;

import junit.framework.TestCase;

public class SearchInformationGUITest extends TestCase {
	
	private SearchInformationGUI sig;
	private ArrayList<String> aux = new ArrayList<String>();
	
	@Override
	public void setUp(){
		sig = new SearchInformationGUI(aux);
	}
	
	public void testAdd(){
		assertEquals(true, sig.getPanel().isEnabled());
	}
	
	public void testAdd2(){
		MouseEvent me = new MouseEvent();
		assertNotNull(me);
	}

}
