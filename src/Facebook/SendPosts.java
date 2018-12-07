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

public class SendPosts {
	private FacebookClient fbClient5;
	
	public SendPosts(String token) {
		FacebookClient fbClient5 = new DefaultFacebookClient(token);
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
	}
	

	public void sendPost(String post) {
		
		
		GraphResponse publishMessageResponse =
		fbClient5.publish("me/feed", GraphResponse.class,
		Parameter.with("message", post));
		JOptionPane.showMessageDialog(null, "Post send");

	}
	
	
	

}
