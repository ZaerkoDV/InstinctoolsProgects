/**
 * @package com.zaerko.reducerlinks.dao
 * 
 * Package com.zaerko.reducerlinks.dao contain set of class and interfaces
 * which description layer of data access object in ReducerLinks progect.
 * This project is based on MVC architecture.This class is part of dao layer
 * in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.zaerko.reducerlinks.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zaerko.reducerlinks.model.Author;
/**
 * <p>The class AuthorDAO use DAO pattern which describes layer of data access to
 * object. DAO layer perform link between relational and object model.Model for
 * this dao layer describied in class Author. This class contain methods which
 * intended to access to operation with objects(CRUD and other).Class implements
 * interface IAuthorDAO which located in the same package as the class AuthorDAO.
 * All methods are public in class.For logging use framework shell slf4j and
 * framework log4j.Class contain also private, static variable logger, which use
 * to call log message. Class use Spring framework  to work whith ORM. In particular
 * often use HibernateTemplate for integration Hibernate and Spring technologys.
 * 
 * @see Collection
 * @see List
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 23.05.2015
 * @author Zaerko Denis
 */
@Repository(value = "authorDAO")
public class AuthorDAO extends HibernateDaoSupport implements IAuthorDAO {

	/**
	 * Variable logger use to get logger level for class AuthorDAO.
	 * 
	 * @return logger for class AuthorDAO.
	 * @param AuthorDAO
	 */
	private static final Logger logger = LoggerFactory.getLogger(AuthorDAO.class);

	/**
	 * Return Author by id if author exist in data base with specify
	 * id else null. Parameter idAuthor is attribute of the Author.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param idAuthor
	 * @type Long
	 * @return Author or null.
	 * @throw HibernateObjectRetrievalFailureException
	 */
	public Author getAuthorById(Long idAuthor) {

		try{
			logger.info("DAO:Author loaded in dao, id=" + idAuthor);
			return this.getHibernateTemplate().load(Author.class,idAuthor);

		}catch(final HibernateObjectRetrievalFailureException e){	
			logger.info("DAO:Author not loaded detales id="+ idAuthor+" "+e);
			return null;
		}
	}

	/**
	 * Save object(author) in data base if object not null else generate
	 * exeption.Parameter author is object which save in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param Author
	 * @throw HibernateObjectRetrievalFailureException
	 * 
	 */
	public void addAuthor(Author author) {

		try{
			this.getHibernateTemplate().persist(author);
			logger.info("DAO:New author saved in dao, details=" + author.getIdAuthor());

		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("DAO:New author not saved in dao, because error "+e);

		}
	}

	/**
	 * Update object author in data base if object not null else generate
	 * exeption.Parameter author is object which update in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @param Author
	 * @throw HibernateObjectRetrievalFailureException
	 */
	public void updateAuthor(Author author) {

		try{
			this.getHibernateTemplate().update(author);
			logger.info("DAO:Author updated in dao, details=" + author.getIdAuthor());

		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("DAO:New author not update in dao, because error "+e);
		}
	}

	/**
	 * Remove object author in data base if object not null else generate
	 * exeption.Parameter idAuthor represents object which remove in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Long
	 * @param idAuthor
	 * @throw HibernateObjectRetrievalFailureException
	 */
	public void removeAuthor(Long idAuthor) {

		try{
			Author author=this.getHibernateTemplate().load(Author.class, idAuthor);
			this.getHibernateTemplate().delete(author);
			logger.info("DAO:Author deleted, details=" + author);

		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("DAO:Author not delete"+e);
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
	 * @throw DataAccessException
	 * @return Long
	 */
	@SuppressWarnings("unchecked")
	public Long getIdAuthorByLoginPassword(String login,String password){

		String query;
		Long idAuthor;
		List<Author> listAuthors = null;

		try{ 
			query="SELECT a FROM Author a WHERE a.login = ? AND a.password = ?";
			listAuthors =(List<Author>)this.getHibernateTemplate().find(query,login,password);

		}catch(final DataAccessException e){
			logger.info("DAO:Author with this login and password not loaded."+e);
		}

		if(listAuthors.isEmpty()){
			idAuthor=null;
			logger.info("DAO:Author not exist with login="+login+" and "+"password="+password);

		}else{
			if(listAuthors.size()<=1){
				idAuthor=listAuthors.get(0).getIdAuthor();
				logger.info("DAO:Author id="+idAuthor+" with login="+login+" and "+"password="+password);

			}else{
				idAuthor=listAuthors.get(1).getIdAuthor();
				logger.info("DAO:Exist several authors with identical login"+login+" "
						+ "and password="+password);
				for( Author author : listAuthors){
					logger.info("DAO:List of idAuthor with the specified login and "
							+ "password="+author.getIdAuthor());
				}
			}
		}
		return idAuthor;
	}

	/**
	 * Return list of authors. If data base contains authors with transmitted surname
	 * return list of authors else return empty list.
	 * 
	 * @type String
	 * @param surname
	 * @throw DataAccessException 
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<Author> getListAuthorsBySurname(String surname) throws DataAccessException {

		String query;
		List<Author> listAuthorsBySurname = null;

		try { 
			query="SELECT a FROM Author a WHERE a.surname =?";
			listAuthorsBySurname =(List<Author>)this.getHibernateTemplate().find(query,surname);

		}catch(final DataAccessException e){
			logger.info("DAO:Authors list by surname not loaded,"+e);
		}

		if(listAuthorsBySurname.isEmpty()){
			logger.info("DAO:No authors with the specified surname.");

		}else{
			logger.info("DAO:List of author with the specified surname is no empty.");

			for(Author author : listAuthorsBySurname ){
				logger.info("DAO:List of author with the specified surname= "+author);
			}
		}
		return listAuthorsBySurname;
	}

	/**
	 * Return amount of authors in data base. If data base contain author return
	 * size of author list else return zero.
	 * 
	 * @type String
	 * @param surname
	 * @throw HibernateObjectRetrievalFailureException 
	 * @return Long
	 */
	public Long getAuthorsStatistics() {
		Long amountOfAuthors = null;
		String query;

		try{
			query="SELECT a.idAuthor FROM Author a";
			amountOfAuthors= (long)this.getHibernateTemplate().find(query).size();
			logger.info("DAO:Authors statustic loaded successfully");

		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("DAO:Authors statustic not loaded successfully"+e);
		}
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
	 * @throw HibernateObjectRetrievalFailureException
	 * @return Boolean
	 */
	@SuppressWarnings("unchecked")
	public Boolean signInByLoginPassword(String login,String password) throws DataAccessException{

		String query;
		List<Author> authorList = null;
		Boolean signIn;

		try {  
			query="SELECT a FROM Author a WHERE a.login = ? AND a.password = ?";
			authorList =(List<Author>) this.getHibernateTemplate().find(query,login,password);

		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("DAO:Author sign in is falled"+e);
		}

		if(authorList.isEmpty()){
			signIn=false;
			logger.info("DAO:Authorization is falled because author with the specified parameters "
					+ "not exist. Login="+login+" "+"Password= "+password);
		}else{
			if(authorList.size()<=1){
				logger.info("DAO:Authorization is successfully author with the specified parameters "
						+ "exist. Login= "+login+" "+"password= "+password);
				signIn=true;

			}else{
				logger.info("DAO:Exist several authors with identical login and password."
						+ "Login="+login+" "+"password="+password);
			}
			signIn=true;
		} 
		return signIn;
	}
}
