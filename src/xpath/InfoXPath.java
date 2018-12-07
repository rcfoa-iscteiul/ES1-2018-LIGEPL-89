/*
 * 
 */
package xpath;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import Interface.Info;
import jdk.nashorn.internal.ir.CatchNode;

import javax.xml.xpath.*;

// TODO: Auto-generated Javadoc
/**
 * The Class InfoXPath.
 */
public class InfoXPath {
	
	/** The Constant INSTANCE. */
	private static final InfoXPath INSTANCE = new InfoXPath();
	
	/** The tokens. */
	private ArrayList<String> tokens = new ArrayList<String>();
	
	/** The off face. */
	private ArrayList<String> offFace = new ArrayList<>();
	
	/** The off twitter. */
	private ArrayList<String> offTwitter = new ArrayList<>();
	
	/** The off email. */
	private ArrayList<String> offEmail = new ArrayList<>();
	
	/** The d. */
	private Document d;
	
	/** The xp. */
	private XPath xp;

	/**
	 * Instantiates a new info X path.
	 */
	private InfoXPath() {

	}

	/**
	 * Gets the single instance of InfoXPath.
	 *
	 * @return single instance of InfoXPath
	 */
	public static InfoXPath getInstance() {
		return INSTANCE;
	}

	/**
	 * add the information on a xml file
	 *
	 * @param user the user
	 * @param pass the pass
	 * @return the array list
	 */
	public ArrayList<String> display(String user, String pass) {
		ArrayList<String> tokens = new ArrayList<>();
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			d = db.parse("src\\config\\config.xml");
			xp = XPathFactory.newInstance().newXPath();
			NodeList nl = (NodeList) xp.compile("//info").evaluate(d, XPathConstants.NODESET);

			for (int i = 0; i < nl.getLength(); i++) {
				if (user.equals(xp.compile("./user").evaluate(nl.item(i)).toString())) {
					if (pass.equals(xp.compile("./password").evaluate(nl.item(i)).toString())) {
						tokens.add(xp.compile("./email").evaluate(nl.item(i)).toString());
						tokens.add(xp.compile("./emailpassword").evaluate(nl.item(i)).toString());
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

	/**
	 * Sets the offline.
	 *
	 * @param face the face
	 * @param twitter the twitter
	 * @param email the email
	 */
	public void setOffline(String face, String twitter, String email) {
		Element newElement1 = d.createElement("Offline");
		newElement1.setAttribute("offlineface", face);
		newElement1.setAttribute("offlinetwitter", twitter);
		newElement1.setAttribute("offlinemail", email);
	}

	/**
	 * Gets the offline.
	 *
	 * @return the offline
	 * @throws XPathExpressionException the x path expression exception
	 */
	public void getOffline() throws XPathExpressionException {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse("src\\config\\config.xml");
			xp = XPathFactory.newInstance().newXPath();

			NodeList nl = (NodeList) xp.compile("//Offline").evaluate(d, XPathConstants.NODESET);
			for (int i = 0; i < nl.getLength(); i++) {
				offFace.add(xp.compile("./offlineface").evaluate(nl.item(i)).toString());
				offTwitter.add(xp.compile("./offlinetwitter").evaluate(nl.item(i)).toString());
				offEmail.add(xp.compile("./offlineemail").evaluate(nl.item(i)).toString());

			}

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
			DOMSource source = new DOMSource(d);
			transformer.transform(source, result);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * Gets the off face.
	 *
	 * @return the off face
	 */
	public ArrayList<String> getOffFace() {
		return offFace;
	}

	/**
	 * Gets the off twitter.
	 *
	 * @return the off twitter
	 */
	public ArrayList<String> getOffTwitter() {
		return offTwitter;
	}

	/**
	 * Gets the off email.
	 *
	 * @return the off email
	 */
	public ArrayList<String> getOffEmail() {
		return offEmail;
	}

	/**
	 * Gets the tokens.
	 *
	 * @return the tokens
	 */
	public ArrayList<String> getTokens() {
		return tokens;
	}

}
