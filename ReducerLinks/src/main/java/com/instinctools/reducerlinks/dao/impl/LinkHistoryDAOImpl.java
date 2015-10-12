/**
 * @package com.instinctools.reducerlinks.dao.impl
 * 
 * Package com.instinctools.reducerlinks.dao.impl contain set of class which description
 * layer of data access object in ReducerLinks project. This project is based on MVC
 * architecture.This class is part of dao layer in MVC architecture. This layer offer abstract
 * interface for work with any type data base. This pattern give a right work with DAO
 * (data-access-object) without matter what kind of storage engine is used and without need
 * for a special way to match this storage engine. All classes which contain word “DAO” provide
 * to work DAL for ReducerLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
 */
package com.instinctools.reducerlinks.dao.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.dao.LinkHistoryDAO;
import com.instinctools.reducerlinks.model.LinkHistory;

/**
 * <p>The class LinkHistoryDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model. Model for this dao layer describied
 * in class LinkHistory. This class contain methods which intended to access special operation with
 * additional link feature.Class extend ÑommonEntityDAOImpl class, which contain base set of operation
 * (CRUD). Class implements interface LinkHistoryDAO located in package which have name com.instinctools.
 * reducerlinks.dao. All methods are public in class.For logging use framework shell slf4j and framework
 * log4j. Class contain also private, static variable logger, which use to call log message. Class use
 * Spring framework to work whith ORM. In particular often use HibernateTemplate for integration Hibernate
 * and Spring technologys. For work with data base use hibernate criteria. This technology provide as
 * object oriented select query in relation to a particular entity, and allows you to query the database
 * without writing SQL code. Use Criteria is the most successful approach to search interface with a
 * variable number of conditions. To create copies of the Criteria used class Session, which acts as a
 * factory.
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
@Repository(value="linkHistoryDAO")
public class LinkHistoryDAOImpl extends CommonEntityDAOImpl implements LinkHistoryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(LinkHistoryDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> getListIpAddressForUser(Long idUser){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(LinkHistory.class);
		criteria.setProjection(Projections.projectionList()
		        .add( Projections.distinct(Projections.property("ipAddress"))));
		
		criteria.createAlias("link", "l");
		criteria.createAlias("l.user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		
		//criteria.addOrder(Order.desc("lastCreate"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<String> listIpAddreses= null;
		try {
			listIpAddreses=(List<String>)criteria.list();
			logger.info("LinkHistoryDAO:List of ip addreses loaded sucessfully");
			
		}catch (NullPointerException e){
			listIpAddreses= Collections.emptyList();
			logger.info("LinkHistoryDAO:List of ip addreses loaded buy is empty.");
		}
		return listIpAddreses;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<LinkHistory> getListLinkHistoryForUser(Long idUser){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(LinkHistory.class);

		criteria.createAlias("link", "l");
		criteria.createAlias("l.user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		
		criteria.addOrder(Order.desc("lastCreate"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<LinkHistory> listLinkHistory= null;
		try {
			listLinkHistory=(List<LinkHistory>)criteria.list();
			logger.info("LinkHistoryDAO:List of links history loaded sucessfully by user id.");
		}catch (NullPointerException e){
			listLinkHistory= Collections.emptyList();
			logger.info("LinkHistoryDAO:List of user links history loaded but is empty.");
		}
		return listLinkHistory;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<LinkHistory> getListLinkHistoryForUserBetweenDate(Long idUser,Date minDate,Date maxDate){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(LinkHistory.class);
		
		criteria.createAlias("link", "l");
		criteria.createAlias("l.user", "u");
		Conjunction and = Restrictions.conjunction();
		//links belong to user
		and.add(Restrictions.eq("u.idUser", idUser));
	    // The date must be >= 17-04-2011 - 00h00
	    and.add( Restrictions.ge("lastCreate", minDate));
	    // And date must be < 18-04-2011 - 00h00
	    and.add( Restrictions.lt("lastCreate", maxDate)); 
		
		criteria.addOrder(Order.desc("lastCreate"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<LinkHistory> listLinkHistory= null;
		try {
			listLinkHistory=(List<LinkHistory>)criteria.list();
			logger.info("LinkHistoryDAO:LinkHistoryDAO:List of user links history"
					+ " loaded.History between max and min date.");
			
		}catch (NullPointerException e){
			listLinkHistory= Collections.emptyList();
			logger.info("LinkHistoryDAO:List of user links history loaded but list is empty.");
		}
		return listLinkHistory;
	}
	
}
