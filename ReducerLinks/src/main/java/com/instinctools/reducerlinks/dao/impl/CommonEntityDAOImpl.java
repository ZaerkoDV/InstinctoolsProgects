/**
 * 
 */
package com.instinctools.reducerlinks.dao.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.dao.CommonEntityDAO;

/**
 * @author Zaerko_DV
 *
 */
@Repository(value="commonEntityDAO")
public class CommonEntityDAOImpl extends HibernateDaoSupport implements CommonEntityDAO{

	private static final Logger logger = LoggerFactory.getLogger(CommonEntityDAOImpl.class);
	
	@Transactional
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity) {

		try{
			logger.info("EntityDAO:Entity"+entityClass.getName()+" loaded successfully id="+idEntity);
			return this.getHibernateTemplate().get(entityClass, idEntity);
			
		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("EntityDAO:Entity not loaded,becouse successfully delete or never before exist"+e);
			return null;
		}
	}
	
	@Transactional
	public void saveEntity(Object entity){
		
		this.getHibernateTemplate().save(entity);
		logger.info("EntityDAO:Entity save successfully");
		this.getHibernateTemplate().flush();
	}
	
	@Transactional
	public void updateEntity(Object entity){
		
		this.getHibernateTemplate().update(entity);
		logger.info("EntityDAO:Entity update successfully");
		this.getHibernateTemplate().flush();
	}
	
	@Transactional
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity){
		
		logger.info("EntityDAO:Entity"+entityClass.getName()+" delete successfully,id="+idEntity);
		Object entity =this.getHibernateTemplate().get(entityClass, idEntity);
		
		this.getHibernateTemplate().delete(entity);
		this.getHibernateTemplate().flush();
	}
	
	@Transactional
	public void deleteEntity(Object entity){
		
		logger.info("EntityDAO:Entity "+entity+" delete successfully");
		this.getHibernateTemplate().delete(entity);
		this.getHibernateTemplate().flush();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<Object> getAllEntity(Class<T> entityClass){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(entityClass);	
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		try{
			logger.info("EntityDAO:List entity loaded successfully.");
			return criteria.list();
		}catch(NullPointerException e){
			logger.info("EntityDAO:List entity loaded but is empty.");
			return Collections.emptyList();
		}
	}
	
}
