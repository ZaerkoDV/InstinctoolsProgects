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
import com.instinctools.reducerlinks.model.UserCorespondence;

/**
 * Class UserCorespondenceDAOTest use to testing UserCorespondenceDAOImpl class which belong to dao
 * layer. Class use Junit tests. To create test objects use method createObjectsForTest.That method
 * create new object for test and applying anatation Inject to get dependency injection. This is
 * realization of pattern IoC. All methods return void include initObjectsBeforeTest.All methods use
 * annotation Rollback to roll back transaction which created for test. Also in class use Assert.
 * These methods set assertion methods useful for writing tests.
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
public class UserCorespondenceDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceDAOTest.class);
	
	@Inject
	@Qualifier("userCorespondenceDAO")
	private UserCorespondenceDAO userCorespondenceDAO;

	@Inject
	@Qualifier("testObjectCreator")								
	private TestObjectCreator testObjectCreator;
	
	public void setUserCorespondenceDAO(UserCorespondenceDAO userCorespondenceDAO) {
		this.userCorespondenceDAO = userCorespondenceDAO;
	}

	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
		this.testObjectCreator = testObjectCreator;
	}
	
	public UserCorespondence userCorespondence;
	
	@Before
	public void initObjectsBeforeTest(){
		this.userCorespondence=testObjectCreator.createUserCorespondence();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSaveUserCorespondence(){
		
		logger.info("UserCorespondenceDAOTest:Test user corespondence save successfully.");
		Assert.assertNotNull(userCorespondenceDAO
				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserCorespondenceById(){
		Object entity=userCorespondenceDAO
				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence());
		logger.info("UserCorespondenceDAOTest:Test user corespondence load by id successfully.");
		Assert.assertNotNull(entity);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateUserCorespondence(){

		userCorespondence.setSkype("mytest.skype");
		userCorespondenceDAO.updateEntity(userCorespondence);
		
		final UserCorespondence updatedUserCorespondence =(UserCorespondence) userCorespondenceDAO.
				getEntityById(UserCorespondence.class,userCorespondence.getIdUserCorespondence());	
		logger.info("UserCorespondenceDAOTest:Test user corespondence update successfully.");
		Assert.assertTrue(updatedUserCorespondence.getSkype().equals("mytest.skype"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUserCorespondenceById(){
		userCorespondenceDAO.deleteEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence());
		logger.info("UserCorespondenceDAOTest:Test user corespondence delete by id successfully.");
		Assert.assertNull(userCorespondenceDAO
				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUserCorespondence(){
		userCorespondenceDAO.deleteEntity(userCorespondence);
		logger.info("UserCorespondenceDAOTest:Test user corespondence delete successfully.");
		Assert.assertNull(userCorespondenceDAO
				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAllUserCorespondence(){
		List<User> list = (List)userCorespondenceDAO.getAllEntity(UserCorespondence.class);
		logger.info("UserCorespondenceDAOTest:List of test user corespondence load successfully.");
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnUniqueEmail(){
		
		Boolean isUnique;
		isUnique=userCorespondenceDAO.isUniqueEmail(userCorespondence.getEmail());
		Assert.assertFalse(isUnique);
		
		isUnique=userCorespondenceDAO.isUniqueEmail("unique@mail.ru");
		Assert.assertTrue(isUnique);
		logger.info("UserCorespondenceDAOTest:Test email successfully completed.");
	}
}
