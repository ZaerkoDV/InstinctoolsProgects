/**
 * @package com.instinctools.reducerlinks.service.impl
 * 
 * Package com.instinctools.reducerlinks.service.impl contain set of class which description
 * service layer in ReducerLinks project. This project based on MVC architecture.This class
 * is part of service layer in MVC architecture.This layer defines the boundary of the application
 * and a set of permitted operations. It encapsulates the business logic of the application
 * and controls the answers in the implementation of operations. All classes which contain
 * postfix “Service” provide to work Service for ReducerLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
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
 * <p>The class UserServiceImpl use Service pattern which describes business logic application
 * ReducerLinks. Service layer perform link between, presentation layer and DAO layer.This layer
 * is the main role becouse layer contents(set of methods in classes) affect on functionality of
 * all application.
 * This class contain methods which describes specific operation for User.This class perform
 * service layer to User.Class extend base class CommonEntityServiceImpl and implement UserService
 * interface which perform all methods of this class. For logging use framework shell slf4j and
 * framework log4j.Class contain also private, static variable logger, which use to call log
 * message. Class use Spring framework anatation to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
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
	
	public String getUserRoleByUserId(Long idUser){
		logger.info("UserService:User role by user id loaded.");
		return userDAO.getUserRoleByUserId(idUser);
	}
}
