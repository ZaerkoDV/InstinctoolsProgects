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

import com.instinctools.reducerlinks.dao.UserCorespondenceDAO;
import com.instinctools.reducerlinks.model.UserCorespondence;

/**
 * @author Zaerko_DV
 *
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
			}else{
				isUnique = true;
			}
		}catch (NullPointerException e){
			isUnique = true;
		}catch (NonUniqueResultException e) {
			isUnique=false;
		}
		return isUnique;
	}
}
