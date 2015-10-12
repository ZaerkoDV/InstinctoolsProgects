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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * UserSecurity entity describe additional characteristics of user.This entity have composition relations
 * to user entity. User security class have feature which have user. There are password, login, role. Login
 * and password use for autorization user in system (full autorization).User after autorization in system get
 * same role(admin or user).Class contain method convertToMD5() which convert client password to to MD5 hash.
 * User security have relations: one-to-one with user. All communication is one-way.
 * 
 * The class is located in the com.instinctools.reducerlinks.model and describes part of model in MVC architecture.
 * This class includes a description User entity. For creating User security model use Hibernate technology
 * (anatations). Class contains exclusively no-static public methods that return fields of entity. Methods
 * intended to access object fields.Class also contain overload methods toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * 
 * @version 1.0 01.10.2015
 * @author Denis Zaerko
 */
@Entity(name="UserSecurity")
@Table(name="public.user_security")
public class UserSecurity {

	/**
	 * Unique identification number of user security feature for entity
	 * user(colume: id_user_security type:bigint).
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genn")
	@SequenceGenerator(name = "seq_genn", sequenceName = "public.id_user_security_seq", initialValue=1, allocationSize=1)
	@Column(name="id_user_security",columnDefinition="integer", nullable = false)
	private Long idUserSecurity;
	
	/**
	 * User login this is unique feature of entity user(colume:login type:text).
	 * @type String
	 */
	@Column(name="login")
	private String login;
	
	/**
	 * User password this is unique feature of entity user(colume:password type:text).
	 * @type String
	 */
	@Column(name="password")
	private String password;
	
	/**
	 * User role this is feature of entity user. Role may have two value
	 * admin or user(colume:password type:text).
	 * @type String
	 */
	@Column(name="role")
	private String role;
	
	/**
	 * User which belong user security feature.(colume forigin key:user_id type:bigint).
	 * @type User
	 */
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	/**
	 * Empty constructor(default) of UserSecurity class.
	 */
	public UserSecurity(){
	}
	
	/**
	 * Overloaded constructor of UserSecurity class.
	 * 
	 * @type Long
	 * @type String
	 * 
	 * @param idUserSecurity
	 * @param login
	 * @param password
	 * @param role
	 * @param user
	 */
	public UserSecurity(Long idUserSecurity, String login, String password, String role,User user){
		this.idUserSecurity=idUserSecurity;
		this.login=login;
		this.password=password;
		this.role=role;
		this.user=user;
	}
	
	/**
	 * @type Long
	 * @return idUserSecurity attribute of the UserSecurity
	 */
	public Long getIdUserSecurity() {
		return idUserSecurity;
	}

	/**
	 * Method change idUserSecurity attribute of the UserSecurity
	 * 
	 * @type Long
	 * @param idUser
	 */
	public void setIdUserSecurity(Long idUserSecurity) {
		this.idUserSecurity = idUserSecurity;
	}

	/**
	 * @type String
	 * @return login attribute of the UserSecurity
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Method change login attribute of the UserSecurity
	 * 
	 * @type String
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @type String
	 * @return password attribute of the UserSecurity
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method change password attribute of the UserSecurity
	 * 
	 * @type String
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @type String
	 * @return role attribute of the UserSecurity
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Method change role attribute of the UserSecurity
	 * 
	 * @type String
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Return user which have security feature.
	 * 
	 * @type User
	 * @return user attribute of the UserSecurity
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Method change user which have security feature.
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
	 * @return UserSecurity attribute as string.
	 */
	@Override
	public String toString() {
		if(!this.idUserSecurity.equals(null)){
			return this.idUserSecurity.toString()+" "+ this.login+" "+this.password+" "
					+this.role;
		}
		return super.toString();
	}

	/**
	 * (Overload basic method) toString()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param object
	 * @return Boolean true if object belong to UserSecurity or false.
	 */
	public boolean equalsObject(Object obj) {
		boolean result = false;
		if (!obj.equals(null) && getClass().equals(obj.getClass())) {

			final UserSecurity other = (UserSecurity) obj;
			if (this.idUserSecurity.equals(other.idUserSecurity)) {
				result = true;
			}
		}
		return result;
	}
}
