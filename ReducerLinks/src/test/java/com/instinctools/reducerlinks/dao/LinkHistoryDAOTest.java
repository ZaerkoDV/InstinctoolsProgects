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
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.LinkHistory;
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
 */
public class LinkHistoryDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(LinkHistoryDAOTest.class);
	
	@Inject
	@Qualifier("linkHistoryDAO")
	private LinkHistoryDAO linkHistoryDAO;

	@Inject
	@Qualifier("testObjectCreator")								
	private TestObjectCreator testObjectCreator;

	public void setLinkHistoryDAO(LinkHistoryDAO linkHistoryDAO) {
		this.linkHistoryDAO = linkHistoryDAO;
	}

	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
		this.testObjectCreator = testObjectCreator;
	}
	
	public LinkHistory linkHistory;
	
	@Before
	public void initObjectsBeforeTest(){
		this.linkHistory=testObjectCreator.createLinkHistoryForTest();
	}
	
//	@After
//	public void clearObjectsAfterTest(){
//		testObjectCreator.deleteLinkHistoryAfterTest(linkHistory.getIdLinkHistory());
//	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSaveLinkHistory(){
		Assert.assertNotNull(linkHistoryDAO.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingLinkHistoryById(){
		Object entity=linkHistoryDAO.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory());
		Assert.assertNotNull(entity);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateLinkHistory(){

		linkHistory.setIpAddress("127.0.0.2");
		linkHistoryDAO.updateEntity(linkHistory);
		final LinkHistory updatedLinkHistory =(LinkHistory) linkHistoryDAO
				.getEntityById(LinkHistory.class,linkHistory.getIdLinkHistory());	
		Assert.assertTrue(updatedLinkHistory.getIpAddress().equals("127.0.0.2"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteLinkHistoryById(){
		linkHistoryDAO.deleteEntityById(LinkHistory.class, linkHistory.getIdLinkHistory());
		Assert.assertNull(linkHistoryDAO.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testLinkHistoryEntity(){
		linkHistoryDAO.deleteEntity(linkHistory);
		Assert.assertNull(linkHistoryDAO.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAllLinkHistory(){
		List<Link> list = (List)linkHistoryDAO.getAllEntity(LinkHistory.class);
		Assert.assertFalse(list.isEmpty());
	}
}
