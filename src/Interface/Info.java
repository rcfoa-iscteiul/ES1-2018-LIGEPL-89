package Interface;

import java.util.Date;

/**
 * The Class Info.
 */
public class Info {

	/** The date. */
	private Date date;

	/** The from. */
	private String from;

	/** The content. */
	private String content;

	/** The likes. */
	private int likes;

	/** The shares. */
	private int shares;

	/** The comments. */
	private int comments;

	/** The rede social. */
	private String redeSocial;

	private long id;

	private String subject;

	/**
	 * Instantiates a new info.
	 *
	 * @param date       the date
	 * @param from       the from
	 * @param content    the content
	 * @param likes      the likes
	 * @param shares     the shares
	 * @param comments   the comments
	 * @param redeSocial the rede social
	 */
	public Info(Date date, String from, String subject, String content, int likes, int shares, int comments, long id,
			String redeSocial) {
		this.date = date;
		this.from = from;
		this.content = content;
		this.likes = likes;
		this.shares = shares;
		this.comments = comments;
		this.redeSocial = redeSocial;
		this.id = id;
		this.subject = subject;
	}
	

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the likes.
	 *
	 * @return the likes
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * Sets the likes.
	 *
	 * @param likes the new likes
	 */
	public void setLikes(int likes) {
		this.likes = likes;
	}

	/**
	 * Gets the shares.
	 *
	 * @return the shares
	 */
	public int getShares() {
		return shares;
	}

	/**
	 * Sets the shares.
	 *
	 * @param shares the new shares
	 */
	public void setShares(int shares) {
		this.shares = shares;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public int getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(int comments) {
		this.comments = comments;
	}

	/**
	 * Gets the rede social.
	 *
	 * @return the rede social
	 */
	public String getRedeSocial() {
		return redeSocial;
	}

	/**
	 * Sets the rede social.
	 *
	 * @param redeSocial the new rede social
	 */
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}

	/**
	 * 
	 * To string for Dates from Facebook
	 * 
	 */
	@Override
	public String toString() {
		if (redeSocial.equals("facebook")) {
			return date + " - " + content;

		}
		return date + "	- " + from + " - " + content;

	}

}
