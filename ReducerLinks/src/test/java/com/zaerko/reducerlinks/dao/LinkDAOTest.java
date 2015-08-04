/**
 * @package com.zaerko.reducerlinks.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture.Classes used for test jubit 
 * framework.
 */
package com.zaerko.reducerlinks.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.zaerko.reducerlinks.AbstractTest;
import com.zaerko.reducerlinks.model.Author;
import com.zaerko.reducerlinks.model.Link;

/**
 * Class LinkDAOTest use to testing LinkDAO class which belong to dao layer.
 * Class use Junit tests. To create test objects use method linkForTest.That
 * method create new object for test and applying anatation Inject to get
 * dependency injection. This is realization of pattern IoC. All methods 
 * return void except linkForTest. All methods use annotation Rollback to
 * roll back transaction which created for test. Also in class use Assert   
 * These methods set assertion methods useful for writing tests.
 * 
 * @see org.springframework.transaction
 * @see javax.inject.Inject
 * @see org.slf4j
 * @see org.junit
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 23.05.2015
 * @author Zaerko Denis
 */
public class LinkDAOTest {//extends AbstractTest {
	
//	private static final Logger logger = LoggerFactory.getLogger(LinkDAOTest.class);
//
//	/**
//	 * Annatation Inject use to get injection of AuthorDAO and LinkDAO
//	 * and dependency. This is part of specification JSR-330.
//	 */
//	@Inject
//	private IAuthorDAO authorDAO;
//
//	@Inject
//	private ILinkDAO linkDAO;
//
//	public Author author;
//
//	public Link link;
//
//	@Before
//	public void initLinkForTest(){
//		link = createLinkForTest();
//	}
//
//	@After 
//	public void clearLinkForTest(){
//		author=null;
//		link = null;
//	}
//
//	/**
//	 * Method create new object for test. 
//	 * 
//	 * @return Link if operation create new author and link
//	 * successfully completed else null and exeption in data base.
//	 * 
//	 * @throws IllegalAccessException 
//	 * @throws InstantiationException 
//	 */
//	public Link createLinkForTest() {
//
//		author = new Author();
//		author.setName("authorTestName");
//		author.setSurname("authorTestSurname");
//		author.setPatronymic("authorTestPatronymic");
//		author.setEmail("author@test.com");
//		author.setLogin("authorTestLogin");
//		author.setPassword("authorTestPassword");
//		authorDAO.addAuthor(author);
//
//		link = new Link();
//		link.setLinkNote("testLinkNote");
//		link.setLinkFullURL("http://testFullURL");
//		link.setLinkShortURL("http://testShortURL");
//		link.setUrlTag("testTag");
//		link.setSumClick((long)0);
//		link.setAuthor(author);
//		linkDAO.addLink(link);
//
//		return link;
//	}
//	
//	/**
//	 * Method testSaveLink are testing operation save.That method use test object,
//	 * which create before test run and destroy test object after method is finish. 
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 */
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testSaveLink(){
//		logger.info("Test dao: test on save new link.");
//		System.out.println(link.getIdLink());
//		Assert.assertFalse(link.equals(null));
//	}
//	
//	/**
//	 * Method testGettingLinkById are testing operation "get" link by id.That method
//	 * use test object,which create before test run and destroy test object after 
//	 * method is finish.  
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 */
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testGettingLinkById(){
//		logger.info("Test dao: test on operation get link by id.");
//		Assert.assertNotNull(linkDAO.getLinkById(link.getIdLink()));
//	}
//
//	/**
//	 * Method testUpdateLink are testing operation update. That method use test object,
//	 * which create before test run and destroy test object after method is finish.  
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 */
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testUpdateLink(){
//		
//		logger.info("Test dao: test on update link.");
//		final String updateFullURL= "http://testFullURL2";
//		link.setLinkFullURL(updateFullURL);
//		linkDAO.updateLink(link);
//
//		// check if link was changed return true
//		final Link updatedLink =linkDAO.getLinkById(link.getIdLink());	
//		Assert.assertTrue(updatedLink.getLinkFullURL().equals(updateFullURL));
//	}
//
//	/**
//	 * Method testRemoveLink are testing operation delete link by id. That method
//	 * use test object, which create before test run and destroy test object after
//	 * method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 */	
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testRemoveLink(){
//		logger.info("Test dao: test on delete link by id.");
//		linkDAO.removeLink(link.getIdLink());
//		Assert.assertNull(linkDAO.getLinkById(link.getIdLink()));
//	}
//
//	/**
//	 * Method testGetingLinkListByTag are testing operation of creating
//	 * a list links by tag. That method initiating to create new test object
//	 * for test.
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 */
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testGetingLinkListByTag(){
//
//		List<Link> testlinkListByTag = linkDAO.getLinkListByTag(link.getUrlTag());
//		Assert.assertFalse(testlinkListByTag.isEmpty());
//	}
//
//	/**
//	 * Method testGetingAllLinkList are testing operation of perform link list.This
//	 * list contain all link. That method initiating to create new test object for test.
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 */
//	@Transactional
//	@Rollback(false)
//	@Test
//	public void testGetingAllLinkList(){
//
//		List<Link> testlinkList = linkDAO.getAllLink();
//		Assert.assertFalse(testlinkList.isEmpty());
//	}
//
//	/**
//	 * Method testGetingLinkListByLogin are testing operation of creating
//	 * a list links by author login. That method initiating to create new
//	 * test object for test.
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 */
//	//?
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGetingLinkListByLogin() {
//
//		List<Link> listLinkByLogin = linkDAO.getLinkListByLogin(link.getAuthor().getLogin());//"log"//link.getAuthor().getLogin()
//		Assert.assertFalse(listLinkByLogin.isEmpty());
//	}
//
//	/**
//	 * Method testIncreaseNumberLinkVisits are testing operation of computing
//	 * sum visits on link. That method initiating to create new test object
//	 * for test.
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testIncreaseNumberLinkVisits() {
//
//		//check actual and expected values
//		Long expected=(long)0;
//		//new link and actual value is 0
//		Long actual=linkDAO.increaseNumberLinkVisits(link.getIdLink());
//		Assert.assertEquals(expected, actual);
//
//		//update actual value now value is 1
//		link.setSumClick((long)1);
//		linkDAO.updateLink(link);
//
//		//check actual and expected values after update
//		expected=(long)1;
//		actual=linkDAO.increaseNumberLinkVisits(link.getIdLink());
//		Assert.assertEquals(expected, actual);
//	}
}
