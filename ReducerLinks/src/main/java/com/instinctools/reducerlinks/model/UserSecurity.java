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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Zaerko_DV
 *
 */
@Entity(name="UserSecurity")
@Table(name="public.user_security")
public class UserSecurity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user_security")
	private Long idUserSecurity;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public UserSecurity(){
	}
	
	public UserSecurity(Long idUserSecurity, String login, String password, String role,User user){
		this.idUserSecurity=idUserSecurity;
		this.login=login;
		this.password=password;
		this.role=role;
		this.user=user;
	}
	
	/**
	 * @return the idUserSecurity
	 */
	public Long getIdUserSecurity() {
		return idUserSecurity;
	}

	/**
	 * @param idUserSecurity the idUserSecurity to set
	 */
	public void setIdUserSecurity(Long idUserSecurity) {
		this.idUserSecurity = idUserSecurity;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
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
		if(!this.idUserSecurity.equals(null)){
			return this.idUserSecurity.toString()+" "+ this.login+" "+this.password+" "
					+this.role;
		}
		return super.toString();
	}

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
