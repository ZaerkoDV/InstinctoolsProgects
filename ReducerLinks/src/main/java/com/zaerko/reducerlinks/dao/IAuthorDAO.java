/**
 * @package com.zaerko.reducerlinks.dao
 * 
 * Package com.zaerko.reducerlinks.dao contain set of class and interfaces
 * which description layer of data access object in ReducerLinks progect.
 * This project is based on MVC architecture.This interface is part of dao layer
 * in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.zaerko.reducerlinks.dao;

import java.util.List;

import com.zaerko.reducerlinks.model.Author;

/**
 * Interface IAuthorDAO contains names of methods whose implementation
 * represent in class AuthorDAO. All declared methods are public.
 * Class AuthorDAO use DAO pattern which describes layer of data
 * access to object. Model for dao layer describied in class Author.
 *
 * @see List
 * @version 1.0 23.05.2015
 * @author Zaerko Denis
 */
public interface IAuthorDAO {

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
	 * @return Long
	 */
	public Long getAuthorsStatistics();
}
