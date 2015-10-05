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
import com.instinctools.reducerlinks.model.User;

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
}
