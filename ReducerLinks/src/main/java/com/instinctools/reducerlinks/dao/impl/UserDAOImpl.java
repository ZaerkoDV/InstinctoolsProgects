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
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.dao.UserDAO;
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.LinkHistory;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * <p>The class UserDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model. Model for this dao layer
 * describied in class User. This class contain methods which intended to access to special
 * operation with user.Class extend ÑommonEntityDAOImpl class, which contain base set of
 * operation(CRUD). Class implements interface UserDAO located in package which have name
 * com.instinctools.reducerlinks.dao. All methods are public in class.For logging use framework
 * shell slf4j and framework log4j. Class contain also private, static variable logger, which
 * use to call log message.This class use Spring framework to work whith ORM. In particular
 * often use HibernateTemplate for integration Hibernate and Spring technologys. For work with
 * data base use hibernate criteria. This technology provide as object-oriented select query
 * in relation to a particular entity, and allows you to query the database without writing SQL
 * code. Use Criteria is the most successful approach to search interface with a variable number
 * of conditions. To create copies of the Criteria used class Session, which acts as a factory.
 *  
 * @see Collection
 * @see List
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see org.hibernate.Criteria
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 03.10.2015
 * @author Zaerko Denis
 */
@Repository(value="userDAO")
public class UserDAOImpl extends CommonEntityDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Transactional
	public User getUserByEmail(String email){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserCorespondence.class);
		criteria.setProjection(Projections.property("user"));
		criteria.add(Restrictions.eq("email", email));

		User user = null;
		try {
			user=(User)criteria.uniqueResult();
			logger.info("UserDAO:User by his email loaded sucessfully.");
		}catch (NullPointerException e){
			user= null;
			logger.info("UserDAO:User by his email not loaded.");
		}
		return user;
	}

	@Transactional
	public Long getIdUserByLoginPassword(String login,String password){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.createAlias("user", "u");
		criteria.setProjection(Projections.property("u.idUser"));
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));

		Long idUser;
		try {
			idUser = (Long)criteria.uniqueResult();	
			logger.info("UserDAO:User id loaded sucessfully by his login and password.");
			
		}catch (final NullPointerException e) {
			idUser = null;
			logger.info("UserDAO:User id not loaded by his login and password sucessfully.");
		}
		return idUser;
	}

	@Transactional
	public User getUserByLoginPassword(String login,String password){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.setProjection(Projections.property("user"));

		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));

		User user;
		try {
			user = (User)criteria.uniqueResult();
			logger.info("UserDAO:User loaded by his login and password sucessfully");
			
		}catch (final NullPointerException e) {
			user = null;
			logger.info("UserDAO:User not loaded by his login and password.");
		}
		return user;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getListUserByLastName(String lastName){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(User.class);
		criteria.add(Restrictions.eq("lastName", lastName));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);

		List<User> list;
		try {
			list= (List<User>)criteria.list();
			logger.info("UserDAO:List of users loaded sucessfully by his lastname.");
			
		} catch (NullPointerException e) {
			list=Collections.emptyList();
			logger.info("UserDAO:User loaded by his  lastname but list is empty.");
		}
		return list;
	}

	@Transactional
	public Boolean signInUserByLoginPassword(String login, String password){

		User user=null;
		Boolean signIn = null;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.setProjection(Projections.property("user"));

		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));

		try {
			user=(User) criteria.uniqueResult();
			logger.info("UserDAO:User "+user.getFirstName()+" sign in in system sucessfully");
			signIn=true;
		}catch (NullPointerException e) {
			signIn=false;
			logger.info("UserDAO:User not sign in in system.");
		}
		return signIn;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Link> getUserLinksSortByRecency(Long idUser){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(LinkHistory.class);
		criteria.setProjection(Projections.property("link"));
		
		criteria.createAlias("link", "l");
		criteria.createAlias("l.user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));

		criteria.addOrder(Order.desc("lastCreate"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);

		List<Link> list = null;
		try {
			list=(List<Link>)criteria.list();
			logger.info("UserDAO:Links list sort by recency loaded.");
		}catch (NullPointerException e){
			list = Collections.emptyList();
			logger.info("UserDAO:Links list sort by recency is empty.");
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserCorespondence> getListUserCorespondences(Long idUser){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserCorespondence.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);

		List<UserCorespondence> list=null;
		try {
			list=(List<UserCorespondence>)criteria.list();
			logger.info("UserDAO:List of user corespondences loaded.");
		}catch (NullPointerException e){
			list = Collections.emptyList();
			logger.info("UserDAO:List of user corespondences is empty.");
		}
		return list;
	}

	@Transactional
	public int getCountOfUser(){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(User.class);	
		int count;	
		try{
			count=(int)criteria.list().size();
			logger.info("UserDAO:Number of users in system loaded.");
			
		}catch(NullPointerException e){
			count= 0;
			logger.info("UserDAO:Number of users in system loaded and equals zero.");
		}
		return count;
	}

	@Transactional
	public String getUserRoleByUserId(Long idUser){
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.setProjection(Projections.property("role"));
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.idUser", idUser));
		
		String role;
		try {
			role=(String)criteria.uniqueResult();
			logger.info("UserDAO:User role by user id loaded.");
		}catch (NullPointerException e){
			role = null;
			logger.info("UserDAO:User role by user id not loaded.");
		}
		return role;
	}
}
