/**
 * 
 */
package com.instinctools.reducerlinks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;

/**
 * @author Zaerko_DV
 *
 */
@Entity(name="Link")
@Table(name="public.link")
public class Link {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_link")
	private Long idLink;
	
	@Column(name="tag")
	private String tag;
	
	@Column(name="comment")
	private String comment;
	
	@URL
	@Column(name="short_url")
	private String shortUrl;
	
	@URL
	@Column(name="full_url")
	private String fullUrl;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Link(){
	}
	
	public Link(Long idLink, String tag, String comment, String skype,String shortUrl, String fullUrl, User user){
		this.idLink=idLink;
		this.tag=tag;
		this.comment=comment;
		this.shortUrl=shortUrl;
		this.fullUrl=fullUrl;
		this.user=user;
	}
	
	/**
	 * @return the idLink
	 */
	public Long getIdLink() {
		return idLink;
	}

	/**
	 * @param idLink the idLink to set
	 */
	public void setIdLink(Long idLink) {
		this.idLink = idLink;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the shortUrl
	 */
	public String getShortUrl() {
		return shortUrl;
	}

	/**
	 * @param shortUrl the shortUrl to set
	 */
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	/**
	 * @return the fullUrl
	 */
	public String getFullUrl() {
		return fullUrl;
	}

	/**
	 * @param fullUrl the fullUrl to set
	 */
	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		if(!this.idLink.equals(null)){
			return this.idLink.toString()+" "+ this.tag+" "+this.comment+" "
					+this.fullUrl+" "+this.shortUrl;
		}
		return super.toString();
	}

	public boolean equalsObject(Object obj) {
		boolean result = false;
		if (!obj.equals(null) && getClass().equals(obj.getClass())) {

			final Link other = (Link) obj;
			if (this.idLink.equals(other.idLink)) {
				result = true;
			}
		}
		return result;
	}
}
