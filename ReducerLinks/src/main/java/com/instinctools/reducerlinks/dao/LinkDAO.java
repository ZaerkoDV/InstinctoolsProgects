/**
 * 
 */
package com.instinctools.reducerlinks.dao;

import java.util.List;

import com.instinctools.reducerlinks.model.Link;

/**
 * @author Zaerko_DV
 *
 */
public interface LinkDAO extends CommonEntityDAO {
	
	public List<Link> getListLinkByTagSortByDate(String tag);
	public List<Link> getListLinkSortByDate();
	public List<String> getListUniqueTag();
	public Long increaseNumberLinkVisits(Long idLink);
	public Long getNumberLinkVisits(Long idLink);
	
}
