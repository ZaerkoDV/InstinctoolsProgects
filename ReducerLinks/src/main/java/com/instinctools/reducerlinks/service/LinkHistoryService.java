/**
 * 
 */
package com.instinctools.reducerlinks.service;

import java.util.Date;
import java.util.List;

import com.instinctools.reducerlinks.model.LinkHistory;

/**
 * @author Zaerko_DV
 *
 */
public interface LinkHistoryService extends CommonEntityService {
	
	public List<String> getListIpAddressForUser(Long idUser);
	public List<LinkHistory> getListLinkHistoryForUser(Long idUser);
	public List<LinkHistory> getListLinkHistoryForUserBetweenDate(Long idUser,Date minDate,Date maxDate);
}
