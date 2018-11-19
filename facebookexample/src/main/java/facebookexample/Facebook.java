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

/**
 * @author ES2018
 * 
 *         
 *
 */

public class Facebook {
	String procura;
	 ArrayList<String> posts=new ArrayList<String>();
	 String accessToken5 = "EAAb4NL0K9XABANW6bitzZCqTbOkgJi9wEvtJ0tKkDUD0l0RACZCmLlD83VI9ch3RTICbeZAJnbRoCooq0TKhtiNCrgh1NF9XUt3cyLZBqnZCFVJTwBPKz15gQHxOtrmjw2pXRl4eyfwUST3N5MW4ZC3FS2pw8hZBRkAWHtnSpFP6sIyenUCmZCQ1PZC17ISbvUBPSfvLulDAzsAZDZD";
	
	 /**
		 * Construtor que estabelece as ligações com os access token key e introduz todos os posts numa lista que será posteriormente exibida
		 * 
		 * @param  procura no qual podemos selcionar um filtro para especificar o nosso output
		 * 
		 */
	 
	 
	public Facebook(String procura) {
		this.procura=procura;
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);
		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		
		int counter = 1;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && counter<=15 && aPost.getMessage().contains(procura)) {
					String temp=aPost.getCreatedTime()+"-"+aPost.getMessage();
					posts.add(temp);
					counter++;
				}
			
			}
		}
	}
	
	/**
	 * Função que retorna o access token usado para estabelecer a ligação e desta forma permitir cria testes JUnit
	 * 
	 * 
	 * @return o acces token.
	 */
	
	public String getAcessToken() {
		return accessToken5;
	}
	
	/**
	 * Função que retorna a lista com todos os posts conforme o filtro selecionado
	 * 
	 * 
	 * @return retorna a ArrayList com todos os posts.
	 */
	
	public ArrayList<String> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<String> posts) {
		this.posts = posts;
	}
	
	
}
