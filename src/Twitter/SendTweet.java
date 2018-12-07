package Twitter;

import javax.swing.JOptionPane;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SendTweet {
	private Twitter twitter;

	public SendTweet(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(tokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}

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
