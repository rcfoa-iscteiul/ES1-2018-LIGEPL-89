package Facebook;

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

/**
 * @author ES2018
 * 
 * 
 *
 */

public class Facebook {
	String procura;
	ArrayList<String> posts = new ArrayList<String>();
	String accessToken5 = "EAAc2bKycb0kBAKod5F1zdNiZCo5kmTABgHqcsDf0XhwKXE88CZBzkpxyL9ZBvuvZCbG7DbR1LcypxcZBpbF5pi3Eb8UqmwtgxQlRe40xdDvZALopan0XuUPvKFxRsYHGpNU2ZATXoRfK7dyDMdSlgoAQ18AZA8bMj0VahVGakTaWnjUPyIV912XqHDdZAZBkZArI8oXNMNjZCeb5gwZDZD";
	List<Date> tempos = new ArrayList<Date>();
	Date today = new Date();

	/**
	 * Construtor que estabelece as ligações com os access token key e introduz
	 * todos os posts numa lista que será posteriormente exibida
	 * 
	 * @param procura no qual podemos selcionar um filtro para especificar o nosso
	 *                output
	 * 
	 */

	public void compareTime() {
		System.out.println(LocalDateTime.now());
//     if(todayDate.after(historyDate) && todayDate.before(futureDate)) {
//    	    // In between
//    	}
//     
	}

	public Facebook(String procura, String combo) {
		this.procura = procura;
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);
		Connection<Post> result = fbClient5.fetchConnection("wall/feed", Post.class);
 
		//int counter = 1;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				if (aPost.getMessage() != null  && aPost.getMessage().contains(procura)) {
					String temp = aPost.getCreatedTime() + "-" + aPost.getMessage();
					
					if(combo.equals("Este ano")) {
						if(today.getYear()==aPost.getCreatedTime().getYear()) {
							posts.add(temp);
						//	counter++;
						}
					}
					else if(combo.equals("Este mês")) {
						if(today.getYear()==aPost.getCreatedTime().getYear() && today.getMonth()==aPost.getCreatedTime().getMonth()) {
							posts.add(temp);
							//counter++;
						}
					}
					else if(combo.equals("Este dia")) {
						if(today.getYear()==aPost.getCreatedTime().getYear() && today.getMonth()==aPost.getCreatedTime().getMonth() && today.getDay()==aPost.getCreatedTime().getDay()) {
							posts.add(temp);
							//counter++;
						}
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
