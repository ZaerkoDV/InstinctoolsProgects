/**
 * 
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
 * @author Zaerko_DV
 *
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
