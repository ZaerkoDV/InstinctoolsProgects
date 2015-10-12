/**
 * @package com.instinctools.reducerlinks.service.impl
 * 
 * Package com.instinctools.reducerlinks.service.impl contain set of class which description
 * service layer in ReducerLinks project. This project based on MVC architecture.This class
 * is part of service layer in MVC architecture.This layer defines the boundary of the application
 * and a set of permitted operations. It encapsulates the business logic of the application
 * and controls the answers in the implementation of operations. All classes which contain
 * postfix “Service” provide to work Service for ReducerLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
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
 * <p>The class CommonEntityServiceImpl use Service pattern which describes business logic of
 * application ReducerLinks.Service layer perform link between, presentation layer and DAO layer.
 * This layer is the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes base operation
 * with any entity.This class is general for all classes in service layer.All classes in this
 * layer extend this class and expand base operation which contain in. Class implements interface
 * CommonEntityService which perform all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework anatation to work
 * with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
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
