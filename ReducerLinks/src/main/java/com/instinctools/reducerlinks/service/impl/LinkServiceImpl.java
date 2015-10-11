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
import org.apache.commons.validator.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
		logger.info("LinkService:List of link by tag load successfully");
		return linkDAO.getListLinkByTagSortByDate(tag);
	}

	public List<Link> getListLinkSortByDate(){
		logger.info("LinkService:List of link which sort by date load successfully");
		return linkDAO.getListLinkSortByDate();
	}

	public List<String> getListUniqueTag(){
		logger.info("LinkService:List of unique tag load successfully");
		return linkDAO.getListUniqueTag();
	}

	public Long increaseNumberLinkVisits(Long idLink){
		logger.info("LinkService:Number of visit link increase.");
		return linkDAO.increaseNumberLinkVisits(idLink);
	}

	public Long getNumberLinkVisits(Long idLink){
		logger.info("LinkService:Number of visit link load successfully.");
		return linkDAO.getNumberLinkVisits(idLink);
	}	

	public Boolean isValidURL(String fullUrl){

		UrlValidator urlValidator;
		Boolean resultCheckUrl;

		if(!fullUrl.equals(null)){
			urlValidator = new UrlValidator();
			resultCheckUrl=urlValidator.isValid(fullUrl);
			logger.info("LinkService:Cheack url on valid comleted.");
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
			logger.info("LinkService:Operation of reducing full url completed.");
		}else{
			throw new NullPointerException("Service:New link not saved.Link must not be null.");
		}
		return shortURL;
	}

	public String expandURL(String shortURL)  {
		
		String expandURL;
		URL url;
		HttpURLConnection httpURLConnection;
		try{
			url = new URL(shortURL);    
			httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY); 
			httpURLConnection.setInstanceFollowRedirects(false);
			expandURL = httpURLConnection.getHeaderField("Location");
			httpURLConnection.disconnect();
			logger.info("LinkService:Operation of expaned short url completed.");
		}catch(IOException e){
			expandURL=null;
			logger.info("LinkService:Operation of expaned short url failed.");
		}
		return expandURL;
	}

}
