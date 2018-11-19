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

	/**
	 * Construtor que estabelece as ligações com os access token key e introduz todos os tweets numa lista que será posteriormente exibida
	 * 
	 * @param procura no qual podemos selcionar um filtro para especificar o nosso output
	 * 
	 */

	public TwitterES(String procura) {
		this.procura=procura;
		
		 try {
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	.setOAuthConsumerKey("t96OnTyYmSV76iC1kPYtcRtc0")
    	  .setOAuthConsumerSecret("tcNFytTbgiEjFivWJy3weloIlDYJavnztaunvI8DYBviTRuzK8")
    	  .setOAuthAccessToken("1054165924197122049-wgINZBH9O7e5wJdD4cuvZH5VxzG5KU")
    	  .setOAuthAccessTokenSecret("5307MfLsLJiFvVBjFSWjaM4ROsysrOGRlcdv2UFpCrJkj");
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

	/**
	 * Função que retorna a lista com todos os tweets conforme o filtro selecionado
	 * 
	 * 
	 * @return retorna a ArrayList com todos os tweets.
	 */
	public ArrayList<String> getTweets() {
		return tweets;
	}


	public void setTweets(ArrayList<String> tweets) {
		this.tweets = tweets;
	}
	

	
	
}
