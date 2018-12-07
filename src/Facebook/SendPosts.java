package Facebook;

import java.util.ArrayList;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.GraphResponse;
import com.restfb.types.Post;

public class SendPosts {
	String post;
	 String accessToken5 = "EAAc2bKycb0kBADi5iaXMLxZC35nvi0YfzylRvvHafH6HZAIHihSRZAhoxj4VZBLl9sdNpORyzOT0RJrwfCaNPBVlFLSVeOTFZC8YdBVnc51Qx3ILE9tMiI5XOEgf5uloe5OSnx59ZBhMX1COvLJV8DKqpb5ZA4K3urMHbo3rvOZAQeysYbb0Wy7vp5ukAWk6b8eZBAlrfsEfZAYAZDZD";
	FacebookClient fbClient5;
	
    
	
	 
	public SendPosts (String post) {
		this.post=post;
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		
		GraphResponse publishMessageResponse =
		fbClient5.publish("me/feed", GraphResponse.class,
		Parameter.with("message", post));
		System.out.println("Published message ID: " + publishMessageResponse.getId());
		
	}

}
