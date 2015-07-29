/**
 * @package com.zaerko.reducerlinks.dao
 * 
 * Package com.zaerko.reducerlinks.dao contain set of class and interfaces
 * which description layer of data access object in ReducerLinks progect.
 * This project is based on MVC architecture.This class is part of dao 
 * layer in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if
 * you need to use information or have any questions. 
 */
package com.zaerko.reducerlinks.dao;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zaerko.reducerlinks.model.Author;
import com.zaerko.reducerlinks.model.Link;
import com.zaerko.reducerlinks.service.IAuthorService;
import com.zaerko.reducerlinks.service.ILinkService;

/**
 * <p>The class LinkDAO use DAO pattern which describes layer of data access to
 * object. DAO layer perform link between relational and object model. Model for
 * this dao layer describied in class Link. This class contain methods which
 * intended to access to operation with objects(CRUD and other).Class implements
 * interface ILinkDAO which located in the same package as the class LinkDAO.
 * All methods are public in class.For logging use framework shell slf4j and
 * framework log4j.Class contain also private, static variable logger, which use
 * to call log message. Class use Spring framework to work whith ORM.In particular
 * often use HibernateTemplate for integration Hibernate and Spring technologys.
 *
 * @see Collection
 * @see List
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 23.05.2015
 * @author Zaerko Denis
 */
@Repository(value = "linkDAO")
public class LinkDAO extends HibernateDaoSupport implements ILinkDAO {

	/**
	 * Variable logger use to get logger level for class LinkDAO.
	 * 
	 * @return logger for class LinkDAO.
	 * @param LinkDAO
	 */
	private static final Logger logger = LoggerFactory.getLogger(LinkDAO.class);
	
	/**
	 * Return link by id if link exist in data base with specify id
	 * else null.Parameter idAuthor is attribute of the Author.It is
	 * one of the method which realize of a set of CRUD operations.
	 * 
	 * @param idAuthor
	 * @type Long
	 * @return Author or null.
	 * @throw HibernateObjectRetrievalFailureException
	 */
	public Link getLinkById(Long idLink) {

		try{
			logger.info("DAO:Link loaded in dao, id=" + idLink);
			return this.getHibernateTemplate().load(Link.class,idLink);

		}catch(final HibernateObjectRetrievalFailureException e){	
			logger.info("DAO:Link not loaded detales id="+ idLink);
			return null;

		}catch(final ObjectNotFoundException e){	
			logger.info("DAO:Link not loaded detales id="+ idLink);
			return null;
		}
	}

	/**
	 * Save object link in data base if object not null else generate
	 * exeption.Parameter link is object which save in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param link
	 * @throw HibernateObjectRetrievalFailureException 
	 */
	public void addLink(Link link) {

		try{
			this.getHibernateTemplate().persist(link);
			logger.info("DAO:New link saved in dao, details=" + link.getIdLink());

		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("DAO:New link not saved in dao, because is null");
		}
	}

	/**
	 * Update object link in data base if object not null else generate
	 * exeption.Parameter link is object which update in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param link
	 * @throw HibernateObjectRetrievalFailureException 
	 */
	public void updateLink(Link link){

		try{
			this.getHibernateTemplate().update(link);
			logger.info("DAO:Link updated in dao, details=" + link.getIdLink());

		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("DAO:New link not update in dao, because is null");
		}
	}

	/**
	 * Remove object link in data base if object not null else return null.
	 * Parameter idLink represents object which remove in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param link
	 * @throw HibernateObjectRetrievalFailureException 
	 */
	public void removeLink(Long idLink) {

		try{
			Link link=this.getHibernateTemplate().load(Link.class, idLink);
			this.getHibernateTemplate().delete(link);
			logger.info("DAO:Link deleted, details=" + link);

		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("DAO:Link not delete, because error "+e);
		}
	}

	/**
	 * Method return list of links by tag if tag exist in data base 
	 * else return empty list. Method formation list of links which
	 * have the same tag.
	 *  
	 * @type String
	 * @param tag
	 * @throw  DataAccessException
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<Link> getLinkListByTag(String urlTag){ 

		String query;
		List<Link> listLinkByTag = null;

		try{
			query="SELECT l FROM Link l WHERE l.urlTag = ?";
			listLinkByTag = (List<Link>) this.getHibernateTemplate().find(query,urlTag);

		}catch(final DataAccessException e){
			logger.info("DAO:Links not loaded, because error "+e);
		}


		if(listLinkByTag.isEmpty()){
			logger.info("DAO:No links with the specified tag.");

		}else{
			logger.info("DAO:List of links with the specified tag is no empty.");

			for(Link link : listLinkByTag){
				logger.info("DAO:List of links with the specified tag= "+link);
			}
		}
		return listLinkByTag;
	}
	
	/**
	 * Method return list of link if link exist in data base 
	 * else return empty list. 
	 *  
	 * @throw  DataAccessException
	 * @return List
	 */
	public List<Link> getAllLink(){ 
		
		String query;
		List<Link> linkList = null;
		try{
			query="SELECT l FROM Link l";
			linkList = (List<Link>) this.getHibernateTemplate().find(query);
		}catch(final DataAccessException e){
			logger.info("DAO:Link not loaded, because error "+e);
		}
		
		if(linkList.isEmpty()){
			logger.info("DAO:No links.");

		}else{
			logger.info("DAO:List of links is no empty.");

			for(Link link : linkList){
				logger.info("DAO:List of links = "+link);
			}
		}
		return linkList;
	}
	
	
	/**
	 * Method return list of links by author ligin if author ligin exist
	 * in data base else return empty list. Method formation list of links
	 * which have the same author.
	 *  
	 * @type String
	 * @param login
	 * @throw DataAccessException
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<Link> getLinkListByLogin(String login){

		String query;
		List<Link> listLinkByLogin = null;

		try{
			query="SELECT l FROM Link l WHERE l.author.idAuthor = (SELECT a.idAuthor FROM Author a WHERE a.login=?)";			
			listLinkByLogin = (List<Link>)this.getHibernateTemplate().find(query,login);

		}catch(final DataAccessException e){
			logger.info("DAO:List of link with the specified login not load.Because error "+e);
		}

		if(listLinkByLogin.isEmpty()){
			logger.info("DAO:No link with the specified login.");

		}else{
			logger.info("DAO:List of link with the specified login is no empty.");

			for(Link link : listLinkByLogin){
				logger.info("DAO:List of link with the specified login= "+link);
			}
		}
		return listLinkByLogin;
	}

	/**
	 * Method return number of visits by link. Number of visits
	 * increase by one for every method call.
	 *  
	 * @type Long
	 * @param idLink
	 * @throws DataAccessException
	 * @return sum of click on link
	 */
	public Long increaseNumberLinkVisits(Long idLink) {

		Long sumClick = null;
		Link link;

		try{
			link = getLinkById(idLink);
			sumClick=link.getSumClick();

			link.setSumClick(sumClick+1);
			logger.info("DAO:Number of link visits increase up on one.");

			this.getHibernateTemplate().update(link);
			logger.info("DAO:Number of visits link updated successfully.");

		}catch(final DataAccessException e){
			logger.info("DAO:Number of visits link not updated. Because error"+e);
		}
		return sumClick;
	}
}
