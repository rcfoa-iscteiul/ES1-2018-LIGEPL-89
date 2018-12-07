package Interface;

import java.sql.Date;

import junit.framework.TestCase;

public class InfoTest extends TestCase {
	
	private Date d = new Date(3,3,3);
	private String s = new String();
	private String h = new String();
	private int x = 3;
	private int p = 13;
	private int m = 3;
	private String z = new String();
	private long u = 298743947;
	private String q = new String();
	private Info info;
	
	public void setUp(){
		info = new Info(d,s,h,z,p,m,x,u,q);
	}

}
