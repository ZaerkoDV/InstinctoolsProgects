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
public class UserSecurityeDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityeDAOTest.class);
	
	@Inject
	@Qualifier("userSecurityDAO")
	private UserSecurityDAO userSecurityDAO;

	@Inject
	@Qualifier("testObjectCreator")								
	private TestObjectCreator testObjectCreator;

	public void setUserSecurityDAO(UserSecurityDAO userSecurityDAO) {
		this.userSecurityDAO = userSecurityDAO;
	}

	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
		this.testObjectCreator = testObjectCreator;
	}
	
	public UserSecurity userSecurity;
	
	@Before
	public void initObjectsBeforeTest(){
		this.userSecurity=testObjectCreator.createUserSecurity();
	}
	
//	@After
//	public void clearObjectsAfterTest(){
//		testObjectCreator.deleteUserSecurityAfterTest(userSecurity.getIdUserSecurity());
//	}

	@Transactional
	@Rollback(true)
	@Test
	public void testSaveUserSecurity(){
		
		Assert.assertNotNull(userSecurityDAO
				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserSecurityById(){
		Object entity=userSecurityDAO
				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity());
		Assert.assertNotNull(entity);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateUserSecurity(){

		userSecurity.setRole("admin");
		userSecurityDAO.updateEntity(userSecurity);
		final UserSecurity updatedUserSecurity =(UserSecurity) userSecurityDAO.
				getEntityById(UserSecurity.class,userSecurity.getIdUserSecurity());	
		Assert.assertTrue(updatedUserSecurity.getRole().equals("admin"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUserSecurityById(){
		userSecurityDAO.deleteEntityById(UserSecurity.class, userSecurity.getIdUserSecurity());
		Assert.assertNull(userSecurityDAO
				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUserSecurity(){
		userSecurityDAO.deleteEntity(userSecurity);
		Assert.assertNull(userSecurityDAO
				.getEntityById(UserSecurity.class, userSecurity.getIdUserSecurity()));
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAllUserSecurity(){
		List<UserSecurity> list = (List)userSecurityDAO.getAllEntity(UserSecurity.class);
		Assert.assertFalse(list.isEmpty());
	}
}
