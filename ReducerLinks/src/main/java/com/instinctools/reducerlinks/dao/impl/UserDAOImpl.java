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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.dao.UserDAO;
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.LinkHistory;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
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

}
