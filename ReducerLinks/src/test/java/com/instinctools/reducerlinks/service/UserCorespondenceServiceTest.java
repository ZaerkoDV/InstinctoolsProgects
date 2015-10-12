/**
 * @package com.instinctools.reducerlinks.service
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework.  
 */
package com.instinctools.reducerlinks.service;

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
 * Class UserCorespondenceServiceTest use to testing UserCorespondenceServiceImpl class which belong
 * to service layer. Class use Junit tests. To create test objects use method createObjectsForTest.That
 * method create new object for test and applying anatation Inject to get dependency injection. This
 * is realization of pattern IoC. All methods return void include initObjectsBeforeTest.All methods
 * use annotation Rollback to roll back transaction which created for test. Also in class use Assert.
 * These methods set assertion methods useful for writing tests.
 * 
 * @see org.springframework.transaction
 * @see javax.inject.Inject
 * @see org.slf4j
 * @see org.junit
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public class UserCorespondenceServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceServiceTest.class);
	
	@Inject
	@Qualifier("userCorespondenceService")
	private UserCorespondenceService userCorespondenceService;

	@Inject
	@Qualifier("testObjectCreator")								
	private TestObjectCreator testObjectCreator;
	
	public void setUserCorespondenceService(UserCorespondenceService userCorespondenceService) {
		this.userCorespondenceService = userCorespondenceService;
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
		
		logger.info("UserCorespondenceServiceTest:UserCorespondence save successfully.");
		Assert.assertNotNull(userCorespondenceService
				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserCorespondenceById(){
		Object entity=userCorespondenceService
				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence());
		logger.info("UserCorespondenceServiceTest:UserCorespondence load by id successfully.");
		Assert.assertNotNull(entity);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateUserCorespondence(){

		userCorespondence.setSkype("mytest.skype");
		userCorespondenceService.updateEntity(userCorespondence);
		final UserCorespondence updatedUserCorespondence =(UserCorespondence) userCorespondenceService.
				getEntityById(UserCorespondence.class,userCorespondence.getIdUserCorespondence());	
		
		logger.info("UserCorespondenceServiceTest:UserCorespondence update successfully.");
		Assert.assertTrue(updatedUserCorespondence.getSkype().equals("mytest.skype"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUserCorespondenceById(){
		
		userCorespondenceService.deleteEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence());
		logger.info("UserCorespondenceServiceTest:UserCorespondence delete by id successfully.");
		Assert.assertNull(userCorespondenceService
				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUserCorespondence(){
		
		userCorespondenceService.deleteEntity(userCorespondence);
		logger.info("UserCorespondenceServiceTest:UserCorespondence delete successfully.");
		Assert.assertNull(userCorespondenceService
				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAllUserCorespondence(){
		List<User> list = (List)userCorespondenceService.getAllEntity(UserCorespondence.class);
		logger.info("UserCorespondenceServiceTest:List of UserCorespondence load successfully.");
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnUniqueEmail(){
		
		Boolean isUnique;
		isUnique=userCorespondenceService.isUniqueEmail(userCorespondence.getEmail());
		Assert.assertFalse(isUnique);
		isUnique=userCorespondenceService.isUniqueEmail("unique@mail.ru");
		Assert.assertTrue(isUnique);
		
		logger.info("UserCorespondenceServiceTest:Cheack email in unique value completed.");
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnValidEmail(){
		
		Boolean isValidEmail;
		isValidEmail=userCorespondenceService.isValidEmail(userCorespondence.getEmail());
		Assert.assertTrue(isValidEmail);
		isValidEmail=userCorespondenceService.isValidEmail("falsegmail.com");
		Assert.assertFalse(isValidEmail);
		
		logger.info("UserCorespondenceServiceTest:Cheack email on valid value completed.");
	}
}
