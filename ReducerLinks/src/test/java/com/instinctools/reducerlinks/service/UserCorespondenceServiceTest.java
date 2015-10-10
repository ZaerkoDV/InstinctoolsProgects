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
import com.instinctools.reducerlinks.model.UserCorespondence;

/**
 * @author Zaerko_DV
 *
 */
public class UserCorespondenceServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceServiceTest.class);
//	
//	@Inject
//	@Qualifier("userCorespondenceService")
//	private UserCorespondenceService userCorespondenceService;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
//	public void setUserCorespondenceService(UserCorespondenceService userCorespondenceService) {
//		this.userCorespondenceService = userCorespondenceService;
//	}
//
//	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
//		this.testObjectCreator = testObjectCreator;
//	}
//	
//	public UserCorespondence userCorespondence;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		this.userCorespondence=testObjectCreator.createUserCorespondence();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveUserCorespondence(){
//		
//		Assert.assertNotNull(userCorespondenceService
//				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserCorespondenceById(){
//		Object entity=userCorespondenceService
//				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence());
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateUserCorespondence(){
//
//		userCorespondence.setSkype("mytest.skype");
//		userCorespondenceService.updateEntity(userCorespondence);
//		final UserCorespondence updatedUserCorespondence =(UserCorespondence) userCorespondenceService.
//				getEntityById(UserCorespondence.class,userCorespondence.getIdUserCorespondence());	
//		Assert.assertTrue(updatedUserCorespondence.getSkype().equals("mytest.skype"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserCorespondenceById(){
//		userCorespondenceService.deleteEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence());
//		Assert.assertNull(userCorespondenceService
//				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserCorespondence(){
//		userCorespondenceService.deleteEntity(userCorespondence);
//		Assert.assertNull(userCorespondenceService
//				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllUserCorespondence(){
//		List<User> list = (List)userCorespondenceService.getAllEntity(UserCorespondence.class);
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnUniqueEmail(){
//		
//		Boolean isUnique;
//		isUnique=userCorespondenceService.isUniqueEmail(userCorespondence.getEmail());
//		Assert.assertFalse(isUnique);
//		
//		isUnique=userCorespondenceService.isUniqueEmail("unique@mail.ru");
//		Assert.assertTrue(isUnique);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnValidEmail(){
//		
//		Boolean isValidEmail;
//		
//		isValidEmail=userCorespondenceService.isValidEmail(userCorespondence.getEmail());
//		Assert.assertTrue(isValidEmail);
//		
//		isValidEmail=userCorespondenceService.isValidEmail("falsegmail.com");
//		Assert.assertFalse(isValidEmail);
//	}
}
