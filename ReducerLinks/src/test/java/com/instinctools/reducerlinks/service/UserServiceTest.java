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
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.LinkHistory;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * Class UserServiceTest use to testing UserServiceImpl class which belong to service layer. Class use
 * Junit tests. To create test objects use method createObjectsForTest.That method create new object
 * for test and applying anatation Inject to get dependency injection. This is realization of pattern
 * IoC. All methods return void include initObjectsBeforeTest.All methods use annotation Rollback to
 * roll back transaction which created for test. Also in class use Assert. These methods set assertion
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
public class UserServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
//
//	@Inject
//	@Qualifier("userService")
//	private UserService userService;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
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
//		this.userCorespondence=testObjectCreator.createUserCorespondence();
//		this.user=userCorespondence.getUser();
//		
//		this.userSecurity=testObjectCreator.createUserSecurity();
//		this.linkHistory=testObjectCreator.createLinkHistoryForTest();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveUser(){
//		
//		logger.info("UserServiceTest:User save successfully.");
//		Assert.assertNotNull(userService.getEntityById(User.class, user.getIdUser()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserById(){
//		Object entity=userService.getEntityById(User.class, user.getIdUser());
//		logger.info("UserServiceTest:User load by id successfully.");
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateUser(){
//
//		user.setFirstName("testFirstName2");
//		userService.updateEntity(user);
//		final User updatedUser =(User) userService.getEntityById(User.class, user.getIdUser());	
//		logger.info("UserServiceTest:User update successfully.");
//		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserById(){
//		userService.deleteEntityById(User.class, user.getIdUser());
//		logger.info("UserServiceTest:User delete by id successfully.");
//		Assert.assertNull(userService.getEntityById(User.class, user.getIdUser()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUser(){
//		userService.deleteEntity(user);
//		logger.info("UserServiceTest:User delete successfully.");
//		Assert.assertNull(userService.getEntityById(User.class, user.getIdUser()));
//	}
//
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllUsers(){
//		List<User> list = (List)userService.getAllEntity(User.class);
//		logger.info("UserServiceTest:List of user load successfully.");
//		Assert.assertFalse(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserByEmail(){
//
//		User userByEmail=userService.getUserByEmail(userCorespondence.getEmail());
//		Assert.assertNotNull(userByEmail);
//		userByEmail=userService.getUserByEmail("same@gmail.com");
//		Assert.assertNull(userByEmail);
//		logger.info("UserServiceTest:User load by his email.");
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingIdUserByLoginPassword(){
//
//		testObjectCreator.deleteUserCorespondenceAfterTest(userCorespondence.getIdUserCorespondence());
//		//login and password exist.
//		String login=userSecurity.getLogin();
//		String password=userSecurity.getPassword();
//		Long idUser=userService.getIdUserByLoginPassword(login,password);
//		Assert.assertNotNull(idUser);
//		//login and password not exist
//		login="falseLogin";
//		password="falsePassword";
//		idUser=userService.getIdUserByLoginPassword(login,password);
//		Assert.assertNull(idUser);
//		
//		logger.info("UserServiceTest:User id load by login and password.");
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
//		User user=userService.getUserByLoginPassword(login,password);
//		Assert.assertNotNull(user);
//		//login and password not exist
//		login="falseLogin";
//		password="falsePassword";
//		user=userService.getUserByLoginPassword(login,password);
//		Assert.assertNull(user);
//		
//		logger.info("UserServiceTest:User load by login and password.");
//	}
//		
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListUserByLastName(){
//
//		List<User> userList=userService.getListUserByLastName(user.getLastName());
//		Assert.assertFalse(userList.isEmpty());
//		userList=userService.getListUserByLastName("sameLastName");
//		Assert.assertTrue(userList.isEmpty());
//		
//		logger.info("UserServiceTest:List of users load by last name.");
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
//		Assert.assertTrue(userService.signInUserByLoginPassword(login,password));
//
//		//login and password not exist
//		login="falseLogin";
//		password="falsePassword";
//		Assert.assertFalse(userService.signInUserByLoginPassword(login,password));
//		
//		logger.info("UserServiceTest:Operation sign in by login and password completed.");
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
//		List<Link> userList=userService.getUserLinksSortByRecency(idUser);
//		Assert.assertFalse(userList.isEmpty());
//
//		idUser=(long)20;
//		userList=userService.getUserLinksSortByRecency(idUser);
//		Assert.assertTrue(userList.isEmpty());
//		
//		logger.info("UserServiceTest:List of user link load successfully.");
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
//		userCorespondenceList=userService.getListUserCorespondences(user.getIdUser());
//		Assert.assertFalse(userCorespondenceList.isEmpty());
//		userCorespondenceList=userService.getListUserCorespondences((long)20);
//		Assert.assertTrue(userCorespondenceList.isEmpty());
//		
//		logger.info("UserServiceTest:List of user corespondene load successfully.");
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGetingUserCount(){
//
//		int expected=(int)3;
//		int actual=userService.getCountOfUser();
//		Assert.assertEquals(expected,actual);
//		logger.info("UserServiceTest:Number of users in system load.");
//	}	
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGetingUserRoleByUserId(){
//
//		String actual=userService.getUserRoleByUserId(user.getIdUser());
//		String expected="user";
//		Assert.assertEquals(expected,actual);
//		
//		logger.info("UserServiceTest:User role download successfully.");
//	}
}
