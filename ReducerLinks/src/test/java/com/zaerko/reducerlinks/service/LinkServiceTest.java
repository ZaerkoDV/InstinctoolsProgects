/**
 * @package com.zaerko.reducerlinks.service
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture.Classes used for test junit 
 * framework.
 */
package com.zaerko.reducerlinks.service;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.zaerko.reducerlinks.AbstractTest;
import com.zaerko.reducerlinks.dao.IAuthorDAO;
import com.zaerko.reducerlinks.dao.ILinkDAO;
import com.zaerko.reducerlinks.model.Author;
import com.zaerko.reducerlinks.model.Link;

/**
 * @author Zaerko_DV
 *
 */
public class LinkServiceTest extends AbstractTest{

	/**
	 * Annatation Inject use to get injection of AuthorService and LinkService
	 * and dependency. This is part of specification JSR-330.
	 */
	@Inject
	private IAuthorService authorService;

	@Inject
	private ILinkService linkService;

	public Link link;
	
	@Before
	public void  initLinkBeforeTest(){
		link = linkForTest();
	}
	
	@After 
	public void clearLinkAfrerTest(){
		link = null;
	}
	
	/**
	 * Method create new author and new author link for test. 
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
		authorService.addAuthor(author);
		
		final Link link = new Link();
		link.setLinkNote("testLinkNote");
		link.setLinkFullURL("http://testFullURL");
		link.setLinkShortURL("http://testShortURL");
		link.setUrlTag("testTag");
		link.setSumClick((long)0);
		link.setAuthor(author);
		linkService.addLink(link);
		
		return link;
	}
	
	/**
	 * Method testCRUDLink are testing set of CRUD operations. 
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
		Assert.assertNotNull(linkService.getLinkById(link.getIdLink()));

		//update field of object link.
		final String updateFullURL= "http://testFullURL2";
		link.setLinkFullURL(updateFullURL);
		linkService.updateLink(link);

		// check if link was changed return true
		final Link updatedLink =linkService.getLinkById(link.getIdLink());	
		Assert.assertTrue(updatedLink.getLinkFullURL().equals(updateFullURL));

		//remove link
		linkService.removeLink(updatedLink.getIdLink());
		Assert.assertNull(linkService.getLinkById(link.getIdLink()));
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
			
		List<Link> testlinkListByTag = linkService.getLinkListByTag(link.getUrlTag());
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
	@Transactional
	@Rollback(true)
	@Test
	public void testGetingLinkListByLogin() {

		List<Link> listLinkByLogin = linkService.getLinkListByLogin(link.getAuthor().getLogin());
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
		Long actual=linkService.increaseNumberLinkVisits(link.getIdLink());
		Assert.assertEquals(expected, actual);
		
		//update actual value now value is 1
		link.setSumClick((long)1);
		linkService.updateLink(link);
		
		//check actual and expected values after update
		expected=(long)1;
		actual=linkService.increaseNumberLinkVisits(link.getIdLink());
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Method testCheckUrlAddress are testing string on conformity url.
	 * If url is matches the pattern method return true else false.
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testCheckUrlAddress() {
		//expect
		Boolean testTrueUrl = linkService.isUrlAddress("http://stackoverflow.com/questions/2230676");
		Boolean testFalseUrl=linkService.isUrlAddress("ht:/");
		Assert.assertTrue(testTrueUrl);
		Assert.assertFalse(testFalseUrl);
		
	}
	
}