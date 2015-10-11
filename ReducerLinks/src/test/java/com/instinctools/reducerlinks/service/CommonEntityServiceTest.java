/**
 * 
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
 * @author Zaerko_DV
 *
 */
public class CommonEntityServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(CommonEntityServiceTest.class);
//
//	@Inject
//	@Qualifier("commonEntityService")
//	private CommonEntityService commonEntityService;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public void setCommonEntityService(CommonEntityService commonEntityService) {
//		this.commonEntityService = commonEntityService;
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
//		logger.info("EntityServiceTest:Test entity save successfully.");
//		Assert.assertNotNull(commonEntityService.getEntityById(User.class, user.getIdUser()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingEntityById(){
//		Object entity=commonEntityService.getEntityById(User.class, user.getIdUser());
//		logger.info("EntityServiceTest:Test entity load by id successfully.");
//		Assert.assertNotNull(entity);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateEntity(){
//
//		user.setFirstName("testFirstName2");
//		commonEntityService.updateEntity(user);
//		final User updatedUser =(User) commonEntityService.getEntityById(User.class, user.getIdUser());	
//		logger.info("EntityServiceTest:Test entity update successfully.");
//		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntityById(){
//		commonEntityService.deleteEntityById(User.class, user.getIdUser());
//		logger.info("EntityServiceTest:Test entity delete by id successfully.");
//		Assert.assertNull(commonEntityService.getEntityById(User.class, user.getIdUser()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntity(){
//		commonEntityService.deleteEntity(user);
//		logger.info("EntityServiceTest:Test entity delete successfully.");
//		Assert.assertNull(commonEntityService.getEntityById(User.class, user.getIdUser()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllEntity(){
//		List<User> list = (List)commonEntityService.getAllEntity(User.class);
//		logger.info("EntityServiceTest:List of test entity load successfully.");
//		Assert.assertFalse(list.isEmpty());
//	}

}
