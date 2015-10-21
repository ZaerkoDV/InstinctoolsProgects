/**
 * 
 */
package com.instinctools.reducerlinks.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserCorespondence;
import com.instinctools.reducerlinks.model.UserSecurity;
import com.instinctools.reducerlinks.service.LinkService;
import com.instinctools.reducerlinks.service.UserCorespondenceService;
import com.instinctools.reducerlinks.service.UserSecurityService;
import com.instinctools.reducerlinks.service.UserService;

/**
 * @author Zaerko_DV
 *
 */
@Controller(value="userController")
@RequestMapping(value="/user")
public class UserController {

	@Inject
	@Qualifier(value="userService")
	private UserService userService;

	@Inject
	@Qualifier(value="userSecurityService")
	private UserSecurityService userSecurityService;
	
	@Inject
	@Qualifier(value="userCorespondenceService")
	private UserCorespondenceService userCorespondenceService;

	@Inject
	@Qualifier(value="linkService")
	private LinkService linkService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUserSecurityService(UserSecurityService userSecurityService) {
		this.userSecurityService = userSecurityService;
	}

	public void setUserCorespondenceService(
			UserCorespondenceService userCorespondenceService) {
		this.userCorespondenceService = userCorespondenceService;
	}
	
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}

	//registration date problem
	@RequestMapping(value="/signUp", method = RequestMethod.GET)
	public String getUserSignUpPage() {
		return "user/signUp";
	}

	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public @ResponseBody String saveUser(@RequestBody UserSecurity userSecurity) {

		String login=userSecurity.getLogin();
		String password=userSecurity.getPassword();
		if(userSecurityService.isUniqueLoginPassword(login, password)){

			User user=userSecurity.getUser();
			userService.saveEntity(user);
			userSecurity.setRole("user");
			userSecurity.setUser(user);
			userSecurityService.saveEntity(userSecurity);
			return "/";
		}else{
			return "user/signUp";	
		}
	}

	//autorization
	@RequestMapping(value="/signIn", method = RequestMethod.GET)
	public String getUserSignInPage() {
		return "user/signIn";
	}

	@RequestMapping(value="/signIn/userData.json", method = RequestMethod.POST)
	public @ResponseBody Long userAutorization(@RequestBody UserSecurity userSecurity) {

		if(userService.signInUserByLoginPassword(userSecurity.getLogin(), userSecurity.getPassword())){
			return userService.getIdUserByLoginPassword(userSecurity.getLogin(), userSecurity.getPassword());
		}else{
			return null;									
		}
	}
	
	@RequestMapping(value="/getRedirectTo/{id}", method = RequestMethod.GET)
	public @ResponseBody String getUserAccountPage(@PathVariable("id") Long id) {
		
		String role=userService.getUserRoleByUserId(id);
		if(role.equals("user")){
			return "user/userAccount";
			
		}else if(role.equals("admin")){
			return "admin/adminAccount";
			
		}else{
			return "/";	
		}
	}
//not worked	
	@RequestMapping(value = "/userAccount", method = RequestMethod.GET)
	public String getUserPage() {
		return "user/userAccount";
	}
	
	@RequestMapping(value = "/addCorespondence", method = RequestMethod.GET)
	public String getUserCorespondencePage() {
		return "user/addCorespondence";
	}
	
	@RequestMapping(value="/addUserCorespondence", method = RequestMethod.POST)
	public @ResponseBody void saveCorespondence(@RequestBody UserCorespondence userCorespondence) {
		
		String email=userCorespondence.getEmail();
		Boolean unique=userCorespondenceService.isUniqueEmail(email);
		Boolean valid=userCorespondenceService.isValidEmail(email);
		if(unique && valid){
			User user = (User) userService.getEntityById(User.class, userCorespondence.getUser().getIdUser());
			userCorespondence.setUser(user);
		    userService.saveEntity(userCorespondence);	
		}else{
			
		}
	}

}
