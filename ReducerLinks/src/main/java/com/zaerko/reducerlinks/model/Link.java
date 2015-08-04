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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

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
@Table(name="basic.links")
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
	@SequenceGenerator(name = "seq_gen", sequenceName = "basic.id_link_seq",initialValue=1, allocationSize=1)
	@Column(name="id_link",columnDefinition="integer",unique=true, nullable = false)
	private Long idLink;

	@Column(name="link_note",columnDefinition="text")
	private String linkNote;

	@NotEmpty
	@URL
	@Column(name="link_full_url", columnDefinition="text", nullable=false)
	private String linkFullURL;

	@NotEmpty
	@Column(name="link_short_url",columnDefinition="text")
	private String linkShortURL;

	@NotEmpty
	@Column(name="tag",columnDefinition="text default 'all'", nullable=false)
	private String urlTag;

	@NotEmpty
	@Column(name="sum_click", columnDefinition="bigint default '0'", nullable=false)
	private Long sumClick;

	/**
	 * Connect link with his author.
	 */
	@NotNull
	@ManyToOne//(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="author_id",columnDefinition="integer", nullable=false)
	private Author author;

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
	 * @param urlTag
	 * @param sumClick
	 * @param author
	 */
	public Link(Long idLink, String linkNote, String linkFullURL, String linkShortURL, String urlTag, Long sumClick,Author author) {
		this.idLink = idLink;
		this.linkNote=linkNote;
		this.linkFullURL=linkFullURL;
		this.linkShortURL=linkShortURL;
		this.urlTag=urlTag;
		this.sumClick=sumClick;
		this.author=author;
	}

	/**
	 * Empty constructor of class Link. Suppresses default constructor, ensuring
	 * non-instantiability.
	 */
	public Link(){
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
	 * @return urlTag attribute of the Link
	 */
	public String getUrlTag() {
		return urlTag;
	}

	/**
	 * Parameter tag is attribute of the Link
	 * 
	 * @type String
	 * @param urlTag
	 */
	public void setUrlTag(String urlTag) {
		this.urlTag = urlTag;
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
//	@Override
//	public String toString() {
//		if(!this.idLink.equals(null)){
//			return this.idLink.toString()+" "+this.linkNote.toString()+" "+ this.linkFullURL.toString()+" "
//					+this.linkShortURL+" "	+this.urlTag.toString()+" "+this.sumClick.toString();
//		}
//		return super.toString();
//	}

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
	//	public boolean equalsObject(Object obj) {
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
