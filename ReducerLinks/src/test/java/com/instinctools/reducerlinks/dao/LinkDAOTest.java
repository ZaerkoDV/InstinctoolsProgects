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
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
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
	
	@Before
	public void initObjectsBeforeTest(){
		this.link=testObjectCreator.createLinkForTest();
	}
	
//	@After
//	public void clearObjectsAfterTest(){
//		testObjectCreator.deleteLinkAfterTest(link.getIdLink());
//	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testSaveLink(){
		
		Assert.assertNotNull(linkDAO.getEntityById(Link.class, link.getIdLink()));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testGettingLinkById(){
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
		Assert.assertTrue(updatedLink.getComment().equals("test2comment"));
	}

	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteLinkById(){
		linkDAO.deleteEntityById(Link.class, link.getIdLink());
		Assert.assertNull(linkDAO.getEntityById(Link.class, link.getIdLink()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteLink(){
		linkDAO.deleteEntity(link);
		Assert.assertNull(linkDAO.getEntityById(Link.class, link.getIdLink()));
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingAllLink(){
		@SuppressWarnings("unchecked")
		List<Link> list = (List)linkDAO.getAllEntity(Link.class);
		Assert.assertFalse(list.isEmpty());
	}
	
}
