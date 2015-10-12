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

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.instinctools.reducerlinks.dao.UserSecurityDAO;
import com.instinctools.reducerlinks.service.UserSecurityService;

/**
 * <p>The class UserSecurityServiceImpl use Service pattern which describes business logic application
 * ReducerLinks. Service layer perform link between, presentation layer and DAO layer.This layer
 * is the main role becouse layer contents(set of methods in classes) affect on functionality of
 * all application.
 * This class contain methods which describes specific operation for UserSecurity.This class perform
 * service layer to UserSecurity.Class extend base class CommonEntityServiceImpl and implement
 * UserSecurityService interface which perform all methods of this class. For logging use framework
 * shell slf4j and framework log4j.Class contain also private, static variable logger, which use to
 * call log message. Class use Spring framework anatation to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
@Service(value="userSecurityService")
public class UserSecurityServiceImpl extends CommonEntityServiceImpl implements UserSecurityService {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityServiceImpl.class);

	@Inject
	@Qualifier("userSecurityDAO")
	private UserSecurityDAO userSecurityDAO;

	public void setUserSecurityDAO(UserSecurityDAO userSecurityDAO) {
		this.userSecurityDAO = userSecurityDAO;
	}
	
	public Boolean isUniqueLoginPassword(String login, String password){
		logger.info("UserSecurityService:Cheack login and password on unique value is completed.");
		return userSecurityDAO.isUniqueLoginPassword(login, password);
	}
}
