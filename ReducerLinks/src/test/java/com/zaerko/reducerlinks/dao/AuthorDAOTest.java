/**
 * @package com.zaerko.reducerlinks.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture.Classes used for test junit 
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

/**
 * Class AuthorDAOTest use to testing AuthorDAO class which belong to dao layer.
 * Class use Junit tests. To create test objects use method authorForTest.That
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
public class AuthorDAOTest extends AbstractTest {

	private static final Logger logger = LoggerFactory.getLogger(AuthorDAOTest.class);

	public Author author;

	/**
	 * Annatation Inject use to get injection of AuthorDAO and 
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	private IAuthorDAO authorDAO;

	/**
	 * Create test object before test start.
	 */
	@Before
	public void  initAuthorBeforeTest(){
		logger.info("Test dao:new author for test create successfully.");
		author = authorForTest();
	}

	/**
	 * Destroy test object after method finish.
	 */
	@After 
	public void clearAuthorAfterTest(){
		logger.info("Test dao:author for test destroyed successfully.");
		author = null;
	}

	/**
	 * Method create new object for test. 
	 * 
	 * @return Link if operation create new author successfully
	 * completed else null and exeption in data base.
	 */
	public Author authorForTest(){

		final Author author = new Author();
		author.setName("authorTestName");
		author.setSurname("authorTestSurname");
		author.setPatronymic("authorTestPatronymic");
		author.setEmail("author@test.com");
		author.setLogin("authorTestLogin");
		author.setPassword("authorTestPassword");
		authorDAO.addAuthor(author);

		return author;
	}

	/**
	 * Method testCRUDAuthor are testing set of CRUD operations.That method
	 * use test object, which create before test run and destroy test object
	 * after method is finish. 
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testCRUDAuthor() {

		logger.info("Test dao:start test on CRUD operation with test object(author).");
		// check new client by ID
		Assert.assertNotNull(authorDAO.getAuthorById(author.getIdAuthor()));

		// update author email
		final String newEmail = "author2@test.com";
		author.setEmail(newEmail);
		authorDAO.updateAuthor(author);

		// check if email was changed return true
		final Author updatedAuthor = authorDAO.getAuthorById(author.getIdAuthor());
		Assert.assertTrue(updatedAuthor.getEmail().equals(newEmail));		

		// remove author
		authorDAO.removeAuthor(updatedAuthor.getIdAuthor());
		Assert.assertNull(authorDAO.getAuthorById(author.getIdAuthor()));
		logger.info("Test dao: test on CRUD operation with test object(author) is finish.");
	}

	/**
	 * Method testGetingIdAuthorByLoginPassword are testing operation which
	 * must return id author by login and password if author exist in data base
	 * with specify login and password else get AssertionError.That method use
	 * test object, which create before test run and destroy test object after
	 * method is finish.  
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testGetingIdAuthorByLoginPassword() {

		logger.info("Test dao:start test on geting IdAuthor by login and password.");
		Long idAuthor=authorDAO.getIdAuthorByLoginPassword(author.getLogin(), author.getPassword());
		Assert.assertTrue(idAuthor.equals(author.getIdAuthor()));
		logger.info("Test dao:test on geting IdAuthor by login and password is finish");
	}

	/**
	 * Method testGetingIdAuthorByLoginPassword are testing operation which
	 * must return list authors by surname if surname exist in data base else
	 * get AssertionError.That method use test object, which create before test
	 * run and destroy test object after method is finish. 
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testGetingListAuthorsBySurname(){

		logger.info("Test dao:start test on geting list authors by surname.");
		List<Author> listAuthorsBySurname=authorDAO.getListAuthorsBySurname(author.getSurname());
		Assert.assertFalse(listAuthorsBySurname.isEmpty());
		logger.info("Test dao:test on geting list authors by surname is finish.");
	}

	/**
	 * Method testGetingAuthorsStatystics are testing operation which must 
	 * return amount of author in data base.That method use test object,which
	 * create before test run and destroy test object after method is finish. 
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testGetingAuthorsStatistics(){

		logger.info("Test dao:start test on geting author statistics.");
		Long expected=(long)1;
		Long actual=authorDAO.getAuthorsStatistics();
		Assert.assertEquals(expected,actual);
		logger.info("Test dao:test on geting author statistics is finish.");
	}

	/**
	 * Method testSignInByLoginPassword are testing sign in (authorization)
	 * user in program by login and password.That method use test object,
	 * which create before test run and destroy test object after method
	 * is finish.  
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testSignInByLoginPassword() {

		logger.info("Test dao:start test on author operation sign in.");
		Boolean resaltSignIn =authorDAO.signInByLoginPassword(author.getLogin(), author.getPassword());
		Assert.assertTrue(resaltSignIn);{
			logger.info("Test dao:test on author operation sign in is finish.");
		}
	}
}

