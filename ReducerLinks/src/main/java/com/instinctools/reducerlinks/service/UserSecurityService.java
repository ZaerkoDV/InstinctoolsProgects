/**
 * 
 */
package com.instinctools.reducerlinks.service;

/**
 * @author Zaerko_DV
 *
 */
public interface UserSecurityService extends CommonEntityService {

	public Boolean isUniqueLoginPassword(String login, String password);
}
