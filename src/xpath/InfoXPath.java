package xpath;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;

public class InfoXPath {
	  ArrayList<String> user=new ArrayList<String>();
	  

	public  ArrayList<String> display(String user, String pass) {
		ArrayList<String> tokens=new ArrayList<>();
		try {

			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document d=db.parse("src\\config\\config.xml");
			XPath xp=XPathFactory.newInstance().newXPath();
			NodeList nl=(NodeList)xp.compile("//info").evaluate(d, XPathConstants.NODESET);
			
			
			for (int i = 0; i < nl.getLength(); i++) {
				if(user.equals(xp.compile("./user").evaluate(nl.item(i)).toString())) {
					if(pass.equals(xp.compile("./password").evaluate(nl.item(i)).toString())) {
						tokens.add(xp.compile("./email").evaluate(nl.item(i)).toString());
						tokens.add(xp.compile("./consumerkey").evaluate(nl.item(i)).toString());
						tokens.add(xp.compile("./consumersecret").evaluate(nl.item(i)).toString());
						tokens.add(xp.compile("./accesstoken").evaluate(nl.item(i)).toString());
						tokens.add(xp.compile("./tokensecret").evaluate(nl.item(i)).toString());
						tokens.add(xp.compile("./postsfacebook").evaluate(nl.item(i)).toString());
						tokens.add(xp.compile("./respondepostsfacebook").evaluate(nl.item(i)).toString());
					}
				}
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(tokens);
		return tokens;
	}
	

	

}
