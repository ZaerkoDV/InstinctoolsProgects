/**
 * @package com.instinctools.reducerlinks.dao
 * 
 * Package com.instinctools.reducerlinks.dao contain set of classes and interfaces which description
 * layer of data access object in ReduserLinks project. This project is based on MVC architecture.
 * This class is part of dao layer in MVC architecture. This layer offer abstract interface for work
 * with any type data base. This pattern give a chance work with DAO (data-access-object) without matter
 * what kind of storage engine is used and without need for a special way to match this storage engine.
 * All classes which contain word"DAO"provide to work DAL for ReducerLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need to use information
 * or have any questions.  
 */
package com.instinctools.reducerlinks.dao;

/**
 * <p>The interface UserSecurityDAO contain methods ads which realize in class UserSecurityDAOImpl.
 * Class UserSecurityDAOImpl use DAO pattern which describes layer of data access to object. DAO
 * layer perform link between relational and object model. Model for this dao layer describied in
 * class UserSecurity.This interface contain ads methods which intended to access operation with
 * object. Interface produce special operation with object.Base operation (for any object) include
 * as separate interface CommonEntityDAO which extend to this interface. Class use Spring framework
 * to work whith ORM.In particular often use HibernateTemplate for integration Hibernate and Spring
 * technologys. For work with data base use hibernate criteria. 
 * 
 * @version 1.0 03.10.2015
 * @author Zaerko Denis
 */
public interface UserSecurityDAO extends CommonEntityDAO {
	public Boolean isUniqueLoginPassword(String login, String password);
}
