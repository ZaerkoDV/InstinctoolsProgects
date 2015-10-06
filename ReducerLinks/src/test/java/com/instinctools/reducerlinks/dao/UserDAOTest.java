/**
 * 
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
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
 */
public class UserDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

	@Inject
	@Qualifier("userDAO")
	private UserDAO userDAO;

	@Inject
	@Qualifier("testObjectCreator")								
	private TestObjectCreator testObjectCreator;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
		this.testObjectCreator = testObjectCreator;
	}

	public User user;

	@Before
	public void initObjectsBeforeTest(){
		this.user=testObjectCreator.createUserForTest();
	}

	//		@After 
	//		public void clearObjectsForTest(){
	//			testObjectCreator.deleteUserAfterTest(user.getIdUser());
	//		}

	@Transactional
	@Rollback(true)
	@Test
	public void testSaveUser(){
		Assert.assertNotNull(userDAO.getEntityById(User.class, user.getIdUser()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingUserById(){
		Object entity=userDAO.getEntityById(User.class, user.getIdUser());
		Assert.assertNotNull(entity);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateUser(){

		user.setFirstName("testFirstName2");
		userDAO.updateEntity(user);
		final User updatedUser =(User) userDAO.getEntityById(User.class, user.getIdUser());	
		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUserById(){
		userDAO.deleteEntityById(User.class, user.getIdUser());
		Assert.assertNull(userDAO.getEntityById(User.class, user.getIdUser()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteUser(){
		userDAO.deleteEntity(user);
		Assert.assertNull(userDAO.getEntityById(User.class, user.getIdUser()));
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAllUsers(){
		List<User> list = (List)userDAO.getAllEntity(User.class);
		Assert.assertFalse(list.isEmpty());
	}

}
