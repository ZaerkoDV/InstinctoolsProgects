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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.instinctools.reducerlinks.dao.UserCorespondenceDAO;
import com.instinctools.reducerlinks.service.UserCorespondenceService;
/**
 * <p>The class UserCorespondenceServiceImpl use Service pattern which describes business logic
 * application ReducerLinks. Service layer perform link between, presentation layer and DAO layer.
 * This layer is the main role becouse layer contents(set of methods in classes) affect on functionality
 * of all application.
 * This class contain methods which describes specific operation for UserCorespondence.This class
 * perform service layer to UserCorespondence.Class extend base class CommonEntityServiceImpl and implement
 * UserCorespondenceService interface which perform all methods of this class. For logging use framework
 * shell slf4j and framework log4j.Class contain also private, static variable logger, which use to call
 * log message. Class use Spring framework anatation to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
@Service(value="userCorespondenceService")
public class UserCorespondenceServiceImpl extends CommonEntityServiceImpl implements UserCorespondenceService {

	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceServiceImpl.class);

	@Inject
	@Qualifier("userCorespondenceDAO")
	private UserCorespondenceDAO userCorespondenceDAO;

	public void setUserCorespondenceDAO(UserCorespondenceDAO userCorespondenceDAO) {
		this.userCorespondenceDAO = userCorespondenceDAO;
	}
	
	private Pattern pattern;

	private Matcher matcher;
	
	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public Boolean isUniqueEmail(String email){
		logger.info("UserCorespondenceService:Cheack email on unique value is completed.");
		return userCorespondenceDAO.isUniqueEmail(email);
	}
	
	public Boolean isValidEmail(String email){
		logger.info("UserCorespondenceService:Cheack email on valid value is completed.");
		pattern = Pattern.compile(emailPattern);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
