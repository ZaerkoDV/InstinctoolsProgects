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

import java.util.List;

import com.zaerko.reducerlinks.model.Link;

/**
 * Interface ILinkService contains names of methods whose implementation
 * represent in class LinkService. All declared methods are public.
 * Class LinkService use pattern Service which represent available set of
 * operations and controls response to the application of each operation.
 * Class is part of mvc architecture. DAO for service layer describied in
 * class LinkDAO.
 *
 * @see org.apache.commons.validator.UrlValidator
 * @see List
 * @version 1.0 03.06.2015
 * @author Zaerko Denis
 */
public interface ILinkService {

	/**
	 * Return link by id if link exist in data base with specify id
	 * else null.Parameter idAuthor is attribute of the Author.It is
	 * one of the method which realize of a set of CRUD operations.
	 * 
	 * @param idAuthor
	 * @type Long
	 * @throw NullPointerException
	 * @return Author or null.
	 */
	public Link getLinkById(Long idLink);
	
	/**
	 * Save object link in data base if object not null else generate
	 * exeption.Parameter link is object which save in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param link
	 * @throw NullPointerException
	 */
	public void addLink(Link link);
	
	/**
	 * Update object link in data base if object not null else generate
	 * exeption.Parameter link is object which update in data base.
	 * Method reduce full url to short url.This operation create
	 * new exemplar of class from javaQuery. It is one of the method
	 * which realize of a set of CRUD operations.
	 * 
	 * @param link
	 * @throw NullPointerException
	 */
	public void updateLink(Link link);
	
	/**
	 * Remove object link in data base if object not null else return generate
	 * exeption. Parameter idLink represents object which remove in data base.
	 * Method reduce full url to short url.This operation create new exemplar
	 * of class from javaQuery. It is one of the method which realize of a set
	 * of CRUD operations.
	 * 
	 * @type Long
	 * @throw NullPointerException
	 * @param idLink
	 */
	public void removeLink(Long idLink);
	
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
	public List<Link> getLinkListByTag(String urlTag);
	
	/**
	 * Method return list of link if link exist in data base 
	 * else return empty list. 
	 *  
	 * @return List
	 */
	public List<Link> getAllLink();
	
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
	public List<Link> getLinkListByLogin(String login);
	
	/**
	 * Method return number of visits by link. Number of visits
	 * increase by one for every method call.
	 *  
	 * @type Long
	 * @param idLink
	 * @throw NullPointerException
	 * @return sum of click on link
	 */
	public Long increaseNumberLinkVisits(Long idLink);
	
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
	public Boolean isUrlAddress(String linkFullURL);
}
