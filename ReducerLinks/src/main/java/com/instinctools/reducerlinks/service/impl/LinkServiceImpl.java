/**
 * 
 */
package com.instinctools.reducerlinks.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

import javaQuery.j2ee.tinyURL;

import javax.inject.Inject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.validator.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.instinctools.reducerlinks.dao.CommonEntityDAO;
import com.instinctools.reducerlinks.dao.LinkDAO;
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.service.LinkService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="linkService")
public class LinkServiceImpl extends CommonEntityServiceImpl implements LinkService{

	private static final Logger logger = LoggerFactory.getLogger(LinkServiceImpl.class);

	@Inject
	@Qualifier("linkDAO")
	private LinkDAO linkDAO;

	public void setLinkDAO(LinkDAO linkDAO) {
		this.linkDAO = linkDAO;
	}

	public List<Link> getListLinkByTagSortByDate(String tag){
		return linkDAO.getListLinkByTagSortByDate(tag);
	}

	public List<Link> getListLinkSortByDate(){
		return linkDAO.getListLinkSortByDate();
	}

	public List<String> getListUniqueTag(){
		return linkDAO.getListUniqueTag();
	}

	public Long increaseNumberLinkVisits(Long idLink){
		return linkDAO.increaseNumberLinkVisits(idLink);
	}

	public Long getNumberLinkVisits(Long idLink){
		return linkDAO.getNumberLinkVisits(idLink);
	}	

	public Boolean isValidURL(String fullUrl){

		UrlValidator urlValidator;
		Boolean resultCheckUrl;

		if(!fullUrl.equals(null)){
			urlValidator = new UrlValidator();
			resultCheckUrl=urlValidator.isValid(fullUrl);
		}else{
			logger.info("Service:Validation url isn't finish. Url must not be null");
			throw new NullPointerException("Service:Validation url isn't finish. Url"
					+ " must not be null");
		}
		return resultCheckUrl;	
	}

	public String reduceURL(String fullURL){

		tinyURL tU = new tinyURL();
		String shortURL;
		if(!fullURL.equals(null)){
			shortURL=tU.getTinyURL(fullURL);
		}else{
			throw new NullPointerException("Service:New link not saved.Link must not be null.");
		}
		return shortURL;
	}

	public String expandURL(String shortURL) throws IOException {
		URL url = new URL(shortURL);    
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY); 
		httpURLConnection.setInstanceFollowRedirects(false);
		String expandURL = httpURLConnection.getHeaderField("Location");
		httpURLConnection.disconnect();

		return expandURL;
	}

}
