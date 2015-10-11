/**
 * 
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
 * @author Zaerko_DV
 *
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
