/**
 * @package com.instinctools.reducerlinks.service
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework.  
 */
package com.instinctools.reducerlinks.service;

import java.util.Date;
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

/**
 * Class LinkHistoryServiceTest use to testing LinkHistoryServiceImpl class which belong to service layer.
 * Class use Junit tests. To create test objects use method createObjectsForTest.That method create new
 * object for test and applying anatation Inject to get dependency injection. This is realization of
 * pattern IoC. All methods return void include initObjectsBeforeTest.All methods use annotation Rollback
 * to roll back transaction which created for test. Also in class use Assert. These methods set assertion
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
public class LinkHistoryServiceTest {//extends TestStarter {

//	private static final Logger logger = LoggerFactory.getLogger(LinkHistoryServiceTest.class);
//
//	@Inject
//	@Qualifier("linkHistoryService")
//	private LinkHistoryService linkHistoryService;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public void setLinkHistoryService(LinkHistoryService linkHistoryService) {
//		this.linkHistoryService = linkHistoryService;
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
//		logger.info("LinkHistoryServiceTest:Test link history save successfully.");
//		Assert.assertNotNull(linkHistoryService
//				.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingLinkHistoryById(){
//		
//		logger.info("LinkHistoryServiceTest:Test link history load by id successfully.");
//		Object entity=linkHistoryService
//				.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory());
//		Assert.assertNotNull(entity);
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateLinkHistory(){
//
//		linkHistory.setIpAddress("127.0.0.2");
//		linkHistoryService.updateEntity(linkHistory);
//		final LinkHistory updatedLinkHistory =(LinkHistory) linkHistoryService
//				.getEntityById(LinkHistory.class,linkHistory.getIdLinkHistory());
//		
//		logger.info("LinkHistoryServiceTest:Test link history update successfully.");
//		Assert.assertTrue(updatedLinkHistory.getIpAddress().equals("127.0.0.2"));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteLinkHistoryById(){
//		
//		linkHistoryService.deleteEntityById(LinkHistory.class, linkHistory.getIdLinkHistory());
//		
//		logger.info("LinkHistoryServiceTest:Test link history delete by id successfully.");
//		Assert.assertNull(linkHistoryService
//				.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteLinkHistory(){
//		linkHistoryService.deleteEntity(linkHistory);
//		logger.info("LinkHistoryServiceTest:Test link history delete successfully.");
//		Assert.assertNull(linkHistoryService
//				.getEntityById(LinkHistory.class, linkHistory.getIdLinkHistory()));
//	}
//
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllLinkHistory(){
//		List<Link> list = (List)linkHistoryService.getAllEntity(LinkHistory.class);
//		logger.info("LinkHistoryServiceTest:List of test link history load successfully.");
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
//		logger.info("LinkHistoryServiceTest:List of ip addreses for user load successfully.");
//
//		idUser=linkHistory.getLink().getUser().getIdUser();
//		list=linkHistoryService.getListIpAddressForUser(idUser);
//		Assert.assertFalse(list.isEmpty());
//
//		idUser=(long)10;
//		list=linkHistoryService.getListIpAddressForUser(idUser);
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
//		logger.info("LinkHistoryServiceTest:List of test link history"
//				+ " for user load successfully.");
//
//		idUser=linkHistory.getLink().getUser().getIdUser();
//		list=linkHistoryService.getListLinkHistoryForUser(idUser);
//		Assert.assertFalse(list.isEmpty());
//
//		idUser=(long)10;
//		list=linkHistoryService.getListLinkHistoryForUser(idUser);
//		Assert.assertTrue(list.isEmpty());
//	}
//
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListLinkHistoryForUserBetweenDate(){
//
//		List<LinkHistory> list;
//		Long idUser=linkHistory.getLink().getUser().getIdUser();
//		Date minDate=new Date(date.getTime()-100);
//		Date maxDate=new Date(date.getTime());
//		logger.info("LinkHistoryServiceTest:List of test link history(between date) for user load successfully.");
//		
//		list=linkHistoryService.getListLinkHistoryForUserBetweenDate(idUser, minDate, maxDate);
//		Assert.assertFalse(list.isEmpty());
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnValidIpAddress(){
//		
//		Boolean isValidIpAddress;
//		logger.info("LinkHistoryServiceTest:Cheack ip addrese on valid value completed.");
//		
//		isValidIpAddress=linkHistoryService.isValidIpAddress(linkHistory.getIpAddress());
//		Assert.assertTrue(isValidIpAddress);
//		
//		isValidIpAddress=linkHistoryService.isValidIpAddress("256.255.255.255");
//		Assert.assertFalse(isValidIpAddress);
//	}
}
