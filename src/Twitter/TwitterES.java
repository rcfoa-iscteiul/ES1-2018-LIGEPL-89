package Twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Interface.Info;

public class TwitterES {
	private String procura;
	private List<Status> statuses;
	private ArrayList<Info> tweets = new ArrayList<Info>();
	private Date today = new Date();
	private Date today2 = new Date(today.getYear(), today.getMonth(), today.getHours());
	private Twitter twitter;
	
	public String getProcura(){
		return procura;
	}

	/**
	 * Construtor que estabelece as ligações com os access token key e introduz
	 * todos os tweets numa lista que será posteriormente exibida
	 * 
	 * @param procura no qual podemos selcionar um filtro para especificar o nosso
	 *                output
	 * 
	 */

	public TwitterES(String procura, String combo, String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
		this.procura = procura;
		today2.setHours(today.getHours()-6);
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
					.setOAuthConsumerSecret(consumerSecret)
					.setOAuthAccessToken(accessToken)
					.setOAuthAccessTokenSecret(tokenSecret);
			TwitterFactory tf = new TwitterFactory(cb.build());
			 twitter = tf.getInstance();
			
			

			statuses = twitter.getHomeTimeline();
	
			
			
			for (Status status : statuses) {
				
				if (status.getUser().getName() != null   && status.getUser().getName().contains(procura)) {
					String tweet = status.getCreatedAt() + "-" + status.getUser().getName() + "-" + status.getText();
					

					if (combo.equals("Última hora")) {
						if (today.getHours()==status.getCreatedAt().getHours() && today.getDay()== status.getCreatedAt().getDay() && today.getMonth() == status.getCreatedAt().getMonth() && today.getYear() == status.getCreatedAt().getYear() ) {
							tweets.add(new Info(status.getCreatedAt(),status.getUser().getName(),null,status.getText(),status.getFavoriteCount(),status.getRetweetCount(),-1,status.getId(),"twitter"));
						}
					} else if (combo.equals("Últimas 6 horas")) {
						if (today.getYear() == status.getCreatedAt().getYear() && today.getMonth() == status.getCreatedAt().getMonth() && today.getDay()== status.getCreatedAt().getDay()) {
							if(status.getCreatedAt().before(today) && status.getCreatedAt().after(today2)) {
								tweets.add(new Info(status.getCreatedAt(),status.getUser().getName(),null,status.getText(),status.getFavoriteCount(),status.getRetweetCount(),-1,status.getId(),"twitter"));
							
						}}
					} else if (combo.equals("Últimas 24 horas")) {
						if (today.getYear() == status.getCreatedAt().getYear() && today.getMonth() == status.getCreatedAt().getMonth() && today.getDay() == status.getCreatedAt().getDay()) {
							tweets.add(new Info(status.getCreatedAt(),status.getUser().getName(),null,status.getText(),status.getFavoriteCount(),status.getRetweetCount(),-1,status.getId(),"twitter"));
						}
					}

		}

			}
			

		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	public void retweet(long id) {
	    try {
			twitter.retweetStatus(id);
			JOptionPane.showMessageDialog(null, "Retweeted!");

		} catch (TwitterException e) {
			JOptionPane.showMessageDialog(null, "Bom Dia Academia", "NOT retweeted!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Função que retorna a lista com todos os tweets conforme o filtro selecionado
	 * 
	 * 
	 * @return retorna a ArrayList com todos os tweets.
	 */
	public ArrayList<Info> getTweets() {
		return tweets;
	}

	public void setTweets(ArrayList<Info> tweets) {
		this.tweets = tweets;
	}

}
