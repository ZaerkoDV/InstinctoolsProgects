/**
 * 
 */
package com.instinctools.reducerlinks.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.instinctools.reducerlinks.dao.CommonEntityDAO;
import com.instinctools.reducerlinks.dao.impl.CommonEntityDAOImpl;
import com.instinctools.reducerlinks.service.CommonEntityService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="commonEntityService")
public class CommonEntityServiceImpl implements CommonEntityService {

	private static final Logger logger = LoggerFactory.getLogger(CommonEntityServiceImpl.class);
	
	@Inject
	@Qualifier("commonEntityDAO")
	private CommonEntityDAO commonEntityDAO;

	public void setCommonEntityDAO(CommonEntityDAO commonEntityDAO) {
		this.commonEntityDAO = commonEntityDAO;
	}
	
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity) {
		return commonEntityDAO.getEntityById(entityClass, idEntity);
	}
	
	public void saveEntity(Object entity){
		commonEntityDAO.saveEntity(entity);
	}
	
	public void updateEntity(Object entity){
		commonEntityDAO.updateEntity(entity);
	}
	
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity){
		commonEntityDAO.deleteEntityById(entityClass, idEntity);
	}
	
	public void deleteEntity(Object entity){
		commonEntityDAO.deleteEntity(entity);
	}
	
	public <T> List<Object> getAllEntity(Class<T> entityClass){
		return commonEntityDAO.getAllEntity(entityClass);
	}

}
