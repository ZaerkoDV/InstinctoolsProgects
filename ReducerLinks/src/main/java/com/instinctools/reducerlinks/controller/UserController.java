/**
 * 
 */
package com.instinctools.reducerlinks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instinctools.reducerlinks.model.User;

/**
 * @author Zaerko_DV
 *
 */
@Controller(value="userController")
public class UserController {

	@RequestMapping(value="/user/signUp", method = RequestMethod.GET)
	public String getUserSignUpPage() {
		return "user/signUp";
	}

	@RequestMapping(value = "/user/signUp", method = RequestMethod.POST)
	public @ResponseBody void addUser(@RequestBody User user) {
		//trainService.addTrain(train);
		System.out.println(user);
	}

}
