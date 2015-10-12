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

/**
 * Class CommonEntityServiceTest use to testing CommonEntityServiceImpl class(use intrface CommonEntityService)
 * which belong to service layer.Class use Junit tests. To create test objects use method createObjectsForTest.
 * That method create new object for test and applying anatation Inject to get dependency injection. This is
 * realization of pattern IoC. All methods return void include initObjectsBeforeTest.All methods use annotation
 * Rollback to roll back transaction which created for test. Also in class use Assert. These  methods set assertion
 * methods useful for writing tests.
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
public class CommonEntityServiceTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(CommonEntityServiceTest.class);

	@Inject
	@Qualifier("commonEntityService")
	private CommonEntityService commonEntityService;

	@Inject
	@Qualifier("testObjectCreator")								
	private TestObjectCreator testObjectCreator;

	public void setCommonEntityService(CommonEntityService commonEntityService) {
		this.commonEntityService = commonEntityService;
	}

	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
		this.testObjectCreator = testObjectCreator;
	}

	public User user;

	@Before
	public void initObjectsBeforeTest(){
		this.user=testObjectCreator.createUserForTest();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSaveEntity(){
		logger.info("EntityServiceTest:Test entity save successfully.");
		Assert.assertNotNull(commonEntityService.getEntityById(User.class, user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingEntityById(){
		Object entity=commonEntityService.getEntityById(User.class, user.getIdUser());
		logger.info("EntityServiceTest:Test entity load by id successfully.");
		Assert.assertNotNull(entity);
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateEntity(){

		user.setFirstName("testFirstName2");
		commonEntityService.updateEntity(user);
		final User updatedUser =(User) commonEntityService.getEntityById(User.class, user.getIdUser());	
		logger.info("EntityServiceTest:Test entity update successfully.");
		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteEntityById(){
		commonEntityService.deleteEntityById(User.class, user.getIdUser());
		logger.info("EntityServiceTest:Test entity delete by id successfully.");
		Assert.assertNull(commonEntityService.getEntityById(User.class, user.getIdUser()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteEntity(){
		commonEntityService.deleteEntity(user);
		logger.info("EntityServiceTest:Test entity delete successfully.");
		Assert.assertNull(commonEntityService.getEntityById(User.class, user.getIdUser()));
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAllEntity(){
		List<User> list = (List)commonEntityService.getAllEntity(User.class);
		logger.info("EntityServiceTest:List of test entity load successfully.");
		Assert.assertFalse(list.isEmpty());
	}
}
