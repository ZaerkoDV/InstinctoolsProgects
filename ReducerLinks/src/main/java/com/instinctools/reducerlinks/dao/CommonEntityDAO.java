/**
 * 
 */
package com.instinctools.reducerlinks.dao;

import java.util.List;

/**
 * @author Zaerko_DV
 *
 */
public interface CommonEntityDAO  {

	public <T> Object getEntityById(Class<T> entityClass,Long idEntity);
	public void saveEntity(Object entity);
	public void updateEntity(Object entity);
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity);
	public void deleteEntity(Object entity);
	public <T> List<Object> getAllEntity(Class<T> entityClass);
	
}
