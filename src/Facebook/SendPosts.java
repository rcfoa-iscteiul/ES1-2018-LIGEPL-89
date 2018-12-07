/*
 * 
 */
package Facebook;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.GraphResponse;
import com.restfb.types.Post;

// TODO: Auto-generated Javadoc
/**
 * The Class SendPosts.
 */
public class SendPosts {
	
	/** The fb client 5. */
	private FacebookClient fbClient5;

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public FacebookClient getClient() {
		return fbClient5;
	}

	/**
	 * Instantiates a new send posts.
	 *
	 * @param token the token
	 */
	public SendPosts(String token) {
		fbClient5 = new DefaultFacebookClient(token);
		Connection<Post> result = fbClient5.fetchConnection("me/feed", Post.class);
	}

	/**
	 * Post a facebook post on the facebook wall
	 * @param post the post
	 */
	public void sendPost(String post) {

		GraphResponse publishMessageResponse = fbClient5.publish("me/feed", GraphResponse.class,
				Parameter.with("message", post));
		JOptionPane.showMessageDialog(null, "Post send");

	}

}
