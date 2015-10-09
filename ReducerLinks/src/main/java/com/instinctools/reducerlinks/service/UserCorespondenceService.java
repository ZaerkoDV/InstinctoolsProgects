/**
 * 
 */
package com.instinctools.reducerlinks.service;

/**
 * @author Zaerko_DV
 *
 */
public interface UserCorespondenceService extends CommonEntityService {

	public Boolean isUniqueEmail(String email);
	public Boolean isValidEmail(String email);
}
