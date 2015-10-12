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

/**
 * Class LinkDAOTest use to testing LinkDAOImpl class which belong to dao layer. Class use Junit
 * tests. To create test objects use method createObjectsForTest.That method create new object for
 * test and applying anatation Inject to get dependency injection. This is realization of pattern
 * IoC. All methods return void include initObjectsBeforeTest.All methods use annotation Rollback
 * to roll back transaction which created for test. Also in class use Assert. These methods set
 * assertion methods useful for writing tests.
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
public class LinkDAOTest extends TestStarter {

	private static final Logger logger = LoggerFactory.getLogger(LinkDAOTest.class);
	
	@Inject
	@Qualifier("linkDAO")
	private LinkDAO linkDAO;

	@Inject
	@Qualifier("testObjectCreator")								
	private TestObjectCreator testObjectCreator;

	public void setLinkDAO(LinkDAO linkDAO) {
		this.linkDAO = linkDAO;
	}

	public void setTestObjectCreator(TestObjectCreator testObjectCreator) {
		this.testObjectCreator = testObjectCreator;
	}

	public Link link;
	public LinkHistory linkHistory;
	
	@Before
	public void initObjectsBeforeTest(){
		this.linkHistory=testObjectCreator.createLinkHistoryForTest();
		this.link=linkHistory.getLink();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSaveLink(){
		logger.info("LinkDAOTest:Test link save successfully.");
		Assert.assertNotNull(linkDAO.getEntityById(Link.class, link.getIdLink()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingLinkById(){
		logger.info("LinkDAOTest:Test link load by id successfully.");
		Object entity=linkDAO.getEntityById(Link.class, link.getIdLink());
		Assert.assertNotNull(entity);
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateLink(){

		link.setComment("test2comment");
		linkDAO.updateEntity(link);
		
		final Link updatedLink =(Link) linkDAO.	getEntityById(Link.class,link.getIdLink());
		logger.info("LinkDAOTest:Test link update successfully.");
		Assert.assertTrue(updatedLink.getComment().equals("test2comment"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteLinkById(){
		linkDAO.deleteEntityById(Link.class, link.getIdLink());
		logger.info("LinkDAOTest:Test link delete by id successfully.");
		Assert.assertNull(linkDAO.getEntityById(Link.class, link.getIdLink()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteLink(){
		linkDAO.deleteEntity(link);
		logger.info("LinkDAOTest:Test link delete successfully.");
		Assert.assertNull(linkDAO.getEntityById(Link.class, link.getIdLink()));
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAllLink(){
		List<Link> list = (List)linkDAO.getAllEntity(Link.class);
		logger.info("LinkDAOTest:List of test link load successfully.");
		Assert.assertFalse(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListLinkByTagSortByDate(){

		logger.info("LinkDAOTest:Getting list of links by tag load successfully.");
		List<Link> list=linkDAO.getListLinkByTagSortByDate(link.getTag());
		Assert.assertFalse(list.isEmpty());

		list=linkDAO.getListLinkByTagSortByDate("falseTag");
		Assert.assertTrue(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListLinkSortByDate(){

		logger.info("LinkDAOTest:Getting list of links sort by date load successfully.");
		List<Link> list=linkDAO.getListLinkSortByDate();
		Assert.assertFalse(list.isEmpty());

		testObjectCreator.deleteLinkHistoryAfterTest(linkHistory.getIdLinkHistory());
		
		list=linkDAO.getListLinkSortByDate();
		Assert.assertTrue(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListUniqueTage(){

		logger.info("LinkDAOTest:Getting list of unique tage load successfully.");
		List<String> list=linkDAO.getListUniqueTag();
		Assert.assertFalse(list.isEmpty());

		testObjectCreator.deleteLinkHistoryAfterTest(linkHistory.getIdLinkHistory());
		
		list=linkDAO.getListUniqueTag();
		Assert.assertTrue(list.isEmpty());
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testIncreaseNumberLinkVisits() {

		logger.info("LinkDAOTest:Number of visit links increase successfully.");
		//actual value now value is 1
		Long expected=(long)1;
		Long actual=linkDAO.increaseNumberLinkVisits(link.getIdLink());
		Assert.assertEquals(expected, actual);

		//update actual value now value is 2
		linkHistory.setSumClick((long)2);
		linkDAO.updateEntity(linkHistory);

		expected=(long)3;
		actual=linkDAO.increaseNumberLinkVisits(link.getIdLink());
		Assert.assertEquals(expected, actual);
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingNumberLinkVisits() {

		logger.info("LinkDAOTest:Number of visit links load successfully.");
		//check actual and expected values
		Long expected=(long)0;
		//new link and actual value is 0
		Long actual=linkDAO.getNumberLinkVisits(link.getIdLink());
		Assert.assertEquals(expected, actual);

		//update actual value now value is 1
		linkHistory.setSumClick((long)1);
		linkDAO.updateEntity(link);

		//check actual and expected values after update
		expected=(long)1;
		actual=linkDAO.getNumberLinkVisits(link.getIdLink());
		Assert.assertEquals(expected, actual);
	}
}
