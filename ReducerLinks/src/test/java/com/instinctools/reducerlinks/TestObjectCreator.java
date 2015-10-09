/**
 * 
 */
package com.instinctools.reducerlinks;

import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.instinctools.reducerlinks.dao.CommonEntityDAO;
import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.LinkHistory;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;
import com.instinctools.reducerlinks.model.UserSecurity;

/**
 * @author Zaerko_DV
 *
 */
@Component(value="testObjectCreator")
public class TestObjectCreator {

	private static final Logger logger = LoggerFactory.getLogger(TestObjectCreator.class);

	@Inject
	@Qualifier("commonEntityDAO")
	private CommonEntityDAO commonEntityDAO;

	java.util.Date date = new java.util.Date();

	public void setCommonEntityDAO(CommonEntityDAO commonEntityDAO) {
		this.commonEntityDAO = commonEntityDAO;
	}

	public User createUserForTest() {

		User testUser = new User();
		testUser.setFirstName("testFirstName");
		testUser.setLastName("testLastName");
		testUser.setMiddleName("testMiddleName");
		testUser.setBirthday(new Date(date.getTime()-10));
		commonEntityDAO.saveEntity((User)testUser);	

		return testUser;
	}

		public void deleteUserAfterTest(Long idUser){
			commonEntityDAO.deleteEntityById(User.class, idUser);
		}	

	public UserCorespondence createUserCorespondence(){

		User testUser = createUserForTest();
		UserCorespondence testUserCorespondence = new UserCorespondence();
		testUserCorespondence.setEmail("testt@gmail.ru");
		testUserCorespondence.setSkype("test.skype");
		testUserCorespondence.setTelephone("12345678");
		testUserCorespondence.setUser(testUser);
		commonEntityDAO.saveEntity(testUserCorespondence);

		return testUserCorespondence;
	}

		public void deleteUserCorespondenceAfterTest(Long idUserCorespondence){
			
			UserCorespondence userCorespondence = (UserCorespondence) commonEntityDAO
					.getEntityById(UserCorespondence.class, idUserCorespondence);
			User user= userCorespondence.getUser();
			
			commonEntityDAO.deleteEntity(userCorespondence);
			commonEntityDAO.deleteEntity(user);
		}

	public UserSecurity createUserSecurity(){

		User testUser = createUserForTest();
		UserSecurity testUserSecurity =new UserSecurity();
		testUserSecurity.setLogin("testLogin");
		testUserSecurity.setPassword("testPassword");
		testUserSecurity.setRole("author");
		testUserSecurity.setUser(testUser);
		commonEntityDAO.saveEntity(testUserSecurity);

		return testUserSecurity;
	}

		public void deleteUserSecurityAfterTest(Long idUserSecurity){
			
			UserSecurity userSecurity=(UserSecurity) commonEntityDAO.getEntityById(UserSecurity.class, idUserSecurity);
			User user =userSecurity.getUser();
			commonEntityDAO.deleteEntity(userSecurity);
			commonEntityDAO.deleteEntity(user);
		}

	public Link createLinkForTest(){

		User testUser = createUserForTest();
		Link testLink=new Link();
		testLink.setTag("testTag");
		testLink.setComment("testComment");
		testLink.setShortUrl("https://www.google.by/");
		testLink.setFullUrl("https://www.google.by/");
		testLink.setUser(testUser);
		commonEntityDAO.saveEntity(testLink);

		return testLink;
	}

	public void deleteLinkAfterTest(Long idLink){

		Link link=(Link) commonEntityDAO.getEntityById(Link.class, idLink);
		User user =link.getUser();
		commonEntityDAO.deleteEntity(link);
		commonEntityDAO.deleteEntity(user);
	}

	public  LinkHistory createLinkHistoryForTest(){

		Link testLink=createLinkForTest();
		LinkHistory testLinkHistory =new LinkHistory();
		testLinkHistory.setIpAddress("127.0.0.2");		
		testLinkHistory.setLastCreate(new Date(date.getTime()-10));
		testLinkHistory.setSumClick((long)0);
		testLinkHistory.setLink(testLink);
		commonEntityDAO.saveEntity(testLinkHistory);

		return testLinkHistory;
	}

	public void deleteLinkHistoryAfterTest(Long idLinkHistory){

		LinkHistory linkHistory =(LinkHistory)commonEntityDAO
				.getEntityById(LinkHistory.class, idLinkHistory);		
		final Long idLink=linkHistory.getLink().getIdLink();

		commonEntityDAO.deleteEntity(linkHistory);
		deleteLinkAfterTest(idLink);
	}
}
