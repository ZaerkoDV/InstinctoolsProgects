/**
 * 
 */
package com.instinctools.reducerlinks.dao;

import java.util.Date;
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
public class LinkHistoryDAOTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(LinkHistoryDAOTest.class);
//	
//	@Inject
//	@Qualifier("linkHistoryDAO")
//	private LinkHistoryDAO linkHistoryDAO;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public void setLinkHistoryDAO(LinkHistoryDAO linkHistoryDAO) {
//		this.linkHistoryDAO = linkHistoryDAO;
//	}
//
//	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
//		this.testObjectCreator = testObjectCreator;
//	}
//	
//	public LinkHistory linkHistory;
//	java.util.Date date = new java.util.Date();
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		this.linkHistory=testObjectCreator.createLinkHistoryForTest();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveLinkHistory(){
//		Assert.assertNotNull(linkHistoryDAO.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingLinkHistoryById(){
//		Object entity=linkHistoryDAO.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory());
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateLinkHistory(){
//
//		linkHistory.setIpAddress("127.0.0.2");
//		linkHistoryDAO.updateEntity(linkHistory);
//		final LinkHistory updatedLinkHistory =(LinkHistory) linkHistoryDAO
//				.getEntityById(LinkHistory.class,linkHistory.getIdLinkHistory());	
//		Assert.assertTrue(updatedLinkHistory.getIpAddress().equals("127.0.0.2"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteLinkHistoryById(){
//		linkHistoryDAO.deleteEntityById(LinkHistory.class, linkHistory.getIdLinkHistory());
//		Assert.assertNull(linkHistoryDAO.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testLinkHistoryEntity(){
//		linkHistoryDAO.deleteEntity(linkHistory);
//		Assert.assertNull(linkHistoryDAO.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllLinkHistory(){
//		List<Link> list = (List)linkHistoryDAO.getAllEntity(LinkHistory.class);
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListIpAddressForUser(){
//
//		List<String> list;
//		Long idUser;
//		
//		idUser=linkHistory.getLink().getUser().getIdUser();
//		list=linkHistoryDAO.getListIpAddressForUser(idUser);
//		Assert.assertFalse(list.isEmpty());
//
//		idUser=(long)10;
//		list=linkHistoryDAO.getListIpAddressForUser(idUser);
//		Assert.assertTrue(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListLinkHistoryForUser(){
//
//		List<LinkHistory> list;
//		Long idUser;
//		
//		idUser=linkHistory.getLink().getUser().getIdUser();
//		list=linkHistoryDAO.getListLinkHistoryForUser(idUser);
//		Assert.assertFalse(list.isEmpty());
//
//		idUser=(long)10;
//		list=linkHistoryDAO.getListLinkHistoryForUser(idUser);
//		Assert.assertTrue(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListLinkHistoryForUserBetweenDate(){
//
//		List<LinkHistory> list;
//		Long idUser;
//		
//		idUser=linkHistory.getLink().getUser().getIdUser();
//		Date minDate=new Date(date.getTime()-100);
//		Date maxDate=new Date(date.getTime());
//		list=linkHistoryDAO.getListLinkHistoryForUserBetweenDate(idUser, minDate, maxDate);
//		Assert.assertFalse(list.isEmpty());
//	}
}
