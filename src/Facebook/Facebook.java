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

/**
 * @author ES2018
 * 
 * 
 *
 */

public class Facebook {
	String procura;
	ArrayList<Info> posts = new ArrayList<Info>();
	List<Date> tempos = new ArrayList<Date>();
	Date today = new Date();
	Date today2 = new Date(today.getYear(), today.getMonth(), today.getHours());

	/**
	 * Construtor que estabelece as ligações com os access token key e introduz
	 * todos os posts numa lista que será posteriormente exibida
	 * 
	 * @param procura no qual podemos selecionar um filtro para especificar o nosso
	 *                output
	 * 
	 */

	public Facebook(String procura, String combo, String token) {
		this.procura = procura;
		FacebookClient fbClient5 = new DefaultFacebookClient(token);
		Connection<Post> result = fbClient5.fetchConnection("me/feed", Post.class);

		today2.setHours(today.getHours() - 6);

		for (List<Post> page : result) {
			for (Post aPost : page) {
				if (aPost.getMessage() != null && aPost.getMessage().contains(procura)) {

					if (combo.equals("Última hora")) {
						if (today.getHours() == aPost.getCreatedTime().getHours()
								&& today.getDay() == aPost.getCreatedTime().getDay()
								&& today.getMonth() == aPost.getCreatedTime().getMonth()
								&& today.getYear() == aPost.getCreatedTime().getYear()) {
							posts.add(new Info(aPost.getCreatedTime(), null, null, aPost.getMessage(),
									toIntExact(aPost.getLikesCount()), toIntExact(aPost.getSharesCount()),
									toIntExact(aPost.getCommentsCount()), -1,"facebook"));
						}
					} else if (combo.equals("Últimas 6 horas")) {
						if (today.getDay() == aPost.getCreatedTime().getDay()
								&& today.getMonth() == aPost.getCreatedTime().getMonth()
								&& today.getYear() == aPost.getCreatedTime().getYear()) {
							if (aPost.getCreatedTime().before(today) && aPost.getCreatedTime().after(today2)) {
								posts.add(new Info(aPost.getCreatedTime(), null, null,aPost.getMessage(),
										toIntExact(aPost.getLikesCount()), toIntExact(aPost.getSharesCount()),
										toIntExact(aPost.getCommentsCount()), -1,"facebook"));
							}
						}
					} else if (combo.equals("Últimas 24 horas")) {
						if (today.getYear() == aPost.getCreatedTime().getYear()
								&& today.getMonth() == aPost.getCreatedTime().getMonth()
								&& today.getDay() == aPost.getCreatedTime().getDay()) {

							posts.add(new Info(aPost.getCreatedTime(), null, null,aPost.getMessage(),
									toIntExact(aPost.getLikesCount()), toIntExact(aPost.getSharesCount()),
									toIntExact(aPost.getCommentsCount()), -1,"facebook"));
						}
					}else if(combo.equals("Todos")) {
						posts.add(new Info(aPost.getCreatedTime(), null, null,aPost.getMessage(),
								toIntExact(aPost.getLikesCount()), toIntExact(aPost.getSharesCount()),
								toIntExact(aPost.getCommentsCount()), -1,"facebook"));
					}

				}
			}
		}

	}

	/**
	 * Função que retorna o access token usado para estabelecer a ligação e desta
	 * forma permitir cria testes JUnit
	 * 
	 * 
	 * @return o acces token.
	 */


	/**
	 * Função que retorna a lista com todos os posts conforme o filtro selecionado
	 * 
	 * 
	 * @return retorna a ArrayList com todos os posts.
	 */

	public ArrayList<Info> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Info> posts) {
		this.posts = posts;
	}

}
