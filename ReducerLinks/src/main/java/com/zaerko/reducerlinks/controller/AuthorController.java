/**
 * 
 */
package com.zaerko.reducerlinks.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zaerko.reducerlinks.model.Author;
import com.zaerko.reducerlinks.model.Link;
import com.zaerko.reducerlinks.service.IAuthorService;
import com.zaerko.reducerlinks.service.ILinkService;

/**
 * @author Zaerko_DV
 *
 */
@Controller
public class AuthorController {

	@Inject
	private IAuthorService authorService;
	
	@Inject
	private ILinkService linkService;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

	@RequestMapping(value ="/index")
	public @ResponseBody List<Link> getAllLinksList() {
		return linkService.getAllLink();
	}
	
	
	@RequestMapping(value ="/index", method= RequestMethod.GET)
	public String getIndexPage(ModelMap modelMap) {
		return "/index";
	}
	
	@RequestMapping(value ="/author/failure", method= RequestMethod.GET)
	public String getFailurePage(ModelMap modelMap) {
		return "/author/failure";
	}

	@RequestMapping(value ="/author/authorization", method = RequestMethod.GET)
	public String getAuthorizationPage(ModelMap modelMap) {//Model model
		logger.info("GET: Author authorization");
		return "/author/authorization";
	}
	
	@RequestMapping(value = "/author/authorization", method = RequestMethod.POST)
    public @ResponseBody String signInAuthor(@Valid @RequestBody Author author, ModelMap modelMap) {
		logger.info("POST: Author authorization");
		
		
		Boolean status=authorService.signInByLoginPassword(author.getLogin(), author.getPassword());
		Long idAuthor = authorService.getIdAuthorByLoginPassword(author.getLogin(), author.getPassword());
		String path = "/author/failure";
		
		if(status){
			path = "/author/authorpage/"+idAuthor+"";
		}
        return path;
    }
	
	@RequestMapping(value ="/author/registration", method = RequestMethod.GET)
	public String getRegistrationPage(ModelMap modelMap) {//Model model
		logger.info(" GET:Author registration");
		return "/author/registration";
	}
	
	@RequestMapping(value = "/author/registration", method = RequestMethod.POST)
    public @ResponseBody String addAuthor(@RequestBody Author author) {
		
		logger.info("POST: Author registration.");
		String path="/author/failure";
		
		Boolean isUniqueLoginPassword= authorService.isUniqueLoginPassword(author.getLogin(), author.getPassword());
		logger.info("POST: Author registration. Login and password is unique="+isUniqueLoginPassword);
		
		Boolean isEmail=authorService.isEmailAddres(author.getEmail());
		logger.info("POST: Author registration. Is mail addres="+isEmail);		
		
		if(isUniqueLoginPassword && isEmail){
			authorService.addAuthor(author);
			logger.info("POST: Author registration. Save new author with id="+author.getIdAuthor());
			path="/index";
		}else{
			logger.info("POST: Author registration. New author not saved");
		}
		return path;
	}
	
	@RequestMapping(value ="/author/authorpage/{idAuthor}", method = RequestMethod.GET)
	public String getAuthorPage(ModelMap modelMap, @PathVariable("idAuthor") Long idAuthor) { 
		logger.info("GET: Author page, idAuthor="+idAuthor);
		//Author author=authorService.getAuthorById(idAuthor);
		//linkService.getLinkListByLogin(author.getLogin());
		return "/author/authorpage"; 					
	}

}
