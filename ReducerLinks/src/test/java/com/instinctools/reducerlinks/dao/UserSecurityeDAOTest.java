/**
 * 
 */
package com.instinctools.reducerlinks.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
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
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
 */
public class UserSecurityeDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserSecurityeDAOTest.class);
//	
//	@Inject
//	@Qualifier("userSecurityDAO")
//	private UserSecurityDAO userSecurityDAO;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public void setUserSecurityDAO(UserSecurityDAO userSecurityDAO) {
//		this.userSecurityDAO = userSecurityDAO;
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
//		logger.info("UserSecurityeDAOTest:Test user security feature save successfully.");
//		Assert.assertNotNull(userSecurityDAO
//				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserSecurityById(){
//		Object entity=userSecurityDAO
//				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity());
//		logger.info("UserSecurityeDAOTest:Test user security feature load by id successfully.");
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateUserSecurity(){
//
//		userSecurity.setRole("admin");
//		userSecurityDAO.updateEntity(userSecurity);
//		final UserSecurity updatedUserSecurity =(UserSecurity) userSecurityDAO.
//				getEntityById(UserSecurity.class,userSecurity.getIdUserSecurity());	
//		logger.info("UserSecurityeDAOTest:Test user security feature update successfully.");
//		Assert.assertTrue(updatedUserSecurity.getRole().equals("admin"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserSecurityById(){
//		userSecurityDAO.deleteEntityById(UserSecurity.class, userSecurity.getIdUserSecurity());
//		logger.info("UserSecurityeDAOTest:Test user security feature delete by id successfully.");
//		Assert.assertNull(userSecurityDAO
//				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserSecurity(){
//		userSecurityDAO.deleteEntity(userSecurity);
//		logger.info("UserSecurityeDAOTest:Test user security feature delete successfully.");
//		Assert.assertNull(userSecurityDAO
//				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllUserSecurity(){
//		List<UserSecurity> list = (List)userSecurityDAO.getAllEntity(UserSecurity.class);
//		logger.info("UserSecurityeDAOTest:List of test user security feature load successfully.");
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
//		isUnique=userSecurityDAO.isUniqueLoginPassword(login,password);
//		Assert.assertFalse(isUnique);
//		
//		login="falseLogin";
//		password="falsePassword";
//		isUnique=userSecurityDAO.isUniqueLoginPassword(login,password);
//		Assert.assertTrue(isUnique);
//		
//		logger.info("UserSecurityeDAOTest:Test user login and password on unique are successfully completed.");
//	}	
}
