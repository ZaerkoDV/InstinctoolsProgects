/**
 * 
 */
package com.instinctools.reducerlinks.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.instinctools.reducerlinks.dao.UserDAO;
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;
import com.instinctools.reducerlinks.service.UserService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userService")
public class UserServiceImpl extends CommonEntityServiceImpl implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Inject
	@Qualifier("userDAO")
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User getUserByEmail(String email){
		logger.info("UserService:User load by his email successfully.");
		return userDAO.getUserByEmail(email);
	}
	
	public Long getIdUserByLoginPassword(String login,String password){
		logger.info("UserService:User id load by his login and password successfully.");
		return userDAO.getIdUserByLoginPassword(login, password);
	}
	
	public User getUserByLoginPassword(String login,String password){
		logger.info("UserService:User load by his email successfully.");
		return userDAO.getUserByLoginPassword(login, password);
	}
	
	public List<User> getListUserByLastName(String lastName){
		logger.info("UserService:List of users load by his lastname successfully.");
		return userDAO.getListUserByLastName(lastName);
	}
	
	public Boolean signInUserByLoginPassword(String login, String password){
		logger.info("UserService:Operation sign in user by login and password successfully completed.");
		return userDAO.signInUserByLoginPassword(login, password);
	}
	
	public List<Link> getUserLinksSortByRecency(Long idUser){
		logger.info("UserService:List of a user links load by user id.");
		return userDAO.getUserLinksSortByRecency(idUser);
	}
	
	public List<UserCorespondence> getListUserCorespondences(Long idUser){
		logger.info("UserService:User load by his email successfully.");
		return userDAO.getListUserCorespondences(idUser);
	}
	
	public int getCountOfUser(){
		logger.info("UserService:Number of user in system load successfully.");
		return userDAO.getCountOfUser();
	}
}
