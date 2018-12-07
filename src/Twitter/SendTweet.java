package Twitter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SendTweet {
	private Twitter twitter;
	
	public SendTweet() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("GudSUSay8T8kjEmvaKn83vcZl")
				.setOAuthConsumerSecret("ZDf5MCyxXvrli75dXKkrAkAkJLFWVjp5dGYXadKLVY2ozu2d66")
				.setOAuthAccessToken("1054165924197122049-XjeA2N2LdH4D0ALnJ0OEyHzNp4bmw4")
				.setOAuthAccessTokenSecret("Qhu4tsevnuDzfj9Ulj7qlixwSO3m3GPC3drWJykRIekGK");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}
	

	public void enviaTweet(String tweet) {
		try {
			twitter.updateStatus(tweet);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	

}
