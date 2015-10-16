/**
 * @package com.instinctools.reducerlinks.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework.  
 */
package com.instinctools.reducerlinks.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.instinctools.reducerlinks.TestObjectCreator;
import com.instinctools.reducerlinks.TestStarter;
import com.instinctools.reducerlinks.model.User;

/**
 * Class CommonEntityDAOTest use to testing CommonEntityDAOImpl class(use intrface CommonEntityDAO)
 * which belong to dao layer.Class use Junit tests. To create test objects use method createObjectsForTest.
 * That method create new object for test and applying anatation Inject to get dependency injection.
 * This is realization of pattern IoC. All methods return void include initObjectsBeforeTest.All
 * methods use annotation Rollback to roll back transaction which created for test. Also in class
 * use Assert. These  methods set assertion methods useful for writing tests.
 * 
 * @see org.springframework.transaction
 * @see javax.inject.Inject
 * @see org.slf4j
 * @see org.junit
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 03.10.2015
 * @author Zaerko Denis
 */
public class CommonEntityDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(CommonEntityDAOTest.class);
//	
//	@Inject
//	@Qualifier("commonEntityDAO")
//	private CommonEntityDAO commonEntityDAO;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
//	public void setCommonEntityDAO(CommonEntityDAO commonEntityDAO) {
//		this.commonEntityDAO = commonEntityDAO;
//	}
//
//	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
//		this.testObjectCreator = testObjectCreator;
//	}
//	
//	public User user;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		this.user=testObjectCreator.createUserForTest();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveEntity(){
//		logger.info("EntityDAOTest:Test entity save sucessfully.");
//		Assert.assertNotNull(commonEntityDAO.getEntityById(User.class, user.getIdUser()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingEntityById(){
//		Object entity=commonEntityDAO.getEntityById(User.class, user.getIdUser());
//		logger.info("EntityDAOTest:Test entity loaded sucessfully.");
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateEntity(){
//
//		user.setFirstName("testFirstName2");
//		commonEntityDAO.updateEntity(user);
//		
//		final User updatedUser =(User) commonEntityDAO.getEntityById(User.class, user.getIdUser());	
//		logger.info("EntityDAOTest:Test entity update sucessfully.");
//		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntityById(){
//		commonEntityDAO.deleteEntityById(User.class, user.getIdUser());
//		logger.info("EntityDAOTest:Test entity delete by id sucessfully.");
//		Assert.assertNull(commonEntityDAO.getEntityById(User.class, user.getIdUser()));
//	}
//	
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntity(){
//		commonEntityDAO.deleteEntity(user);
//		logger.info("EntityDAOTest:Test entity delete sucessfully.");
//		Assert.assertNull(commonEntityDAO.getEntityById(User.class, user.getIdUser()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllEntity(){
//		List<User> list = (List)commonEntityDAO.getAllEntity(User.class);
//		logger.info("EntityDAOTest:List test entity loaded sucessfully.");
//		Assert.assertFalse(list.isEmpty());
//	}
}
