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

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.instinctools.reducerlinks.dao.LinkHistoryDAO;
import com.instinctools.reducerlinks.model.LinkHistory;
import com.instinctools.reducerlinks.service.LinkHistoryService;

/**
 * <p>The class LinkHistoryServiceImpl use Service pattern which describes business logic application
 * ReducerLinks. Service layer perform link between, presentation layer and DAO layer. This layer is
 * the main role becouse layer contents(set of methods in classes) affect on functionality of all application.
 * This class contain methods which describes specific operation for LinkHistory.This class perform service
 * layer to LinkHistory.Class extend base class CommonEntityServiceImpl and implement LinkHistoryService
 * interface which perform all methods of this class. For logging use framework shell slf4j and framework
 * log4j.Class contain also private, static variable logger, which use to call log message. Class use Spring
 * framework anatation to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
@Service(value="linkHistoryService")
public class LinkHistoryServiceImpl extends CommonEntityServiceImpl implements LinkHistoryService{

	private static final Logger logger = LoggerFactory.getLogger(LinkHistoryServiceImpl .class);

	@Inject
	@Qualifier("linkHistoryDAO")
	private LinkHistoryDAO linkHistoryDAO;

	public void setLinkHistoryDAO(LinkHistoryDAO linkHistoryDAO) {
		this.linkHistoryDAO = linkHistoryDAO;
	}
	
	private Pattern pattern;

	private Matcher matcher;
	
	private static final String ipAddressPattern="^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";;
		

	public List<String> getListIpAddressForUser(Long idUser){
		logger.info("LinkHistoryService:List of ip addreses load by user id successfully");
		return linkHistoryDAO.getListIpAddressForUser(idUser);
	}

	public List<LinkHistory> getListLinkHistoryForUser(Long idUser){
		logger.info("LinkHistoryService:List of link history load by user id successfully");
		return linkHistoryDAO.getListLinkHistoryForUser(idUser);
	}

	public List<LinkHistory> getListLinkHistoryForUserBetweenDate(Long idUser,Date minDate,Date maxDate){
		logger.info("LinkHistoryService:List of link history(between date) load by user id successfully");
		return linkHistoryDAO.getListLinkHistoryForUserBetweenDate(idUser, minDate, maxDate);
	}
	
	public Boolean isValidIpAddress(String ipAddress){
		logger.info("LinkHistoryService:Cheak ip addresses on valid completed");
		pattern = Pattern.compile(ipAddressPattern);
		matcher = pattern.matcher(ipAddress);
		return matcher.matches();
	}
}
