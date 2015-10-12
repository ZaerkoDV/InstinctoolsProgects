/**
 * @package com.instinctools.reducerlinks.service
 * 
 * Package com.instinctools.reducerlinks.service contain set of interfaces which description
 * service layer in ReducerLinks project.This project is based on MVC architecture.This inerface
 * perform class which is part of service layer in MVC architecture.This layer defines the
 * boundary of the application and a set of permitted operations. It encapsulates the business
 * logic of the application and controls the answers in the implementation of operations.
 * All classes which contain postfix “Service” provide to work Service for ReduceLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
 */
package com.instinctools.reducerlinks.service;

import java.util.List;

/**
 * <p>The interface CommonEntityService contain methods ads which realize in class CommonEntityServiceImpl.
 *  Class CommonEntityService use Service pattern which describes service layer of application. This class
 *  contain general operation to all classes.This interface contain ads methods which perform busness logic
 *  all application.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface CommonEntityService {
	
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity);
	public void saveEntity(Object entity);
	public void updateEntity(Object entity);
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity);
	public void deleteEntity(Object entity);
	public <T> List<Object> getAllEntity(Class<T> entityClass);
}
