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

import org.hibernate.validator.constraints.Email;

/**
 * UserCorespondence entity describe additional characteristics of user.This entity have composition
 * relations to user entity. User corespodence class have feature which have user. There are email, skype,
 * telephone.Email address use for autorization user in system(partial autorization). User corespodence
 * have relations: one-to-many with user. All communication is one-way.
 * 
 * The class is located in the com.instinctools.reducerlinks.model and describes part of model in MVC
 * architecture. This class includes a description UserCorespodence entity. For creating this model
 * use Hibernate technology (anatations). Class contains exclusively no-static public methods that 
 * return fields of entity. Methods intended to access object fields.Class also contain overload methods
 * toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * 
 * @version 1.0 01.10.2015
 * @author Denis Zaerko
 */
@Entity(name="UserCorespondence")
@Table(name="public.user_corespondence")
public class UserCorespondence {

	/**
	 * Unique identification number of user corespondence feature for entity
	 * user(colume: id_user_corespodence type:bigint).
	 * 
	 * @type Long
	 */	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id_user_corespondence")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genn")
	@SequenceGenerator(name = "seq_genn", sequenceName = "public.id_user_corespondence_seq", initialValue=1, allocationSize=1)
	@Column(name="id_user_corespondence",columnDefinition="integer", nullable = false)
	private Long idUserCorespondence;

	/**
	 * User email is feature of entity user(colume:e_mail type:text).
	 * @type String
	 */
	@Email
	@Column(name="e_mail")
	private String email;
	
	/**
	 * User telephone is feature of entity user(colume:telephone type:text).
	 * @type String
	 */
	@Column(name="telephone")
	private String telephone;
	
	/**
	 * User skype is feature of entity user(colume:skype type:text).
	 * @type String
	 */
	@Column(name="skype")
	private String skype;
	
	/**
	 * User which belong user corespondence.(colume forigin key:user_id type:bigint).
	 * @type User
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	/**
	 * Empty constructor(default) of UserCorespondence class.
	 */
	public UserCorespondence(){
	}
	
	/**
	 * Overloaded constructor of UserCorespondence class.
	 * 
	 * @type Long
	 * @type String
	 * 
	 * @param idUserCorespondence
	 * @param email
	 * @param telephone
	 * @param skype
	 * @param user
	 */
	public UserCorespondence(Long idUserCorespondence, String email, String telephone, String skype,User user){
		this.idUserCorespondence=idUserCorespondence;
		this.email=email;
		this.telephone=telephone;
		this.skype=skype;
		this.user=user;
	}
	
	/**
	 * @type Long
	 * @return idUserCorespondence attribute of the UserCorespondence
	 */
	public Long getIdUserCorespondence() {
		return idUserCorespondence;
	}

	/**
	 * Method change idUserCorespondence attribute of the UserCorespondence
	 * 
	 * @type Long
	 * @param idUserCorespondence
	 */
	public void setIdUserCorespondence(Long idUserCorespondence) {
		this.idUserCorespondence = idUserCorespondence;
	}

	/**
	 * @type String
	 * @return telephone attribute of the UserCorespondence
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Method change telephone attribute of the UserCorespondence
	 * 
	 * @type String
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @type String
	 * @return skype attribute of the UserCorespondence
	 */
	public String getSkype() {
		return skype;
	}

	/**
	 * Method change skype attribute of the UserCorespondence
	 * 
	 * @type String
	 * @param skype
	 */
	public void setSkype(String skype) {
		this.skype = skype;
	}

	/**
	 * @type String
	 * @return email attribute of the UserCorespondence
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method change email attribute of the UserCorespondence
	 * 
	 * @type String
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Return user which have security feature.
	 * 
	 * @type User
	 * @return user_id attribute of the UserSecurity
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
	 * @return UserCorespondence attribute as string.
	 */
	@Override
	public String toString() {
		if(!this.idUserCorespondence.equals(null)){
			return this.idUserCorespondence.toString()+" "+ this.email+" "+this.skype+" "
					+this.telephone;
		}
		return super.toString();
	}

	/**
	 * (Overload basic method) toString()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param object
	 * @return Boolean true if object belong to UserCorespondence or false.
	 */
	public boolean equalsObject(Object obj) {
		boolean result = false;
		if (!obj.equals(null) && getClass().equals(obj.getClass())) {

			final UserCorespondence other = (UserCorespondence) obj;
			if (this.idUserCorespondence.equals(other.idUserCorespondence)) {
				result = true;
			}
		}
		return result;
	}
}
