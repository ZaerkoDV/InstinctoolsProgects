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

import org.hibernate.validator.constraints.Email;

/**
 * @author Zaerko_DV
 *
 */
@Entity(name="UserCorespondence")
@Table(name="public.user_corespondence")
public class UserCorespondence {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user_corespondence")
	private Long idUserCorespondence;
	
	@Email
	@Column(name="e_mail")
	private String email;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="skype")
	private String skype;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserCorespondence(){
	}
	
	public UserCorespondence(Long idUserCorespondence, String email, String telephone, String skype,User user){
		this.idUserCorespondence=idUserCorespondence;
		this.email=email;
		this.telephone=telephone;
		this.skype=skype;
		this.user=user;
	}
	
	/**
	 * @return the idUserCorespondence
	 */
	public Long getIdUserCorespondence() {
		return idUserCorespondence;
	}

	/**
	 * @param idUserCorespondence the idUserCorespondence to set
	 */
	public void setIdUserCorespondence(Long idUserCorespondence) {
		this.idUserCorespondence = idUserCorespondence;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the skype
	 */
	public String getSkype() {
		return skype;
	}

	/**
	 * @param skype the skype to set
	 */
	public void setSkype(String skype) {
		this.skype = skype;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
		if(!this.idUserCorespondence.equals(null)){
			return this.idUserCorespondence.toString()+" "+ this.email+" "+this.skype+" "
					+this.telephone;
		}
		return super.toString();
	}

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
