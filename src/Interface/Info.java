package Interface;

import java.util.Date;

public class Info {
	private Date date;
	private String from;
	private String content;
	private int likes;
	private int reactions;
	private int comments;
	
	
	public Info(Date date, String from, String content, int likes, int reactions, int comments) {
		this.date = date;
		this.from = from;
		this.content = content;
		this.likes = likes;
		this.reactions = reactions;
		this.comments = comments;
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


	public int getReactions() {
		return reactions;
	}


	public void setReactions(int reactions) {
		this.reactions = reactions;
	}


	public int getComments() {
		return comments;
	}


	public void setComments(int comments) {
		this.comments = comments;
	}
	
	

	
}
