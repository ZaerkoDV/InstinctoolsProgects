/**
 *  @package com.zaerko.reducerlinks.service
 * 
 * Package com.zaerko.reducerlinks.service contain set of class and interfaces
 * which description service layer in ReducerLinks progect. This project is
 * based on MVC architecture.This class is part of service layer in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.zaerko.reducerlinks.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zaerko.reducerlinks.dao.IAuthorDAO;
import com.zaerko.reducerlinks.model.Author;
/**
 * <p>The class AuthorService use service pattern which describes 
 * Defines the boundary between the application and services layer, which forms
 * the set of available operations and manages response to the application in each
 * operation. This class contain methods which intended to access to operation with
 * objects(CRUD and other).Class implements interface IAuthorService which located
 * in the same package as the class AuthorService. All methods are public in class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private,
 * static variable logger, which use to call log message. Class use Spring framework
 * to work whith service stereotype. Class use regex.pattern and regex.matcher to check
 * object(email address) for a given pattern email_pattern.
 *
 * @see Collection
 * @see List
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * @see regex.Matcher
 * @see regex.Pattern
 * 
 * @version 1.0 30.05.2015
 * @author Zaerko Denis
 */
@Service(value="authorService")
public class AuthorService implements IAuthorService{

	/**
	 * Annatation Inject use to get injection of AuthorDAO and 
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	private IAuthorDAO authorDAO;

	private Pattern pattern;

	private Matcher matcher;

	private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);

	private static final String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public void setAuthorDAO(IAuthorDAO authorDAO) {
		this.authorDAO=authorDAO;
	} 

	/**
	 * Return Author by id if author exist in data base with specify
	 * id else null. Parameter idAuthor is attribute of the Author.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param idAuthor
	 * @type Long
	 * @return Author or null.
	 * @throw NullPointerException
	 */
	public Author getAuthorById(Long idAuthor){

		if(!idAuthor.equals(null)){
			logger.info("Service:Author loaded, id=" + authorDAO.getAuthorById(idAuthor));
			return authorDAO.getAuthorById(idAuthor);

		}else{
			logger.info("Service:Author not loaded idAuthor must not be null");
			throw new NullPointerException("Service:Author not loaded idAuthor must not be null");
		}
	}

	/**
	 * Save object(author) in data base if object not null else generate
	 * exeption.Parameter author is object which save in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param Author
	 * @throw NullPointerException
	 */
	public void addAuthor(Author author){

		if(!author.equals(null)){
			authorDAO.addAuthor(author);
			logger.info("Service:New author saved, details="+author );

		}else{
			logger.info("Service:New author not saved.Author must not be null.");
			throw new NullPointerException("Service:New author not saved.Author must not be null.");
		}
	}

	/**
	 * Update object author in data base if object not null else generate
	 * exeption.Parameter author is object which update in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param Author
	 * @throw NullPointerException
	 */
	public void updateAuthor(Author author){

		if(!author.equals(null)){
			authorDAO.updateAuthor(author);
			logger.info("Service:Author attributes updated, details=" + author);

		}else{
			logger.info("Service:Author attributes not updated. Author must not be null.");
			throw new NullPointerException("Service:Author attributes not updated. Author must not be null.");
		}
	}

	/**
	 * Remove object author in data base if object not null else generate
	 * exeption.Parameter idAuthor represents object which remove in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Long
	 * @param idAuthor
	 * @throw NullPointerException
	 */
	public void removeAuthor(Long idAuthor){

		if(!idAuthor.equals(null)){
			authorDAO.removeAuthor(idAuthor);
			logger.info("Service:Author deleted, id=" + idAuthor);

		}else{
			logger.info("Service:Author not deleted.Author id must not be null.");
			throw new NullPointerException("Service:Author not deleted.Author id must not be null.");
		}
	}

	/**
	 * Return identification number of author in data base by login and password.
	 * If login and password exist return type Long else return null.
	 * 
	 * @type String
	 * @type Boolean
	 * @param login
	 * @param password
	 * @throw NullPointerException
	 * @return Long
	 */
	public Long getIdAuthorByLoginPassword(String login,String password){

		Long idAuthor;

		if(!login.equals(null) && !password.equals(null)){
			idAuthor = authorDAO.getIdAuthorByLoginPassword(login, password);
			logger.info("Service:Author id downloaded by login and password, id=" + idAuthor);
			return idAuthor;

		}else{
			logger.info("Service:Author id not loaded by login and password.Password and login must not be null.");
			throw new NullPointerException("Service:Author id not loaded by login and password.Password and login must not be null.");
		}
	}

	/**
	 * Return list of authors. If data base contains authors with transmitted surname
	 * return list of authors else return empty list.
	 * 
	 * @type String
	 * @param surname
	 * @throw NullPointerException 
	 * @return List
	 */
	public List<Author> getListAuthorsBySurname(String surname){

		if(!surname.equals(null)){
			logger.info("Service:List of authors by surname =" + surname+" download ");
			return authorDAO.getListAuthorsBySurname(surname);

		}else{
			logger.info("Service:List of authors by surname not loaded.");
			throw new NullPointerException("Service:List of authors by surname not loaded.");
		}
	}

	/**
	 * Return amount of authors in data base. If data base contain author return
	 * size of author list else return zero.
	 * 
	 * @type String
	 * @param surname
	 * @return Long
	 */
	public Long getAuthorsStatistics(){

		Long amountOfAuthors=authorDAO.getAuthorsStatistics();
		logger.info("Service:Statistic of author loaded. In data base exist =" + amountOfAuthors+" author(s)");
		return amountOfAuthors;
	}

	/**
	 * Return result of user sign in(true/false).If user's login and password
	 * exist in data base return true else false. Method use to user authorization
	 * in service layer.
	 * 
	 * @type String
	 * @type Boolean
	 * @param login
	 * @param password
	 * @throw NullPointerException
	 * @return Boolean
	 */
	public  Boolean signInByLoginPassword(String login,String password){

		Boolean resultSignIn;
		if(!login.equals(null) && !password.equals(null)){
			resultSignIn=authorDAO.signInByLoginPassword(login, password);
			logger.info("Service: Authorization process is completed. Result authorithation "+resultSignIn);
			return resultSignIn;

		}else{
			logger.info("Service: Authorization process is not completed. Login and password must not be null.");
			throw new NullPointerException("Service: Authorization process is not completed. Login and password "
					+ "must not be null.");
		}
	}

	/**
	 * Check password and login on unique value in data base.If login or password
	 * exist in data base return false, else return true. Method use when author
	 * registered as client of system. All login and password must be unique.
	 * 
	 * @type String
	 * @type Boolean
	 * @param login
	 * @param password
	 * @throws NullPointerException
	 * @return Boolean
	 */
	public Boolean isUniqueLoginPassword(String login,String password){

		Boolean isUnique;
		Boolean resultSearchSignature = null;

		if(!login.equals(null) && !password.equals(null)){
			resultSearchSignature=authorDAO.signInByLoginPassword(login, password);
			logger.info("Service:Search author with signature is completed. Result search: "+resultSearchSignature);

		}else{
			logger.info("Service:Search author with signature is not completed.Login and password must not be null.");
			throw new NullPointerException("Service:Search author with signature is not completed.Login and password"
					+ " must not be null.");
		}

		if(resultSearchSignature==false){
			logger.info("Service:Login and password already exist in data base.");
			isUnique=true;

		}else{
			logger.info("Service:Login and password not exist in data base.");
			isUnique=false;
		}		
		return isUnique;
	}

	/**
	 * Method check object(email address) for a given pattern email_pattern.
	 * Object for check transmitted as parameter of method.
	 * 
	 * @type String
	 * @type Boolean
	 * @param email
	 * @return Boolean
	 */
	public Boolean isEmailAddres(String email){
		pattern = Pattern.compile(email_pattern);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
