/**
 * @package com.zaerko.reducerlinks.service
 * 
 * Package com.zaerko.reducerlinks.service contain set of class and interfaces
 * which description service layer in ReducerLinks progect. This project is
 * based on MVC architecture.This class is part of service layer in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.zaerko.reducerlinks.service;

import javaQuery.j2ee.tinyURL;

import java.util.List;
import javax.inject.Inject;
import org.apache.commons.validator.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zaerko.reducerlinks.dao.IAuthorDAO;
import com.zaerko.reducerlinks.dao.ILinkDAO;
import com.zaerko.reducerlinks.model.Link;

/**
 * <p>The class LinkService use service pattern which describes defines the boundary
 * between the application and services layer, which forms the set of available operations
 * and manages response to the application in each operation. This class contain methods
 * which intended to access to operation with objects(CRUD and other).Class implements 
 * interface ILinkService which located in the same package as the class LinkService.
 * All methods are public in class. For logging use framework shell slf4j and framework
 * log4j.Class contain also private, static variable logger, which use to call log message.
 * Class use Spring framework to work whith service stereotype. Class use validator from 
 * org.apache.commons.validator to check object(url address).
 * 
 * 
 * @see org.apache.commons.validator.UrlValidator
 * @see List
 * @version 1.0 03.06.2015
 * @author Zaerko Denis
 */
@Service(value="linkService")
public class LinkService implements ILinkService {

	/**
	 * Annatation Inject use to get injection of LinkDAO and 
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	private ILinkDAO linkDAO;

	/**
	 * Variable logger use to get logger level for class LinkService.
	 * 
	 * @return logger for class LinkService.
	 * @param LinkService
	 */
	private static final Logger logger = LoggerFactory.getLogger(LinkService.class);

	public void setLinkDAO(IAuthorDAO authorDAO) {
		this.linkDAO=linkDAO;
	} 

	/**
	 * Save object link in data base if object not null else generate
	 * exeption.Parameter link is object which save in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param link
	 * @throw NullPointerException
	 */
	public Link getLinkById(Long idLink) {

		if(!idLink.equals(null)){
			logger.info("Service:Link loaded, id=" + linkDAO.getLinkById(idLink));
			return linkDAO.getLinkById(idLink);

		}else{
			logger.info("Service:Link not loaded idLink must not be null");
			throw new NullPointerException("Service:Link not loaded idLink must not "
					+ "be null");
		}
	}

	/**
	 * Update object link in data base if object not null else generate
	 * exeption.Parameter link is object which update in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * Method contain reduce full url to short url.This operation create
	 * new exemplar of class from javaQuery.
	 * 
	 * @param link
	 * @throw NullPointerException
	 */
	public void addLink(Link link){

		tinyURL tU = new tinyURL();
		String linkShortURL;
		
		if(!link.equals(null)){
			linkShortURL=tU.getTinyURL(link.getLinkFullURL());
			link.setLinkShortURL(linkShortURL);
			logger.info("Service:New link have short url path "+linkShortURL);
			
			linkDAO.addLink(link);
			logger.info("Service:New link saved, details="+link);

		}else{
			logger.info("Service:New link not saved.Link must not be null.");
			throw new NullPointerException("Service:New link not saved.Link must not "
					+ "be null.");
		}
	}

	/**
	 * Remove object link in data base if object not null else return generate
	 * exeption. Parameter idLink represents object which remove in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * Method contain reduce full url to short url.This operation create
	 * new exemplar of class from javaQuery.
	 * 
	 * @type Long
	 * @throw NullPointerException
	 * @param idLink
	 */
	public void updateLink(Link link){

		tinyURL tU = new tinyURL();
		String linkShortURL;
		
		if(!link.equals(null)){
			linkShortURL=tU.getTinyURL(link.getLinkFullURL());
			link.setLinkShortURL(linkShortURL);
			logger.info("Service: link have short url path "+linkShortURL);
			
			linkDAO.updateLink(link);
			logger.info("Service:Link attributes have updated, details=" + link);

		}else{
			logger.info("Service:Link attributes have not updated. Link must not be null.");
			throw new NullPointerException("Service:Link attributes have not updated.Link must"
					+ " not be null.");
		}
	}

	/**
	 * Method return list of links by tag if tag exist in data base 
	 * else return empty list. Method formation list of links which
	 * have the same tag.
	 *  
	 * @type String
	 * @param tag
	 * @throw NullPointerException
	 * @return List
	 */
	public void removeLink(Long idLink){

		if(!idLink.equals(null)){
			linkDAO.removeLink(idLink);
			logger.info("Service:Link deleted, id=" + idLink);

		}else{
			logger.info("Service:Link didn't delete. Link id must not be null.");
			throw new NullPointerException("Service:Link didn't delete.Link id must not"
					+ " be null.");
		}
	}

	/**
	 * Method return list of links by author ligin if author ligin exist
	 * in data base else return empty list. Method formation list of links
	 * which have the same author.
	 *  
	 * @type String
	 * @param login
	 * @throw NullPointerException
	 * @return List
	 */
	public List<Link> getLinkListByTag(String urlTag){ 

		if(!urlTag.equals(null)){
			logger.info("Service:List of links by url tag =" +urlTag+" download ");
			return linkDAO.getLinkListByTag(urlTag);

		}else{
			logger.info("Service:List of links by url tag not download ");
			throw new NullPointerException("Service:List of links by url tag not download");
		}
	}

	/**
	 * Method return list of links by author ligin if author ligin exist
	 * in data base else return empty list. Method formation list of links
	 * which have the same author.
	 *  
	 * @type String
	 * @param login
	 * @throw NullPointerException
	 * @return List
	 */
	public List<Link> getLinkListByLogin(String login){

		if(!login.equals(null)){
			logger.info("Service:List of links by author login =" +login+" download ");
			return linkDAO.getLinkListByLogin(login);

		}else{
			logger.info("Service:List of links by author login =" +login+"not download."
					+ " Login must not be null.");
			throw new NullPointerException("Service:List of links by author login not"
					+ " download. Login must not be null.");
		}
	}

	/**
	 * Method return number of visits by link. Number of visits
	 * increase by one for every method call.
	 *  
	 * @type Long
	 * @param idLink
	 * @throw NullPointerException
	 * @return sum of click on link
	 */
	public Long increaseNumberLinkVisits(Long idLink) {

		if(!idLink.equals(null)){
			logger.info("Service:Number of link visits increase up on one.");
			return linkDAO.increaseNumberLinkVisits(idLink);

		}else{
			logger.info("Service:Number of link visits not increase.Variable idLink must"
					+ " not be null.");
			throw new NullPointerException("DAO:Number of link visits not increase.Variable"
					+ " idLink must not be null.");
		}
	}

	/**
	 * Method check parametr linkFullURL.If linkFullURL is url address method
	 * return true else return false.
	 *  
	 * @type String
	 * @type String
	 * @param linkFullURL
	 * @throw NullPointerException
	 * @return Boolean value true if parametr linkFullURL is url else false.
	 */
	public Boolean isUrlAddress(String linkFullURL){

		UrlValidator urlValidator;
		Boolean resultCheckUrl;

		if(!linkFullURL.equals(null)){
			urlValidator = new UrlValidator();
			logger.info("Service:Validation url is finish");
			resultCheckUrl=urlValidator.isValid(linkFullURL);

		}else{
			logger.info("Service:Validation url isn't finish. Url must not be null");
			throw new NullPointerException("Service:Validation url isn't finish. Url"
					+ " must not be null");
		}
		return resultCheckUrl;	
	}

}
