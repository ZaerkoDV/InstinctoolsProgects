/**
 * 
 */
package com.instinctools.reducerlinks.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.instinctools.reducerlinks.dao.LinkDAO;
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

	public List<String> getListIpAddressForUser(Long idUser){
		return linkHistoryDAO.getListIpAddressForUser(idUser);
	}

	public List<LinkHistory> getListLinkHistoryForUser(Long idUser){
		return linkHistoryDAO.getListLinkHistoryForUser(idUser);
	}

	public List<LinkHistory> getListLinkHistoryForUserBetweenDate(Long idUser,Date minDate,Date maxDate){
		return linkHistoryDAO.getListLinkHistoryForUserBetweenDate(idUser, minDate, maxDate);
	}
	
	//isValidIp
}
