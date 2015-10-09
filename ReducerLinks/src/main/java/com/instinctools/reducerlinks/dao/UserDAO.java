/**
 * 
 */
package com.instinctools.reducerlinks.dao;

import java.util.List;

import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;

/**
 * @author Zaerko_DV
 *
 */
public interface UserDAO extends CommonEntityDAO{

	public User getUserByEmail(String email);
	public Long getIdUserByLoginPassword(String login,String password);
	public User getUserByLoginPassword(String login,String password);
	public List<User> getListUserByLastName(String lastName);
	public Boolean signInUserByLoginPassword(String login, String password);
	public List<Link> getUserLinksSortByRecency(Long idUser);
	public List<UserCorespondence> getListUserCorespondences(Long idUser);
	public int getCountOfUser();
}
