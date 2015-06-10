/**
 * @package com.zaerko.reducerlinks.dao
 * 
 * Package com.zaerko.reducerlinks.dao contain set of class and interfaces
 * which description layer of data access object in ReducerLinks progect.
 * This project is based on MVC architecture.This interface is part of dao layer
 * in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.zaerko.reducerlinks.dao;

import java.util.List;

import com.zaerko.reducerlinks.model.Link;

/**
 * Interface ILinkDAO contains names of methods whose implementation
 * represent in class LinkDAO. All declared methods are public.
 * Class LinkDAO use DAO pattern which describes layer of data
 * access to object. Model for dao layer describied in class Link.
 *
 * @see List
 * @version 1.0 23.05.2015
 * @author Zaerko Denis
 */
public interface ILinkDAO {

	/**
	 * Return link by id if link exist in data base with specify id
	 * else null.Parameter idAuthor is attribute of the Author.It is
	 * one of the method which realize of a set of CRUD operations.
	 * 
	 * @param idAuthor
	 * @type Long
	 * @return Author or null.
	 */
	public Link getLinkById(Long idLink);

	/**
	 * Save object link in data base if object not null else generate
	 * exeption.Parameter link is object which save in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param link
	 */
	public void addLink(Link link);

	/**
	 * Update object link in data base if object not null else generate
	 * exeption.Parameter link is object which update in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param link
	 */
	public void updateLink(Link link);

	/**
	 * Remove object link in data base if object not null else return null.
	 * Parameter idLink represents object which remove in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Long
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
	 * @return List
	 */
	public List<Link> getLinkListByTag(String tag);

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
	 * @return sum of click on link
	 */
	public Long increaseNumberLinkVisits(Long idLink);
}
