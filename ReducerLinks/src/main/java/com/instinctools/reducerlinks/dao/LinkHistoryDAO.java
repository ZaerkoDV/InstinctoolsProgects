/**
 * 
 */
package com.instinctools.reducerlinks.dao;

import java.util.Date;
import java.util.List;

import com.instinctools.reducerlinks.model.LinkHistory;

/**
 * @author Zaerko_DV
 *
 */
public interface LinkHistoryDAO extends CommonEntityDAO {
	
	public List<String> getListIpAddressForUser(Long idUser);
	public List<LinkHistory> getListLinkHistoryForUser(Long idUser);
	public List<LinkHistory> getListLinkHistoryForUserBetweenDate(Long idUser,Date minDate,Date maxDate);
	
}
