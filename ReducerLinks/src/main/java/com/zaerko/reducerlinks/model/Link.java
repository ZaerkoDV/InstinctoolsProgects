/**
  @package com.zaerko.reducerlinks.model
 * 
 * Package com.zaerko.reducerlinks.model contain set of class which description
 * basic essence in ReducerLinks progect.The project is based on MVC architecture.
 * This class is part of model in MVC architecture.
 * 
 * Please contact with Zaerko. Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.zaerko.reducerlinks.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * <p>The class is located in the package com.zaerko.reducerlinks.model and describes
 * part of model in MVC architecture. This class includes a description of liks which
 * belong same author.Class use Hibernate technology (anatations) to interconnections
 * with database reducer_link.Class describes the database table links.Class contains
 * exclusively no-static public methods that return fields of link as an entity.Methods
 * intended to assess object fields. Class also contain overload methods toString(),
 * hashCode(), equals().Class contains exclusively private fields.Fields has basic 
 * types String or Long and custom data type Author. Class Link associeted with the 
 * class Author as many to one. For associated with class Author use private variable 
 * author which return author link.
 * 
 * @see Collection
 * @see List
 * @see Hibernate annotations
 * 
 * @version 1.0 23.05.2015
 * @author Zaerko Denis
 */
@Entity(name="Link")
@Table(name="links")
public class Link {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_link")
	private Long idLink;
	
	@Column(name="link_note")
	private String linkNote;
	
	@NotEmpty
	@Column(name="link_full_url")
	private String linkFullURL;
	
	@NotEmpty
	@Column(name="link_short_url")
	private String linkShortURL;
	
	@NotEmpty
	@Column(name="tag", nullable = false, columnDefinition="text default 'all'")
	private String tag;
	
	@NotEmpty
	@Column(name="sum_click", nullable = false, columnDefinition="bigint default '0'")
	private Long sumClick;
	
	/**
	 * Connect link with his author.
	 */
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	/**
	 * Empty constructor of class Link. Suppresses default constructor, ensuring
	 * non-instantiability.
	 */
	public Link(){
	}
	
	
	/**
	 * Overloaded constructor of class Link.
	 * 
	 * @type Long
	 * @type String
	 * @type Author
	 * 
	 * @param idLink
	 * @param linkNote
	 * @param linkFullURL
	 * @param linkShortURL
	 * @param tag
	 * @param sumClick
	 * @param author
	 */
	public Link(Long idLink, String linkNote, String linkFullURL, String linkShortURL, String tag, Long sumClick,Author author) {
		this.idLink = idLink;
		this.linkNote=linkNote;
		this.linkFullURL=linkFullURL;
		this.linkShortURL=linkShortURL;
		this.tag=tag;
		this.sumClick=sumClick;
		this.author=author;
	}

	/**
	 * 
	 * @type Long
	 * @return idLink attribute of the Link
	 */
	public Long getIdLink() {
		return idLink;
	}

	/**
	 * Parameter idLink is attribute of the Link
	 * 
	 * @type Long
	 * @param idLink
	 */
	public void setIdLink(Long idLink) {
		this.idLink = idLink;
	}

	/**
	 * @type Long
	 * @return the linkNote attribute of the Link
	 */
	public String getLinkNote() {
		return linkNote;
	}

	/**
	 * Parameter linkNote is attribute of the Link
	 * 
	 * @type String
	 * @param linkNote
	 */
	public void setLinkNote(String linkNote) {
		this.linkNote = linkNote;
	}

	/**
	 * @type String
	 * @return linkFullURL attribute of the Link
	 */
	public String getLinkFullURL() {
		return linkFullURL;
	}

	/**
	 * Parameter linkFullURL is attribute of the Link
	 * 
	 * @type String
	 * @param linkFullURL
	 */
	public void setLinkFullURL(String linkFullURL) {
		this.linkFullURL = linkFullURL;
	}

	/**
	 * @type String
	 * @return linkShortURL attribute of the Link
	 */
	public String getLinkShortURL() {
		return linkShortURL;
	}

	/**
	 * Parameter linkShortURL is attribute of the Link
	 * 
	 * @type String
	 * @param linkShortURL
	 */
	public void setLinkShortURL(String linkShortURL) {
		this.linkShortURL = linkShortURL;
	}

	/**
	 * @type String
	 * @return tag attribute of the Link
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Parameter tag is attribute of the Link
	 * 
	 * @type String
	 * @param tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @type Long
	 * @return sumClick
	 */
	public Long getSumClick() {
		return sumClick;
	}

	/**
	 * Parameter sumClick is attribute of the Link
	 * 
	 * @type Long
	 * @param sumClick
	 */
	public void setSumClick(Long sumClick) {
		this.sumClick = sumClick;
	}

	/**
	 * @type custom
	 * @return author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * Parameter is author of link.
	 * 
	 * @type custom
	 * @param author
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return Link attributes as string.
	 */
	@Override
	public String toString() {
		if(!this.idLink.equals(null)){
			return this.idLink.toString()+" "+this.linkNote+" "+ this.linkFullURL+" "
					+this.linkShortURL+" "	+this.tag+" "+this.sumClick.toString();
		}
		return super.toString();
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
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param Obj
	 * @return true if object is Link or false else.
	 * @throws NullPointerException if objrct is null
	 */
//	@Override
//	public boolean equals(Object obj) {
//		boolean result = false;
//		if (!obj.equals(null) && getClass().equals(obj.getClass())) {
//
//			final Link other = (Link) obj;
//			if (this.idLink.equals(other.idLink)) {
//				result = true;
//			}
//		}
//		return result;
//	}

}
