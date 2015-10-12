/**
 * @package com.instinctools.reducerlinks.dao.impl
 * 
 * Package com.instinctools.reducerlinks.dao.impl contain set of class which description layer
 * of data access object in ReducerLinks project. This project is based on MVC architecture.
 * This class is part of dao layer in MVC architecture. This layer offer abstract interface for
 * work with any type data base. This pattern give a right work with DAO (data-access-object)
 * without matter what kind of storage engine is used and without need for a special way to match
 * this storage engine. All classes which contain word “DAO” provide to work DAL for ReducerLinks
 * application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
 */
package com.instinctools.reducerlinks.dao.impl;
 
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.dao.LinkDAO;
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.LinkHistory;

/**
 * <p>The class LinkDAOImpl use DAO pattern which describes layer of data access to object. DAO layer
 * perform link between relational and object model.Model for this dao layer describied in class Link.
 * This class contain methods which intended to access special operation with link. Class extend
 * ÑommonEntityDAOImpl class, which contain base set of operation (CRUD). Class implements interface
 * LinkDAO located in package which have name com.instinctools.reducerlinks.dao.All methods are public
 * in class.For logging use framework shell slf4j and framework log4j. Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework to work whith ORM. In
 * particular often use HibernateTemplate for integration Hibernate and Spring technologys. For work with
 * data base use hibernate criteria. This technology provide as object oriented select query in relation
 * to a particular entity, and allows you to query the database without writing SQL code. Use Criteria is
 * the most successful approach to search interface with a variable number of conditions. To create copies
 * of the Criteria used class Session, which acts as a factory.
 * 
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see org.hibernate.Criteria
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 03.10.2015
 * @author Zaerko Denis
 */
@Repository(value="linkDAO")
public class LinkDAOImpl extends CommonEntityDAOImpl implements LinkDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(LinkDAOImpl.class);
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Link> getListLinkByTagSortByDate(String tag){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(LinkHistory.class);
		criteria.setProjection(Projections.property("link"));
		
		criteria.createAlias("link", "l");
		criteria.add(Restrictions.eq("l.tag", tag));
		
		criteria.addOrder(Order.desc("lastCreate"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<Link> list;
		try {
			list= (List<Link>)criteria.list();
			logger.info("LinkDAO:Link list sort by tag loaded successfully.");
		} catch (NullPointerException e) {
			list=Collections.emptyList();
			logger.info("LinkDAO: Link list loaded, but list is empty"+e);
		}
		return list;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Link> getListLinkSortByDate(){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(LinkHistory.class);
		criteria.setProjection(Projections.property("link"));
		
		criteria.addOrder(Order.desc("lastCreate"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<Link> list;
		try {
			list= (List<Link>)criteria.list();
			logger.info("LinkDAO:Link list sort by date(create) loaded successfully.");
			
		} catch (NullPointerException e) {
			list=Collections.emptyList();
			logger.info("LinkDAO:Link list sort by date(create) loaded but is empty.");
		}
		return list;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<String> getListUniqueTag(){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Link.class);
		
		criteria.setProjection(Projections.projectionList()
		        .add( Projections.distinct(Projections.property("tag"))));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<String> list;
		try {
			list= (List<String>)criteria.list();
			logger.info("LinkDAO:Tag list loaded successfully. Size list="+list.size());
			
		} catch (NullPointerException e) {
			list=Collections.emptyList();
			logger.info("LinkDAO:Tag list loaded successfully.But list is empty");
		}
		return list;
	}
	
	public Long increaseNumberLinkVisits(Long idLink){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(LinkHistory.class);
		criteria.createAlias("link", "l");
		criteria.add(Restrictions.eq("l.idLink", idLink));
		
		Long sumClick = null;
		LinkHistory linkHistory = null;
		try{
			linkHistory = (LinkHistory) criteria.uniqueResult();
			sumClick=linkHistory.getSumClick();

			linkHistory.setSumClick(sumClick+(long)1);
			updateEntity(linkHistory);
			sumClick=linkHistory.getSumClick();
			logger.info("LinkDAO:Count of visits link increse by 1.");
			
		}catch(final DataAccessException e){
			logger.info("LinkDAO:Number of visits link not updated. Because error"+e);
		}
		return sumClick;
	}
	
	public Long getNumberLinkVisits(Long idLink){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(LinkHistory.class);
		criteria.setProjection(Projections.property("sumClick"));
		criteria.createAlias("link", "l");
		criteria.add(Restrictions.eq("l.idLink", idLink));
		
		Long sumClick = null;
		try{
			sumClick = (Long)criteria.uniqueResult();
			logger.info("LinkDAO:Count of visits link loaded sucessfully");
			
		}catch(final DataAccessException e){
			sumClick =(long)0;
			logger.info("LinkDAO:Number of visits link not updated. Because error"+e);
		}
		return sumClick;
	}
}
