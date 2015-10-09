/**
 * 
 */
package com.instinctools.reducerlinks.service;

import java.util.List;

import com.instinctools.reducerlinks.model.Link;

/**
 * @author Zaerko_DV
 *
 */
public interface LinkService extends CommonEntityService {

	public List<Link> getListLinkByTagSortByDate(String tag);
	public List<Link> getListLinkSortByDate();
	public List<String> getListUniqueTag();
	public Long increaseNumberLinkVisits(Long idLink);
	public Long getNumberLinkVisits(Long idLink);
	
}
