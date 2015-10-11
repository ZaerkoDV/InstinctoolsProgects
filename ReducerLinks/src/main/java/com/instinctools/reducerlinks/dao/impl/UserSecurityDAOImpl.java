/**
 * 
 */
package com.instinctools.reducerlinks.dao.impl;

import javax.persistence.NonUniqueResultException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.dao.UserSecurityDAO;
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
 */
@Repository(value="userSecurityDAO")
public class UserSecurityDAOImpl extends CommonEntityDAOImpl implements UserSecurityDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityDAOImpl.class);

	@Transactional
	public Boolean isUniqueLoginPassword(String login, String password){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(UserSecurity.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));

		Boolean isUnique = null;
		try {
			if(!criteria.uniqueResult().equals(null)){;
				isUnique = false;
				logger.info("UserSecurityDAO: Login and password isn't unique.");
			}else{
				isUnique=true;
				logger.info("UserSecurityDAO: Login and password is unique.");
			}
		}catch (final NullPointerException e) {
			isUnique= true;
			logger.info("UserSecurityDAO: Login and password is unique.");
			
		}catch (NonUniqueResultException e) {
			isUnique=false;
			logger.info("UserSecurityDAO: Login and password isn't unique.");
		}
		return isUnique;
	}
}
