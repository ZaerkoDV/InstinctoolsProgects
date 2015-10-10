/**
 * 
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
import com.instinctools.reducerlinks.dao.UserDAO;
import com.instinctools.reducerlinks.service.UserCorespondenceService;
/**
 * @author Zaerko_DV
 *
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
		return userCorespondenceDAO.isUniqueEmail(email);
	}
	
	public Boolean isValidEmail(String email){
		pattern = Pattern.compile(emailPattern);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
