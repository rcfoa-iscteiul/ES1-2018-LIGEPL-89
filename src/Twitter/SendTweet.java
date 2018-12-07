/*
 * 
 */
package Twitter;

import javax.swing.JOptionPane;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class SendTweet.
 */
public class SendTweet {
	
	/** The twitter. */
	private Twitter twitter;

	/**
	 * Instantiates a new send tweet.
	 *
	 *
	 * @param consumerKey the consumer key
	 * @param consumerSecret the consumer secret
	 * @param accessToken the access token
	 * @param tokenSecret the token secret
	 */
	public SendTweet(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(tokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}

	/**
	 * Post a tweet in our twitter account
	 * @param tweet the tweet
	 */
	public void enviaTweet(String tweet) {
		try {
			twitter.updateStatus(tweet);
			JOptionPane.showMessageDialog(null, "Tweet send!");

		} catch (TwitterException e) {
			JOptionPane.showMessageDialog(null, "Bom Dia Academia", "Tweet NOT send!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
