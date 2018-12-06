package Interface;

import java.util.Date;

import com.restfb.types.User;

public class Info {
	private Date date;
	private String from;
	private String content;
	private int likes;
	private int shares;
	private int comments;
	private String redeSocial;
	
	
	public Info(Date date, String from, String content, int likes, int shares, int comments, String redeSocial) {
		this.date = date;
		this.from = from;
		this.content = content;
		this.likes = likes;
		this.shares = shares;
		this.comments = comments;
		this.redeSocial=redeSocial;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public int getShares() {
		return shares;
	}


	public void setShares(int shares) {
		this.shares = shares;
	}


	public int getComments() {
		return comments;
	}


	public void setComments(int comments) {
		this.comments = comments;
	}
	
	


	public String getRedeSocial() {
		return redeSocial;
	}


	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}


	@Override
	public String toString() {
		if(redeSocial.equals("facebook")) {
			return date+" - "+content;
			
		}
			return date+"	"+from+" - "+content;
		
	}
	
	

	
}
