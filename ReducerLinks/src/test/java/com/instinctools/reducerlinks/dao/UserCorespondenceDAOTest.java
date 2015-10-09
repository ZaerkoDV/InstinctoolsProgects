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
import com.instinctools.reducerlinks.model.UserCorespondence;

/**
 * @author Zaerko_DV
 *
 */
public class UserCorespondenceDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceDAOTest.class);
//	
//	@Inject
//	@Qualifier("userCorespondenceDAO")
//	private UserCorespondenceDAO userCorespondenceDAO;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
//	public void setUserCorespondenceDAO(UserCorespondenceDAO userCorespondenceDAO) {
//		this.userCorespondenceDAO = userCorespondenceDAO;
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
//		Assert.assertNotNull(userCorespondenceDAO
//				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingUserCorespondenceById(){
//		Object entity=userCorespondenceDAO
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
//		userCorespondenceDAO.updateEntity(userCorespondence);
//		final UserCorespondence updatedUserCorespondence =(UserCorespondence) userCorespondenceDAO.
//				getEntityById(UserCorespondence.class,userCorespondence.getIdUserCorespondence());	
//		Assert.assertTrue(updatedUserCorespondence.getSkype().equals("mytest.skype"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserCorespondenceById(){
//		userCorespondenceDAO.deleteEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence());
//		Assert.assertNull(userCorespondenceDAO
//				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteUserCorespondence(){
//		userCorespondenceDAO.deleteEntity(userCorespondence);
//		Assert.assertNull(userCorespondenceDAO
//				.getEntityById(UserCorespondence.class, userCorespondence.getIdUserCorespondence()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllUserCorespondence(){
//		List<User> list = (List)userCorespondenceDAO.getAllEntity(UserCorespondence.class);
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnUniqueEmail(){
//		
//		Boolean isUnique;
//		isUnique=userCorespondenceDAO.isUniqueEmail(userCorespondence.getEmail());
//		Assert.assertFalse(isUnique);
//		
//		isUnique=userCorespondenceDAO.isUniqueEmail("unique@mail.ru");
//		Assert.assertTrue(isUnique);
//	}
}
