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
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.LinkHistory;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * Class UserDAOTest use to testing UserDAOImpl class which belong to dao layer. Class use Junit
 * tests. To create test objects use method createObjectsForTest.That method create new object for
 * test and applying anatation Inject to get dependency injection. This is realization of pattern IoC.
 * All methods return void include initObjectsBeforeTest.All methods use annotation Rollback to roll
 * back transaction which created for test. Also in class use Assert. These methods set assertion
 * methods useful for writing tests.
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
public class UserDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
//
//	@Inject
//	@Qualifier("userDAO")
//	private UserDAO userDAO;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public void setUserDAO(UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
//
//	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
//		this.testObjectCreator = testObjectCreator;
//	}
//
//	public User user;
//	public UserCorespondence userCorespondence;
//	public UserSecurity userSecurity;
//	public LinkHistory linkHistory;
//
//	@Before
//	public void initObjectsBeforeTest(){
//		
//		this.userCorespondence=testObjectCreator.createUserCorespondence();
//		this.user=userCorespondence.getUser();
//		this.userSecurity=testObjectCreator.createUserSecurity();
//		this.linkHistory=testObjectCreator.createLinkHistoryForTest();
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveUser(){
//		logger.info("UserDAOTest:Test user save successfully.");
//		Assert.assertNotNull(userDAO.getEntityById(User.class, user.getIdUser()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserById(){
//		Object entity=userDAO.getEntityById(User.class, user.getIdUser());
//		logger.info("UserDAOTest:Test user load by id successfully.");
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateUser(){
//
//		user.setFirstName("testFirstName2");
//		userDAO.updateEntity(user);
//		final User updatedUser =(User) userDAO.getEntityById(User.class, user.getIdUser());	
//		logger.info("UserDAOTest:Test user update successfully.");
//		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserById(){
//		userDAO.deleteEntityById(User.class, user.getIdUser());
//		logger.info("UserDAOTest:Test user delete by id successfully.");
//		Assert.assertNull(userDAO.getEntityById(User.class, user.getIdUser()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUser(){
//		userDAO.deleteEntity(user);
//		logger.info("UserDAOTest:Test user delete successfully.");
//		Assert.assertNull(userDAO.getEntityById(User.class, user.getIdUser()));
//	}
//
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllUsers(){
//		List<User> list = (List)userDAO.getAllEntity(User.class);
//		logger.info("UserDAOTest:List of test user load successfully.");
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserByEmail(){
//
//		User userByEmail=userDAO.getUserByEmail(userCorespondence.getEmail());
//		Assert.assertNotNull(userByEmail);
//		userByEmail=userDAO.getUserByEmail("same@gmail.com");
//		Assert.assertNull(userByEmail);
//		logger.info("UserDAOTest:User load by his email successfully.");
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingIdUserByLoginPassword(){
//
//		testObjectCreator.deleteUserCorespondenceAfterTest(userCorespondence.getIdUserCorespondence());
//		
//		//login and password exist.
//		String login=userSecurity.getLogin();
//		String password=userSecurity.getPassword();
//		Long idUser=userDAO.getIdUserByLoginPassword(login,password);
//		Assert.assertNotNull(idUser);
//		
//		//login and password not exist
//		login="falseLogin";
//		password="falsePassword";
//		idUser=userDAO.getIdUserByLoginPassword(login,password);
//		Assert.assertNull(idUser);
//		
//		logger.info("UserDAOTest:Id test user load by login and password successfully.");
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserByLoginPassword(){
//
//		testObjectCreator.deleteUserCorespondenceAfterTest(userCorespondence.getIdUserCorespondence());
//		
//		//login and password exist.
//		String login=userSecurity.getLogin();
//		String password=userSecurity.getPassword();
//		User user=userDAO.getUserByLoginPassword(login,password);
//		Assert.assertNotNull(user);
//
//		//login and password not exist
//		login="falseLogin";
//		password="falsePassword";
//		user=userDAO.getUserByLoginPassword(login,password);
//		Assert.assertNull(user);
//		
//		logger.info("UserDAOTest:Test user load by login and password successfully.");
//	}
//		
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserByLastName(){
//
//		List<User> userList=userDAO.getListUserByLastName(user.getLastName());
//		Assert.assertFalse(userList.isEmpty());
//
//		userList=userDAO.getListUserByLastName("sameLastName");
//		Assert.assertTrue(userList.isEmpty());
//		
//		logger.info("UserDAOTest:List of test users load successfully.");
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnSignInUserByLoginPassword(){
//
//		testObjectCreator.deleteUserCorespondenceAfterTest(userCorespondence.getIdUserCorespondence());
//		//login and password exist.
//		String login=userSecurity.getLogin();
//		String password=userSecurity.getPassword();
//		Assert.assertTrue(userDAO.signInUserByLoginPassword(login,password));
//
//		//login and password not exist
//		String login2="falseLogin";
//		String password2="falsePassword";
//		Assert.assertFalse(userDAO.signInUserByLoginPassword(login2,password2));
//		
//		logger.info("UserDAOTest:Sign in user in system successfully completed.");
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserLinksSortByRecency(){
//
//		testObjectCreator.deleteUserCorespondenceAfterTest(userCorespondence.getIdUserCorespondence());
//		testObjectCreator.deleteUserSecurityAfterTest(userSecurity.getIdUserSecurity());
//		
//		Long idUser=linkHistory.getLink().getUser().getIdUser();
//		List<Link> userList=userDAO.getUserLinksSortByRecency(idUser);
//		Assert.assertFalse(userList.isEmpty());
//
//		idUser=(long)20;
//		userList=userDAO.getUserLinksSortByRecency(idUser);
//		Assert.assertTrue(userList.isEmpty());
//		logger.info("UserDAOTest:List of user links sort by recency load successfully.");
//	}
//		
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserCorespondences(){
//
//		testObjectCreator.deleteLinkHistoryAfterTest(linkHistory.getIdLinkHistory());
//		testObjectCreator.deleteUserSecurityAfterTest(userSecurity.getIdUserSecurity());
//		
//		List<UserCorespondence> userCorespondenceList;
//		userCorespondenceList=userDAO.getListUserCorespondences(user.getIdUser());
//		Assert.assertFalse(userCorespondenceList.isEmpty());
//		userCorespondenceList=userDAO.getListUserCorespondences((long)20);
//		Assert.assertTrue(userCorespondenceList.isEmpty());
//		
//		logger.info("UserDAOTest:List of user corespondence load successfully.");
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGetingUserCount(){
//
//		int expected=(int)3;
//		int actual=userDAO.getCountOfUser();
//		Assert.assertEquals(expected,actual);
//		
//		logger.info("UserDAOTest:Number of users in system load successfully.");
//	}
}
