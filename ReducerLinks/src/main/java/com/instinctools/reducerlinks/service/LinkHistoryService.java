/**
 * @package com.instinctools.reducerlinks.service
 * 
 * Package com.instinctools.reducerlinks.service contain set of interfaces which description
 * service layer in ReducerLink project.This project is based on MVC architecture.This inerface
 * perform class which is part of service layer in MVC architecture.This layer defines the
 * boundary of the application and a set of permitted operations. It encapsulates the business
 * logic of the application and controls the answers in the implementation of operations. All
 * classes which contain postfix “Service” provide to work Service for ReducerLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.  
 */
package com.instinctools.reducerlinks.service;

import java.util.Date;
import java.util.List;

import com.instinctools.reducerlinks.model.LinkHistory;

/**
 * <p>The interface LinkHistoryService contain methods ads which realize in class LinkHistoryServiceImpl.
 * Class LinkHistoryImpl use Service pattern which describes service layer of application.This class contain
 * general operation to all classes. This interface contain ads methods which perform busness logic all
 * application. Interface extend CommonEntityService interface which contain ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface LinkHistoryService extends CommonEntityService {
	
	public List<String> getListIpAddressForUser(Long idUser);
	public List<LinkHistory> getListLinkHistoryForUser(Long idUser);
	public List<LinkHistory> getListLinkHistoryForUserBetweenDate(Long idUser,Date minDate,Date maxDate);
	public Boolean isValidIpAddress(String idAddress);
}
