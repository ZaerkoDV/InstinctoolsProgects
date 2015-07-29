/**
 * @package com.zaerko.reducerlinks.model
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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>The class is located in the package com.zaerko.reducerlinks.model and describes
 * part of model in MVC architecture. This class includes a description of author 
 * entity. Class use Hibernate technology (anatations) to interconnections with 
 * database reducer_link.Class describes the database table authors.Class contains
 * exclusively no-static public methods that return fields of entity.Methods intended
 * to access object fields.Class also contain overload methods toString(), hashCode(),
 * equals(). Class contains exclusively private fields.Fields has basic types String
 * or Long and custom data type Link. Class Author associeted with the class Link as
 * one to many.For associated with class Link use private List link which return set
 * of author links.
 * 
 * @see Collection
 * @see List
 * @see Hibernate annotations
 * 
 * @version 1.0 23.05.2015
 * @author Zaerko Denis
 */
@Entity(name="Author")
@Table(name="basic.authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genn")
	@SequenceGenerator(name = "seq_genn", sequenceName = "basic.id_author_seq", initialValue=1, allocationSize=1)
	@Column(name="id_author",columnDefinition="integer",unique=true, nullable = false)
	private Long idAuthor;

	@NotEmpty
	@Size(min=1, max=25)
	@Column(name="first_name", columnDefinition="text",nullable=false)
	private String name;

	@NotEmpty
	@Size(min=1, max=25)
	@Column(name="last_name",columnDefinition="text", nullable=false)
	private String surname;

	@Size(min=0, max=25)
	@Column(name="middle_name",columnDefinition="text")
	private String patronymic;

	@NotEmpty
	@Column(name="e_mail",columnDefinition="text", nullable=false)
	private String email;

	@NotEmpty
	@Size(min=4)
	@Column(name="login",columnDefinition="text", nullable=false)
	private String login;

	@NotEmpty
	@Size(min=4)
	@Column(name="password",columnDefinition="text", nullable=false)
	private String password;

	/**
	 * Connect author with his links.
	 */
	@OneToMany(targetEntity=Link.class, mappedBy="author")//, fetch = FetchType.LAZY
	private List<Link> link;

	/**
	 * Overloaded constructor of class Author.
	 * 
	 * @type Long
	 * @type String
	 * @type List
	 * 
	 * @param idAuthor
	 * @param name
	 * @param surname
	 * @param patronymic
	 * @param email
	 * @param login
	 * @param password
	 * @param link
	 */
	public Author(Long idAuthor,String name,String surname,String patronymic,
			String email,String login,String password,List<Link> link) {
		this.idAuthor=idAuthor;
		this.name=name;
		this.surname=surname;
		this.patronymic=patronymic;
		this.email=email;
		this.login=login;
		this.password=password;
		this.link=link;
	}

	/**
	 * Empty constructor of class Author. Suppresses default constructor,
	 * ensuring non-instantiability.
	 */
	public Author(){
	}
	
	/**
	 * @type Long
	 * @return idAuthor attribute of the Author
	 */
	public Long getIdAuthor() {
		return idAuthor;
	}

	/**
	 * Parameter idAuthor is attribute of the Author
	 * 
	 * @type Long
	 * @param idAuthor
	 */
	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

	/**
	 * @type String
	 * @return name attribute of the Author
	 */
	public String getName() {
		return name;
	}

	/**
	 * Parameter name is attribute of the Author
	 * 
	 * @type String
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @type String
	 * @return surname attribute of the Author
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Parameter surname is attribute of the Author
	 * 
	 * @type String
	 * @param surname 
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @type String
	 * @return patronymic
	 */
	public String getPatronymic() {
		return patronymic;
	}

	/**
	 * Parameter patronymic is attribute of the Author
	 * 
	 * @type String
	 * @param patronymic
	 */
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	/**
	 * @type String
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Parameter email is attribute of the Author
	 * 
	 * @type String
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @type String
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Parameter login is attribute of the Author
	 * 
	 * @type String
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @type String
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Parameter password is attribute of the Author
	 * 
	 * @type String
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @type custom
	 * @return List of link
	 */
	public List<Link> getLink() {
		return link;
	}

	/**
	 * Parameter is List of author link.
	 * 
	 * @type custom
	 * @param List of link
	 */
	public void setLink(List<Link> link) {
		this.link = link;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return Author attributes as string.
	 */
	
	@Override
	public String toString() {
		if(!this.idAuthor.equals(null)){
			return this.idAuthor.toString()+" "+ this.name+" "+this.surname+" "
					+this.patronymic+" "+this.email+" "+this.login+" "+this.password;
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
	 * @return true if object is Author or false else.
	 * @throws NullPointerException if objrct is null
	 */
//	public boolean equalsObject(Object obj) {
//		boolean result = false;
//		if (!obj.equals(null) && getClass().equals(obj.getClass())) {
//
//			final Author other = (Author) obj;
//			if (this.idAuthor.equals(other.idAuthor)) {
//				result = true;
//			}
//		}
//		return result;
//	}

}
