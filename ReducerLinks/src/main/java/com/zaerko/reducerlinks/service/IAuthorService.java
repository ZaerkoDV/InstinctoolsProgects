/**
 * @package com.zaerko.reducerlinks.service
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

import com.zaerko.reducerlinks.model.Author;

/**
 * Interface IAuthorService contains names of methods whose implementation
 * represent in class AuthorService. All declared methods are public.
 * Class AuthorService describes service layer in mvc architecture. Dao
 * layer for service layer describied in class AuthorDAO.
 *
 * @see List
 * @version 1.0 30.05.2015
 * @author Zaerko Denis
 *
 */
public interface IAuthorService {
	
	/**
	 * Return Author by id if author exist in data base with specify
	 * id else null. Parameter idAuthor is attribute of the Author.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param idAuthor
	 * @type Long
	 * @return Author or null.
	 */
	public Author getAuthorById(Long idAuthor);

	/**
	 * Save object(author) in data base if object not null else generate
	 * exeption.Parameter author is object which save in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param Author
	 */
	public void addAuthor(Author author);

	/**
	 * Update object author in data base if object not null else generate
	 * exeption.Parameter author is object which update in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param Author
	 */
	public void updateAuthor(Author author);

	/**
	 * Remove object author in data base if object not null else generate
	 * exeption.Parameter idAuthor represents object which remove in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Long 
	 * @param idAuthor
	 */
	public void removeAuthor(Long idAuthor);

	/**
	 * Return identification number of author in data base by login and password.
	 * If login and password exist return type Long else return null.
	 * 
	 * @type String
	 * @type Boolean
	 * @param login
	 * @param password
	 * @return Long
	 */
	public Long getIdAuthorByLoginPassword(String login,String password);

	/**
	 * Return list of authors. If data base contains authors with transmitted surname
	 * return list of authors else return empty list.
	 * 
	 * @type String
	 * @param surname
	 * @return List
	 */
	public List<Author> getListAuthorsBySurname(String surname);

	/**
	 * Return amount of authors in data base. If data base contain author return
	 * size of author list else return zero.
	 * 
	 * @type String
	 * @param surname
	 * @return int
	 */
	public Long getAuthorsStatistics();

	/**
	 * Return result of user sign in(true/false).If user's login and password
	 * exist in data base return true else false. Method use to user authorization
	 * in service layer.
	 * 
	 * @type String
	 * @type Boolean
	 * @param login
	 * @param password
	 * @return Boolean
	 */
	public Boolean signInByLoginPassword(String login,String password);
	
	/**
	 * Check password and login on unique value in data base.If login or password
	 * exist in data base return false, else return true. Method use when author
	 * registered as client of system. All login and password must be unique.
	 * 
	 * @type String
	 * @type Boolean
	 * @param login
	 * @param password
	 * @return Boolean
	 */
	public Boolean isUniqueLoginPassword(String login,String password);
	
	/**
	 * Method check object(email address) for a given pattern email_pattern.
	 * Object for check transmitted as parameter of method.
	 * 
	 * @type String
	 * @type Boolean
	 * @param email
	 * @return Boolean
	 */
	public Boolean isEmailAddres(String email);
}
