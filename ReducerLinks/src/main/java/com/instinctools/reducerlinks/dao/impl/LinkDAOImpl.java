/**
 * 
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
 * @author Zaerko_DV
 *
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
