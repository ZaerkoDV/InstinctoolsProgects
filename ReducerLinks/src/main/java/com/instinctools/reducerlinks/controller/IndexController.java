/**
 * 
 */
package com.instinctools.reducerlinks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Zaerko_DV
 *
 */
@Controller(value="indexController")
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
		
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}
}
