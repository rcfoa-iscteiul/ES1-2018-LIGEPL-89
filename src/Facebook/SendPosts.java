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
	private String post;
	private String accessToken5 = "EAAc2bKycb0kBANepfvf49SEFvKcu3YFtzTtvfuOBOkaqfvwaZCZC13AZAg87QpaZCZBtRohoR29VYcO1odAZC5wmjBuGrljlOLbP3b51D2MMSakq54px203veTETkTC9rKsd6hnztnmwPxvURjR66SK7YdTKDlTZC4SH0LxB9hOHT4luLJpUz5DUa2rmoEFcoJQnuGSFmqYjwZDZD";
	private FacebookClient fbClient5;
	
    
	
	 
	public SendPosts (String post) {
		this.post=post;
	}
	
	public void sendPost() {
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		
		GraphResponse publishMessageResponse =
		fbClient5.publish("me/feed", GraphResponse.class,
		Parameter.with("message", post));
		System.out.println("Published message ID: " + publishMessageResponse.getId());
	}
	
	
	

}
