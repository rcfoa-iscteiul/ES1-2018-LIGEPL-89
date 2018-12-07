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

public class InfoXPath {
	private static final InfoXPath INSTANCE = new InfoXPath();
	private ArrayList<String> tokens = new ArrayList<String>();
	private ArrayList<String> offFace = new ArrayList<>();
	private ArrayList<String> offTwitter = new ArrayList<>();
	private ArrayList<String> offEmail = new ArrayList<>();
	private Document d;
	private XPath xp;

	private InfoXPath() {

	}

	public static InfoXPath getInstance() {
		return INSTANCE;
	}

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

	public void setOffline(String face, String twitter, String email) {
		Element newElement1 = d.createElement("Offline");
		newElement1.setAttribute("offlineface", face);
		newElement1.setAttribute("offlinetwitter", twitter);
		newElement1.setAttribute("offlinemail", email);
	}

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

	public ArrayList<String> getOffFace() {
		return offFace;
	}

	public ArrayList<String> getOffTwitter() {
		return offTwitter;
	}

	public ArrayList<String> getOffEmail() {
		return offEmail;
	}

	public ArrayList<String> getTokens() {
		return tokens;
	}

}
