package facebookexample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

public class Facebook {
	
	 ArrayList<String> posts=new ArrayList<String>();
	
	public Facebook() {
		String accessToken5 = "EAAb4NL0K9XABAB2Cbk0q4ZAPHyBbSApHPgBAQgwjo3qZCgGdsRNHakEBElKz5jjFHGIEXKgoz4IzBPgyodZACMDmEdLCqfOUhsEkVI8RciYeZCnPOkjmU3AwWpmZCDRO4ivXkTVr03ZC7ZB34SZBz1hP4hzZAlqI3BIeZBXbz91vmokkmfk87H722gKzWRO3iSica64TwOOTCYugZDZD";	
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		
		int counter = 1;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && counter<=15 ) {
					String temp=aPost.getCreatedTime()+"-"+aPost.getMessage();
					posts.add(temp);
					counter++;
				}
			
			}
		}
	}

	public ArrayList<String> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<String> posts) {
		this.posts = posts;
	}
	
	
}
