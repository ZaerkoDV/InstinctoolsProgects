/**
 * @package com.instinctools.reducerlinks.model
 * 
 * Package com.instinctools.reducerlinks.model contain set of class which description
 * basic essence in Reducer Links project.The project is based on MVC architecture.
 * This class is part of model in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
 */
package com.instinctools.reducerlinks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;

/**
 * <p>The class is located in the package com.instinctools.reducerlinks.model and describes
 * part of model in MVC architecture. This class includes a description of liks which belong
 * same user. Class use Hibernate technology (anatations) to interconnections with database
 * Class describes the database table links. Class contains exclusively no-static public methods
 * that return fields of link as an entity.Methods intended to assess object fields. Class also
 * contain overload methods toString(), hashCode(), equals().Class contains exclusively private
 * fields.Fields has basic  types String or Long. Class Link associeted with the class User as many
 * to one. For associated with class User use private variable user which return author link(user).
 * Also class link have relations one to one with LinkHistory entity. 
 * 
 * @see Collection
 * @see List
 * @see Hibernate annotations
 * 
 * @version 1.0 01.10.2015
 * @author Zaerko Denis
 */
@Entity(name="Link")
@Table(name="public.link")
public class Link {

	/**
	 * Unique identification number of link for entity link(colume: id_link type:bigint).
	 * @type Long
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genn")
	@SequenceGenerator(name = "seq_genn", sequenceName = "public.id_link_seq", initialValue=1, allocationSize=1)
	@Column(name="id_link",columnDefinition="integer", nullable = false)
	private Long idLink;
	
	/**
	 * Link tag is feature of entity link(colume:tag type:text).
	 * @type String
	 */
	@Column(name="tag")
	private String tag;
	
	/**
	 * Comment for link is feature of entity link(colume:comment type:text).
	 * @type String
	 */
	@Column(name="comment")
	private String comment;
	
	/**
	 * Short URL is feature of entity link(colume:short_url type:text).
	 * @type String
	 */
	@URL
	@Column(name="short_url")
	private String shortUrl;
	
	/**
	 * Full URL is feature of entity link(colume:full_url type:text).
	 * @type String
	 */
	@URL
	@Column(name="full_url")
	private String fullUrl;
	
	/**
	 * User which belong links.(colume forigin key:user_id type:bigint).
	 * @type User
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	/**
	 * Empty constructor(default) of Link class.
	 */
	public Link(){
	}
	
	/**
	 * Overloaded constructor of Link class.
	 * 
	 * @type Long
	 * @type String
	 * 
	 * @param idLink
	 * @param tag
	 * @param comment
	 * @param shortUrl
	 * @param fullUrl
	 * @param user
	 */
	public Link(Long idLink, String tag, String comment,String shortUrl, String fullUrl, User user){
		this.idLink=idLink;
		this.tag=tag;
		this.comment=comment;
		this.shortUrl=shortUrl;
		this.fullUrl=fullUrl;
		this.user=user;
	}
	
	/**
	 * @type Long
	 * @return idLink attribute of the Link
	 */
	public Long getIdLink() {
		return idLink;
	}

	/**
	 * Method change idLink attribute of the Link
	 * 
	 * @type Long
	 * @param idLink
	 */
	public void setIdLink(Long idLink) {
		this.idLink = idLink;
	}

	/**
	 * @type String
	 * @return tag attribute of the Link
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Method change tag attribute of the Link
	 * 
	 * @type String
	 * @param tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @type String
	 * @return tag attribute of the Link
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Method change comment attribute of the Link
	 * 
	 * @type String
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @type String
	 * @return short url attribute of the Link
	 */
	public String getShortUrl() {
		return shortUrl;
	}

	/**
	 * Method change short url attribute of the Link
	 * 
	 * @type String
	 * @param shortUrl
	 */
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	/**
	 * @type String
	 * @return full url attribute of the Link
	 */
	public String getFullUrl() {
		return fullUrl;
	}

	/**
	 * Method change full url attribute of the Link
	 * 
	 * @type String
	 * @param fullUrl
	 */
	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	/**
	 * Return user which have links.
	 * 
	 * @type User
	 * @return user attribute of the UserSecurity
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Method change user which have links.
	 * 
	 * @type User
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Overload basic method hashCode()
	 * 
	 * @type Integer
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return Link attribute as string.
	 */
	@Override
	public String toString() {
		if(!this.idLink.equals(null)){
			return this.idLink.toString()+" "+ this.tag+" "+this.comment+" "
					+this.fullUrl+" "+this.shortUrl;
		}
		return super.toString();
	}

	/**
	 * (Overload basic method) toString()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param object
	 * @return Boolean true if object belong to Link or false.
	 */
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
