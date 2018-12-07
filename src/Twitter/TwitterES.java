/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class TwitterES.
 */
public class TwitterES {
	
	/** The procura. */
	private String procura;
	
	/** The statuses. */
	private List<Status> statuses;
	
	/** The tweets. */
	private ArrayList<Info> tweets = new ArrayList<Info>();
	
	/** The today. */
	private Date today = new Date();
	
	/** The today 2. */
	private Date today2 = new Date(today.getYear(), today.getMonth(), today.getDay());
	
	/** The twitter. */
	private Twitter twitter;
	
	/** The combo. */
	private String combo;

	/**
	 * Gets the procura.
	 *
	 * @return the procura
	 */
	public String getProcura() {
		return procura;
	}

	/**
	 * Constructor that establish a conection with the access keys and show a list with the facebook posts
	 *
	 * @param procura 
	 * @param combo the combo
	 * @param consumerKey the consumer key
	 * @param consumerSecret the consumer secret
	 * @param accessToken the access token
	 * @param tokenSecret the token secret
	 */

	public TwitterES(String procura, String combo, String consumerKey, String consumerSecret, String accessToken,
			String tokenSecret) {
		this.procura = procura;
		this.combo = combo;
		today2.setHours(today.getHours() - 6);
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
					.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(tokenSecret);
			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();

			statuses = twitter.getHomeTimeline();

		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Show the tweets  base on a filter
	 */
	public void tweet() {

		for (Status status : statuses) {

			if (status.getUser().getName() != null && status.getUser().getName().contains(procura)) {
				String tweet = status.getCreatedAt() + "-" + status.getUser().getName() + "-" + status.getText();

				if (combo.equals("Última hora")) {
					if (today.getHours() == status.getCreatedAt().getHours()
							&& today.getDay() == status.getCreatedAt().getDay()
							&& today.getMonth() == status.getCreatedAt().getMonth()
							&& today.getYear() == status.getCreatedAt().getYear()) {
						tweets.add(new Info(status.getCreatedAt(), status.getUser().getName(), null, status.getText(),
								status.getFavoriteCount(), status.getRetweetCount(), -1, status.getId(), "twitter"));
					}
				} else if (combo.equals("Últimas 6 horas")) {
					if (today.getYear() == status.getCreatedAt().getYear()
							&& today.getMonth() == status.getCreatedAt().getMonth()
							&& today.getDay() == status.getCreatedAt().getDay()) {
						if (status.getCreatedAt().before(today) && status.getCreatedAt().after(today2)) {
							tweets.add(new Info(status.getCreatedAt(), status.getUser().getName(), null,
									status.getText(), status.getFavoriteCount(), status.getRetweetCount(), -1,
									status.getId(), "twitter"));

						}
					}
				} else if (combo.equals("Últimas 24 horas")) {
					if (today.getYear() == status.getCreatedAt().getYear()
							&& today.getMonth() == status.getCreatedAt().getMonth()
							&& today.getDay() == status.getCreatedAt().getDay()) {
						tweets.add(new Info(status.getCreatedAt(), status.getUser().getName(), null, status.getText(),
								status.getFavoriteCount(), status.getRetweetCount(), -1, status.getId(), "twitter"));
					}
				} else if (combo.equals("Todos")) {
					tweets.add(new Info(status.getCreatedAt(), status.getUser().getName(), null, status.getText(),
							status.getFavoriteCount(), status.getRetweetCount(), -1, status.getId(), "twitter"));
				}

			}

		}
	}

	/**
	 * Allows to share a tweet
	 *
	 * @param id the id
	 */
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
	 * Function that returns all the tweets base on a filter
	 *
	 * @return return a arrayList with the tweets
	 */
	public ArrayList<Info> getTweets() {
		return tweets;
	}

	/**
	 * Sets the tweets.
	 *
	 * @param tweets the new tweets
	 */
	public void setTweets(ArrayList<Info> tweets) {
		this.tweets = tweets;
	}

}
