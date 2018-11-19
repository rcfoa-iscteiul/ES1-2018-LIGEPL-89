package twitterexample;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.List;

public class TwitterES {
	public String procura;
	private List<Status> statuses;
	public ArrayList<String> tweets=new ArrayList<String>();


	public TwitterES(String procura) {
		this.procura=procura;
		
		 try {
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	.setOAuthConsumerKey("oUMmyUS7gyRAZfbRj5zYk86t9")
    	  .setOAuthConsumerSecret("wzhAtgLCdDHReB6wpdguYKFxwXmyJXDDDaSnlnLk9M15ICDNAu")
    	  .setOAuthAccessToken("1054165924197122049-yEMHGHuRzHXaHUfeBhmWEzSZ60MErb")
    	  .setOAuthAccessTokenSecret("GkMie9MJeKcPRSvpWDPZu08g3IcBRk5PsoVv9QiB9QpCs");
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();        		
       
			statuses = twitter.getHomeTimeline();
		
        
				int counter=0;
		
				    for (Status status : statuses) {
						if (status.getUser().getName() != null && counter <=15 && status.getUser().getName().contains(procura)) {
							String tweet=status.getUser().getName()+"-"+status.getText();
							tweets.add(tweet);
							counter++;
						}
				    }
				    
			}catch (TwitterException e) {
				e.printStackTrace();
			}
	}


	public ArrayList<String> getTweets() {
		return tweets;
	}


	public void setTweets(ArrayList<String> tweets) {
		this.tweets = tweets;
	}
	
	
	
}
