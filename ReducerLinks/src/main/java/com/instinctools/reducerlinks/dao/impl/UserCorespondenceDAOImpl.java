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

import javax.persistence.NonUniqueResultException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.dao.UserCorespondenceDAO;
import com.instinctools.reducerlinks.model.UserCorespondence;

/** <p>The class UserCorespondenceDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model.Model for this dao layer describied
 * in class UserCorespondence. This class contain methods which intended to access special operation with
 * additional user feature.Class extend ÑommonEntityDAOImpl class, which contain base set of operation
 * (CRUD). Class implements interface UserCorespondenceDAO located in package which have name
 * com.instinctools.reducerlinks.dao.All methods are public in class.For logging use framework shell
 * slf4j and framework log4j. Class contain also private, static variable logger, which use to call
 * log message. Class use Spring framework to work whith ORM. In particular often use HibernateTemplate
 * for integration Hibernate and Spring technologys. For work with data base use hibernate criteria.
 * This technology provide as object oriented select query in relation to a particular entity, and
 * allows you to query the database without writing SQL code. Use Criteria is the most successful
 * approach to search interface with a variable number of conditions. To create copies of the Criteria
 * used class Session, which acts as a factory.
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
@Repository(value="userCorespondenceDAO")
public class UserCorespondenceDAOImpl extends CommonEntityDAOImpl implements UserCorespondenceDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceDAOImpl.class);
	
	@Transactional
	public Boolean isUniqueEmail(String email){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserCorespondence.class);
		criteria.add(Restrictions.eq("email", email));
		Boolean isUnique;
		try {
			if(!criteria.uniqueResult().equals(null)){
				isUnique = false;
				logger.info("UserCorespondenceDAO:User email is not unique.");
			}else{
				isUnique = true;
				logger.info("UserCorespondenceDAO:User email is unique.");
			}
		}catch (NullPointerException e){
			isUnique = true;
			logger.info("UserCorespondenceDAO:User email is unique.");
			
		}catch (NonUniqueResultException e) {
			isUnique=false;
			logger.info("UserCorespondenceDAO:User email is not unique.");
		}
		return isUnique;
	}
}
