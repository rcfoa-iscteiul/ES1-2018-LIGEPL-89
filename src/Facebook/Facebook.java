/*
 * 
 */
package Facebook;

import static java.lang.Math.toIntExact;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;
import Interface.Info;

// TODO: Auto-generated Javadoc
/**
 * The Class Facebook.
 *
 * @author ES2018
 */

public class Facebook {
	
	/** The procura. */
	private String procura;
	
	/** The posts. */
	private ArrayList<Info> posts = new ArrayList<Info>();
	
	/** The tempos. */
	private List<Date> tempos = new ArrayList<Date>();
	
	/** The today. */
	private Date today = new Date();
	
	/** The today 2. */
	private Date today2 = new Date(today.getYear(), today.getMonth(), today.getDay());
	
	
	/**
	 * 
	 */
	private String combo;
	
	
	private Connection<Post> result;

	/**
	 * Constructor that establish a conection with the access keys and show a list with the facebook posts
	 *
	 * @param procura 
	 * @param combo the combo
	 * @param token the token
	 */

	public Facebook(String procura, String combo, String token) {
		this.combo=combo;
		this.procura = procura;
		FacebookClient fbClient5 = new DefaultFacebookClient(token);
		result = fbClient5.fetchConnection("me/feed", Post.class);
		today2.setHours(today.getHours() - 6);

		
	}

	/**
	 * Used to unload all facebook post accordingly with the selected filters
	 */
	public void unload() {
		for (List<Post> page : result) {
			for (Post aPost : page) {
				if (aPost.getMessage() != null && aPost.getMessage().contains(procura)) {

					if (combo.equals("�ltima hora")) {
						if (today.getHours() == aPost.getCreatedTime().getHours()
								&& today.getDay() == aPost.getCreatedTime().getDay()
								&& today.getMonth() == aPost.getCreatedTime().getMonth()
								&& today.getYear() == aPost.getCreatedTime().getYear()) {
							posts.add(new Info(aPost.getCreatedTime(), null, null, aPost.getMessage(),
									toIntExact(aPost.getLikesCount()), toIntExact(aPost.getSharesCount()),
									toIntExact(aPost.getCommentsCount()), -1, "facebook"));
						}
					} else if (combo.equals("�ltimas 6 horas")) {
						if (today.getDay() == aPost.getCreatedTime().getDay()
								&& today.getMonth() == aPost.getCreatedTime().getMonth()
								&& today.getYear() == aPost.getCreatedTime().getYear()) {
							if (aPost.getCreatedTime().before(today) && aPost.getCreatedTime().after(today2)) {
								posts.add(new Info(aPost.getCreatedTime(), null, null, aPost.getMessage(),
										toIntExact(aPost.getLikesCount()), toIntExact(aPost.getSharesCount()),
										toIntExact(aPost.getCommentsCount()), -1, "facebook"));
							}
						}
					} else if (combo.equals("�ltimas 24 horas")) {
						if (today.getYear() == aPost.getCreatedTime().getYear()
								&& today.getMonth() == aPost.getCreatedTime().getMonth()
								&& today.getDay() == aPost.getCreatedTime().getDay()) {

							posts.add(new Info(aPost.getCreatedTime(), null, null, aPost.getMessage(),
									toIntExact(aPost.getLikesCount()), toIntExact(aPost.getSharesCount()),
									toIntExact(aPost.getCommentsCount()), -1, "facebook"));
						}
					} else if (combo.equals("Todos")) {
						posts.add(new Info(aPost.getCreatedTime(), null, null, aPost.getMessage(),
								toIntExact(aPost.getLikesCount()), toIntExact(aPost.getSharesCount()),
								toIntExact(aPost.getCommentsCount()), -1, "facebook"));
					}

				}
			}
		}

	}
	
	
	/**
	 * Fun��o que retorna o access token usado para estabelecer a liga��o e desta
	 * forma permitir cria testes JUnit.
	 *
	 * @return o acces token.
	 */

	/**
	 * Fun��o que retorna a lista com todos os posts conforme o filtro selecionado
	 * 
	 * 
	 * @return retorna a ArrayList com todos os posts.
	 */

	public ArrayList<Info> getPosts() {
		return posts;
	}

	/**
	 * Sets the posts.
	 *
	 * @param posts the new posts
	 */
	public void setPosts(ArrayList<Info> posts) {
		this.posts = posts;
	}

}
