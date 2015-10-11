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
		logger.info("EntityService:Entity load by id successfully");
		return commonEntityDAO.getEntityById(entityClass, idEntity);
	}
	
	public void saveEntity(Object entity){
		logger.info("EntityService:Entity save successfully");
		commonEntityDAO.saveEntity(entity);
	}
	
	public void updateEntity(Object entity){
		logger.info("EntityService:Entity update successfully");
		commonEntityDAO.updateEntity(entity);
	}
	
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity){
		logger.info("EntityService:Entity delete by id successfully");
		commonEntityDAO.deleteEntityById(entityClass, idEntity);
	}
	
	public void deleteEntity(Object entity){
		logger.info("EntityService:Entity delete successfully");
		commonEntityDAO.deleteEntity(entity);
	}
	
	public <T> List<Object> getAllEntity(Class<T> entityClass){
		logger.info("EntityService:List of entity load successfully");
		return commonEntityDAO.getAllEntity(entityClass);
	}
}
