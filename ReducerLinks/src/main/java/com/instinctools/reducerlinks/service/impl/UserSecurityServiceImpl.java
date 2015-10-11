/**
 * 
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
 * @author Zaerko_DV
 *
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
