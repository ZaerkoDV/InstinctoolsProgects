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
		}catch (NullPointerException e){
			user= null;
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
		}catch (final NullPointerException e) {
			idUser = null;
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
		}catch (final NullPointerException e) {
			user = null;
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
		} catch (NullPointerException e) {
			list=Collections.emptyList();
		}
		return list;
	}
	
	@Transactional
	public Boolean signInUserByLoginPassword(String login, String password){
	
		Boolean signIn = false;
		User user=null;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.setProjection(Projections.property("user"));
		
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		
		try {
			user = (User)criteria.uniqueResult();
			signIn=true;	
			
		}catch (NullPointerException e) {
			signIn=false;
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
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("l.u.idUser", idUser));
		//criteria.add(Restrictions.eq("l.user.idUser", idUser));
		
		criteria.addOrder(Order.desc("lastCreate"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<Link> list = null;
		try {
			list=(List<Link>)criteria.list();
			
		}catch (NullPointerException e){
			list = Collections.emptyList();
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
		}catch (NullPointerException e){
			list = Collections.emptyList();
		}
		return null;
	}
	
	@Transactional
	public int getCountOfUser(){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(User.class);	
		int count;	
		try{
			count=(int)criteria.list().size();
		}catch(NullPointerException e){
			count= 0;
		}
		return count;
	}
	
}
