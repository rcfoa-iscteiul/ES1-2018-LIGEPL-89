package Twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TwitterES {
	public String procura;
	private List<Status> statuses;
	public ArrayList<String> tweets = new ArrayList<String>();
	Date today = new Date();

	/**
	 * Construtor que estabelece as ligações com os access token key e introduz
	 * todos os tweets numa lista que será posteriormente exibida
	 * 
	 * @param procura no qual podemos selcionar um filtro para especificar o nosso
	 *                output
	 * 
	 */

	public TwitterES(String procura, String combo) {
		this.procura = procura;

		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("GudSUSay8T8kjEmvaKn83vcZl")
					.setOAuthConsumerSecret("ZDf5MCyxXvrli75dXKkrAkAkJLFWVjp5dGYXadKLVY2ozu2d66")
					.setOAuthAccessToken("1054165924197122049-XjeA2N2LdH4D0ALnJ0OEyHzNp4bmw4")
					.setOAuthAccessTokenSecret("Qhu4tsevnuDzfj9Ulj7qlixwSO3m3GPC3drWJykRIekGK");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();

			statuses = twitter.getHomeTimeline();
			
			int counter=1;
			
			
			for (Status status : statuses) {
				
				if (status.getUser().getName() != null   && status.getUser().getName().contains(procura)) {
					String tweet = status.getCreatedAt() + "-" + status.getUser().getName() + "-" + status.getText();
					tweets.add(tweet);

					if (combo.equals("Este ano")) {
						if (today.getYear() == status.getCreatedAt().getYear()) {
							tweets.add(tweet);
							counter++;
						}
					} else if (combo.equals("Este mês")) {
						if (today.getYear() == status.getCreatedAt().getYear() && today.getMonth() == status.getCreatedAt().getMonth()) {
							tweets.add(tweet);
							counter++;
						}
					} else if (combo.equals("Este dia")) {
						if (today.getYear() == status.getCreatedAt().getYear() && today.getMonth() == status.getCreatedAt().getMonth() && today.getDay() == status.getCreatedAt().getDay()) {
							tweets.add(tweet);
							counter++;
						}
					}

		}

			}
			// Status status = twitter.updateStatus("latestStatus");
			// System.out.println("Successfully updated the status to [" + status.getText()
			// + "].");

		} catch (TwitterException e) {
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
