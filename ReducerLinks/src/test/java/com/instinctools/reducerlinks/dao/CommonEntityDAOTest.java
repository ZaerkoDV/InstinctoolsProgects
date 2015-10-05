/**
 * 
 */
package com.instinctools.reducerlinks.dao;

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
public class CommonEntityDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(CommonEntityDAOTest.class);
	
	@Inject
	@Qualifier("commonEntityDAO")
	private CommonEntityDAO commonEntityDAO;

	@Inject
	@Qualifier("testObjectCreator")								
	private TestObjectCreator testObjectCreator;
	
	public void setCommonEntityDAO(CommonEntityDAO commonEntityDAO) {
		this.commonEntityDAO = commonEntityDAO;
	}

	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
		this.testObjectCreator = testObjectCreator;
	}
	
	public User user;
	
	@Before
	public void initObjectsBeforeTest(){
		this.user=testObjectCreator.createUserForTest();
	}
	
//	@After 
//	public void clearObjectsForTest(){
//		testObjectCreator.deleteUserAfterTest(user.getIdUser());
//	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testSaveEntity(){
		
		Assert.assertNotNull(commonEntityDAO.getEntityById(User.class, user.getIdUser()));
	}

	@Transactional
	@Rollback(false)
	@Test
	public void testGettingEntityById(){
		Object entity=commonEntityDAO.getEntityById(User.class, user.getIdUser());
		Assert.assertNotNull(entity);
	}

	@Transactional
	@Rollback(false)
	@Test
	public void testUpdateEntity(){

		user.setFirstName("testFirstName2");
		commonEntityDAO.updateEntity(user);

		final User updatedUser =(User) commonEntityDAO.getEntityById(User.class, user.getIdUser());	
		Assert.assertTrue(updatedUser.getFirstName().equals("testFirstName2"));
	}

	@Transactional
	@Rollback(false)
	@Test
	public void testDeleteEntityById(){
		commonEntityDAO.deleteEntityById(User.class, user.getIdUser());
		Assert.assertNull(commonEntityDAO.getEntityById(User.class, user.getIdUser()));
	}
	
	
	@Transactional
	@Rollback(false)
	@Test
	public void testDeleteEntity(){
		commonEntityDAO.deleteEntity(user);
		Assert.assertNull(commonEntityDAO.getEntityById(User.class, user.getIdUser()));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testGettingAllEntity(){
		commonEntityDAO.deleteEntity(user);
		Assert.assertFalse(commonEntityDAO.getAllEntity(User.class).isEmpty());
	}
	
	
}
