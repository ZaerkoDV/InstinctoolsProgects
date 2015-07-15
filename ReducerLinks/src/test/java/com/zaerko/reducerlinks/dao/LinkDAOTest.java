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
public class LinkDAOTest extends AbstractTest {
	
	/**
	 * Annatation Inject use to get injection of AuthorDAO and LinkDAO
	 * and dependency. This is part of specification JSR-330.
	 */
	@Inject
	private IAuthorDAO authorDAO;

	@Inject
	private ILinkDAO linkDAO;

	public Link link;
	
	@Before
	public void  initLinkForTest(){
		link = linkForTest();
	}
	
	@After 
	public void clearLinkForTest(){
		link = null;
	}
	
	/**
	 * Method create new object for test. 
	 * 
	 * @return Link if operation create new author and link
	 * successfully completed else null and exeption in data base.
	 * 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Link linkForTest() {
		
		final Author author = new Author();
		author.setName("authorTestName");
		author.setSurname("authorTestSurname");
		author.setPatronymic("authorTestPatronymic");
		author.setEmail("author@test.com");
		author.setLogin("authorTestLogin");
		author.setPassword("authorTestPassword");
		authorDAO.addAuthor(author);
		
		final Link link = new Link();
		link.setLinkNote("testLinkNote");
		link.setLinkFullURL("http://testFullURL");
		link.setLinkShortURL("http://testShortURL");
		link.setUrlTag("testTag");
		link.setSumClick((long)0);
		link.setAuthor(author);
		linkDAO.addLink(link);
		
		return link;
	}

	/**
	 * Method testCRUDLink are testing set of CRUD operations. 
	 * That method initiating to create new object for test
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testCRUDLink(){

		// check new link by ID
		Assert.assertNotNull(linkDAO.getLinkById(link.getIdLink()));

		//update field of object link.
		final String updateFullURL= "http://testFullURL2";
		link.setLinkFullURL(updateFullURL);
		linkDAO.updateLink(link);

		// check if link was changed return true
		final Link updatedLink =linkDAO.getLinkById(link.getIdLink());	
		Assert.assertTrue(updatedLink.getLinkFullURL().equals(updateFullURL));

		//remove link
		linkDAO.removeLink(updatedLink.getIdLink());
		Assert.assertNull(linkDAO.getLinkById(link.getIdLink()));
	}
	
	/**
	 * Method testGetingLinkListByTag are testing operation of creating
	 * a list links by tag. That method initiating to create new test object
	 * for test.
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(false)
	@Test
	public void testGetingLinkListByTag(){
			
		List<Link> testlinkListByTag = linkDAO.getLinkListByTag(link.getUrlTag());
		Assert.assertFalse(testlinkListByTag.isEmpty());
	}
	
	/**
	 * Method testGetingLinkListByLogin are testing operation of creating
	 * a list links by author login. That method initiating to create new
	 * test object for test.
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	//?
	@Transactional
	@Rollback(true)
	@Test
	public void testGetingLinkListByLogin() {

		List<Link> listLinkByLogin = linkDAO.getLinkListByLogin(link.getAuthor().getLogin());//"log"//link.getAuthor().getLogin()
		Assert.assertFalse(listLinkByLogin.isEmpty());
	}

	/**
	 * Method testIncreaseNumberLinkVisits are testing operation of computing
	 * sum visits on link. That method initiating to create new test object
	 * for test.
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testIncreaseNumberLinkVisits() {
		
		//check actual and expected values
		Long expected=(long)0;
		//new link and actual value is 0
		Long actual=linkDAO.increaseNumberLinkVisits(link.getIdLink());
		Assert.assertEquals(expected, actual);
		
		//update actual value now value is 1
		link.setSumClick((long)1);
		linkDAO.updateLink(link);
		
		//check actual and expected values after update
		expected=(long)1;
		actual=linkDAO.increaseNumberLinkVisits(link.getIdLink());
		Assert.assertEquals(expected, actual);
	}
}
