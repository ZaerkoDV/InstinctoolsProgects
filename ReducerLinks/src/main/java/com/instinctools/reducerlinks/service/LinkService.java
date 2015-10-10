/**
 * 
 */
package com.instinctools.reducerlinks.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpException;

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
	public Boolean isValidURL(String fullUrl);	
	public String reduceURL(String fullURL);
	public String expandURL(String shortURL) throws IOException;
}
