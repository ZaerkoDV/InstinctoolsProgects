/**
 * 
 */
package com.instinctools.reducerlinks.dao;

/**
 * @author Zaerko_DV
 *
 */
public interface UserCorespondenceDAO extends CommonEntityDAO {

	public Boolean isUniqueEmail(String email);
}
