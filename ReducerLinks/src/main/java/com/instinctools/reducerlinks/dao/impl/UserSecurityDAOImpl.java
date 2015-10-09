/**
 * 
 */
package com.instinctools.reducerlinks.dao.impl;

import javax.persistence.NonUniqueResultException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.dao.UserSecurityDAO;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;
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
			}else{
				isUnique=true;
			}
		}catch (final NullPointerException e) {
			isUnique= true;
		}catch (NonUniqueResultException e) {
			isUnique=false;
		}
		return isUnique;
	}
}
