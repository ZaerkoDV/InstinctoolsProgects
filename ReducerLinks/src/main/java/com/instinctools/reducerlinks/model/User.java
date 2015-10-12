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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * User entity describe base characteristics and behavior of user.This class is basic for all user in system
 * (user may not have links but must have information about yoursalfe ). User may have user or admin role in
 * system. User log in system, he will have unique login and password. Entity user security  responsible
 * for security login and password. User may have only one login and password. User have relations: one-to-many
 * with link, one-to-many with user corespodence, one-to-one with user security. All communication is one-way.
 * 
 * The class is located in the com.instinctools.reducerlinks.model and describes part of model in MVC architecture.
 * This class includes a description User entity. For creating User model use Hibernate technology (anatations).
 * Class contains exclusively no-static public methods that return fields of entity.* Methods intended to access
 * object fields.Class also contain overload methods toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * 
 * @version 1.0 01.10.2015
 * @author Denis Zaerko
 */
@Entity(name="User")
@Table(name="public.user")
public class User {

	/**
	 * Unique identification number of user for entity user(colume: id_user type:bigint).
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genn")
	@SequenceGenerator(name = "seq_genn", sequenceName = "public.id_user_seq", initialValue=1, allocationSize=1)
	@Column(name="id_user",columnDefinition="integer", nullable = false)
	private Long idUser;

	/**
	 * User first name for entity user(colume:first_name  type:text).
	 * @type String
	 */
	@Column(name="first_name")
	private String firstName;

	/**
	 * User last name for entity user(colume:last_name  type:text).
	 * @type String
	 */
	@Column(name="last_name")
	private String lastName;

	/**
	 * User middle name for entity user(colume:middle_name  type:text).
	 * @type String
	 */
	@Column(name="middle_name")
	private String middleName;

	/**
	 * User date of birth for entity user(colume:birthday  type:date).
	 * @type Date
	 */
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="birthday")
	private Date birthday;

	/**
	 * Empty constructor(default) of User class.
	 */
	public User(){
	}

	/**
	 * Overloaded constructor of User class.
	 * 
	 * @type Long
	 * @type String
	 * @type Date
	 * 
	 * @param idUser
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param birthday
	 */
	public User(Long idUser, String firstName, String lastName, String middleName,Date birthday){
		this.idUser=idUser;
		this.firstName=firstName;
		this.lastName=lastName;
		this.middleName=middleName;
		this.birthday=birthday;
	}

	/**
	 * @type Long
	 * @return idUser attribute of the User
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * Method change idUser attribute of the User
	 * 
	 * @type Long
	 * @param idUser
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @type String
	 * @return firstName attribute of the User
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method change firstName attribute of the User
	 * 
	 * @type String
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @type String
	 * @return lastName attribute of the User
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method change lastName attribute of the User
	 * 
	 * @type String
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @type String
	 * @return middleName attribute of the User
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Method change middleName attribute of the User
	 * 
	 * @type String
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @type Date
	 * @return birthday attribute of the User
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Method change birthday attribute of the User
	 * 
	 * @type Date
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	 * @return User attribute as string.
	 */
	@Override
	public String toString() {
		if(!this.idUser.equals(null)){
			return this.idUser.toString()+" "+ this.firstName+" "+this.lastName+" "
					+this.middleName+" "+this.birthday;
		}
		return super.toString();
	}
	
	/**
	 * (Overload basic method) toString()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param object
	 * @return Boolean true if object belong to User or false.
	 */
	public boolean equalsObject(Object obj) {
		boolean result = false;
		if (!obj.equals(null) && getClass().equals(obj.getClass())) {

			final User other = (User) obj;
			if (this.idUser.equals(other.idUser)) {
				result = true;
			}
		}
		return result;
	}
}
