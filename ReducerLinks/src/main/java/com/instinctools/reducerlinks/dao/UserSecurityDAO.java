/**
 * 
 */
package com.instinctools.reducerlinks.dao;

/**
 * @author Zaerko_DV
 *
 */
public interface UserSecurityDAO extends CommonEntityDAO {
	public Boolean isUniqueLoginPassword(String login, String password);
}
