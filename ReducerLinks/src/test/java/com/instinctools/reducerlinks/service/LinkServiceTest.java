/**
 * 
 */
package com.instinctools.reducerlinks.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.httpclient.HttpException;
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
 * @author Zaerko_DV
 *
 */
public class LinkServiceTest {//extends TestStarter {

	//	private static final Logger logger = LoggerFactory.getLogger(LinkServiceTest.class);
	//
	//	@Inject
	//	@Qualifier("linkService")
	//	private LinkService linkService;
	//
	//	@Inject
	//	@Qualifier("testObjectCreator")								
	//	private TestObjectCreator testObjectCreator;
	//
	//	public void setLinkService(LinkService linkService) {
	//		this.linkService = linkService;
	//	}
	//
	//	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
	//		this.testObjectCreator = testObjectCreator;
	//	}
	//
	//	public Link link;
	//	public LinkHistory linkHistory;
	//
	//	@Before
	//	public void initObjectsBeforeTest(){
	//		this.linkHistory=testObjectCreator.createLinkHistoryForTest();
	//		this.link=linkHistory.getLink();
	//	}
	//
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testSaveLink(){
	//		
	//		Assert.assertNotNull(linkService.getEntityById(Link.class, link.getIdLink()));
	//	}
	//
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testGettingLinkById(){
	//		Object entity=linkService.getEntityById(Link.class, link.getIdLink());
	//		Assert.assertNotNull(entity);
	//	}
	//
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testUpdateLink(){
	//
	//		link.setComment("test2comment");
	//		linkService.updateEntity(link);
	//		final Link updatedLink =(Link) linkService.getEntityById(Link.class,link.getIdLink());	
	//		Assert.assertTrue(updatedLink.getComment().equals("test2comment"));
	//	}
	//
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testDeleteLinkById(){
	//		linkService.deleteEntityById(Link.class, link.getIdLink());
	//		Assert.assertNull(linkService.getEntityById(Link.class, link.getIdLink()));
	//	}
	//	
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testDeleteLink(){
	//		linkService.deleteEntity(link);
	//		Assert.assertNull(linkService.getEntityById(Link.class, link.getIdLink()));
	//	}
	//	
	//	@SuppressWarnings("unchecked")
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testGettingAllLink(){
	//		List<Link> list = (List)linkService.getAllEntity(Link.class);
	//		Assert.assertFalse(list.isEmpty());
	//	}
	//	
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testGettingListLinkByTagSortByDate(){
	//
	//		List<Link> list=linkService.getListLinkByTagSortByDate(link.getTag());
	//		Assert.assertFalse(list.isEmpty());
	//
	//		list=linkService.getListLinkByTagSortByDate("falseTag");
	//		Assert.assertTrue(list.isEmpty());
	//	}
	//	
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testGettingListLinkSortByDate(){
	//
	//		List<Link> list=linkService.getListLinkSortByDate();
	//		Assert.assertFalse(list.isEmpty());
	//
	//		testObjectCreator.deleteLinkHistoryAfterTest(linkHistory.getIdLinkHistory());
	//		
	//		list=linkService.getListLinkSortByDate();
	//		Assert.assertTrue(list.isEmpty());
	//	}
	//	
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testGettingListUniqueTage(){
	//
	//		List<String> list=linkService.getListUniqueTag();
	//		Assert.assertFalse(list.isEmpty());
	//
	//		testObjectCreator.deleteLinkHistoryAfterTest(linkHistory.getIdLinkHistory());
	//		
	//		list=linkService.getListUniqueTag();
	//		Assert.assertTrue(list.isEmpty());
	//	}
	//	
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testIncreaseNumberLinkVisits() {
	//
	//		//check actual and expected values
	//		//actual value now value is 1
	//		Long expected=(long)1;
	//		Long actual=linkService.increaseNumberLinkVisits(link.getIdLink());
	//		Assert.assertEquals(expected, actual);
	//
	//		//update actual value now value is 0
	//		linkHistory.setSumClick((long)2);
	//		linkService.updateEntity(linkHistory);
	//
	//		//check actual and expected values after update
	//		expected=(long)3;
	//		actual=linkService.increaseNumberLinkVisits(link.getIdLink());
	//		Assert.assertEquals(expected, actual);
	//	}
	//	
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testGettingNumberLinkVisits() {
	//
	//		//check actual and expected values
	//		Long expected=(long)0;
	//		//new link and actual value is 0
	//		Long actual=linkService.getNumberLinkVisits(link.getIdLink());
	//		Assert.assertEquals(expected, actual);
	//
	//		//update actual value now value is 1
	//		linkHistory.setSumClick((long)1);
	//		linkService.updateEntity(link);
	//
	//		//check actual and expected values after update
	//		expected=(long)1;
	//		actual=linkService.getNumberLinkVisits(link.getIdLink());
	//		Assert.assertEquals(expected, actual);
	//	}
	//	
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testOnValidURL(){
	//		
	//		Boolean isValidURL;
	//		
	//		isValidURL=linkService.isValidURL(link.getFullUrl());
	//		Assert.assertTrue(isValidURL);
	//		
	//		isValidURL=linkService.isValidURL("https://www.google");
	//		Assert.assertFalse(isValidURL);
	//	}
	//
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testOnReduceURL(){
	//
	//		String fullURL="https://www.google.by/?gfe_rd=cr&ei=Of0YVs6ELeqH8Qfy56eACA&gws_rd=ssl";
	//		String shortURL=null;
	//		shortURL=linkService.reduceURL(fullURL);	
	//
	//		Assert.assertNotNull(shortURL);
	//		Assert.assertEquals("http://tinyurl.com/nkuq3y2", shortURL);
	//	}
	//
	//	@Transactional
	//	@Rollback(true)
	//	@Test
	//	public void testOnExpandURL() throws IOException{
	//
	//		String actualURL=linkService.expandURL("http://tinyurl.com/nkuq3y2");			
	//		String expectedURL="http://www.google.by/?gfe_rd=cr&ei=Of0YVs6ELeqH8Qfy56eACA&gws_rd=ssl";
	//		Assert.assertEquals(expectedURL, actualURL);
	//	}
}
