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
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
 */
public class UserSecurityeServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserSecurityeServiceTest.class);
//
//	@Inject
//	@Qualifier("userSecurityService")
//	private UserSecurityService userSecurityService;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public void setUserSecurityService(UserSecurityService userSecurityService) {
//		this.userSecurityService = userSecurityService;
//	}
//
//	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
//		this.testObjectCreator = testObjectCreator;
//	}
//
//	public UserSecurity userSecurity;
//
//	@Before
//	public void initObjectsBeforeTest(){
//		this.userSecurity=testObjectCreator.createUserSecurity();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveUserSecurity(){
//		
//		logger.info("UserSecurityeServiceTest:UserSecurity save successfully.");
//		Assert.assertNotNull(userSecurityService
//				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserSecurityById(){
//		Object entity=userSecurityService
//				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity());
//		logger.info("UserSecurityeServiceTest:UserSecurity load by id successfully.");
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateUserSecurity(){
//
//		userSecurity.setRole("admin");
//		userSecurityService.updateEntity(userSecurity);
//		final UserSecurity updatedUserSecurity =(UserSecurity) userSecurityService.
//				getEntityById(UserSecurity.class,userSecurity.getIdUserSecurity());	
//		
//		logger.info("UserSecurityeServiceTest:UserSecurity update successfully.");
//		Assert.assertTrue(updatedUserSecurity.getRole().equals("admin"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserSecurityById(){
//		
//		userSecurityService.deleteEntityById(UserSecurity.class, userSecurity.getIdUserSecurity());
//		logger.info("UserSecurityeServiceTest:UserSecurity delete by id successfully.");
//		Assert.assertNull(userSecurityService
//				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserSecurity(){
//		
//		userSecurityService.deleteEntity(userSecurity);
//		logger.info("UserSecurityeServiceTest:UserSecurity delete successfully.");
//		Assert.assertNull(userSecurityService
//				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllUserSecurity(){
//		List<UserSecurity> list = (List)userSecurityService.getAllEntity(UserSecurity.class);
//		logger.info("UserSecurityeServiceTest:List of UserSecurity load successfully.");
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnUniqueLoginPassword(){
//		
//		Boolean isUnique;
//		String login=userSecurity.getLogin();
//		String password=userSecurity.getPassword();
//		isUnique=userSecurityService.isUniqueLoginPassword(login,password);
//		Assert.assertFalse(isUnique);
//		
//		login="falseLogin";
//		password="falsePassword";
//		isUnique=userSecurityService.isUniqueLoginPassword(login,password);
//		Assert.assertTrue(isUnique);
//		
//		logger.info("UserSecurityeServiceTest:Check login and password on unique value completed.");
//	}	
}
