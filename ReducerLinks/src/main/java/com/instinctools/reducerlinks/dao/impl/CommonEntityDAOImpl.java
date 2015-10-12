/**
 * @package com.instinctools.reducerlinks.dao.impl
 * 
 * Package com.instinctools.reducerlinks.dao.impl contain set of class which description
 * layer of data access object in ReducerLinks project. This project is based on MVC
 * architecture.This class is part of dao layer in MVC architecture. This layer offer abstract
 * interface for work with any type data base. This pattern give a right work with DAO
 * (data-access-object) without matter what kind of storage engine is used and without need
 * for a special way to match this storage engine. All classes which contain word “DAO” provide
 * to work DAL for Reducer links application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
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
 * <p>The class ÑommonEntityDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object models. This class contain methods which
 * intended to access to set of CRUD (create, read, update, delete) operation with objects.Class
 * provide operation to any object(entity).This class extend HibernateDaoSupport class which create
 * own HibernateTemplate instance if a SessionFactory is passed in. The "allowCreate" flag on that
 * HibernateTemplate will be "true" by default. A custom HibernateTemplate instance can be used
 * through overriding createHibernateTemplate. Class implements interface name as ÑommonEntityDAO
 * and located in package which have name com.instinctools.reducerlinks.dao.
 * All methods are public in class. For logging use framework shell slf4j and framework log4j.Class
 * contain also private, static variable logger, which use to call log message. Class  use Spring
 * framework  to work whith ORM. In particular often use HibernateTemplate for integration Hibernate
 * and Spring technologys.
 *  
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 03.10.2015
 * @author Zaerko Denis
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
