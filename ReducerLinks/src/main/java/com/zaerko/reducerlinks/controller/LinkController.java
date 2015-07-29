/**
 * 
 */
package com.zaerko.reducerlinks.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zaerko.reducerlinks.model.Link;
import com.zaerko.reducerlinks.service.ILinkService;

/**
 * @author Zaerko_DV
 *
 */
@Controller
public class LinkController {

	@Inject
	private ILinkService linkService;
	
	private static final Logger logger = LoggerFactory.getLogger(LinkController.class);
	
	@RequestMapping(value ="/link/addLink", method = RequestMethod.POST)
	public @ResponseBody String addLink(@RequestBody Link link, Long idAuthor) {
		
		logger.info("POST: Add new link.");
		
		Boolean isURLAddress= linkService.isUrlAddress(link.getLinkFullURL());
		logger.info("POST: Link contain correct url address="+isURLAddress);
		
		if(isURLAddress){
			linkService.addLink(link);
			logger.info("POST: New link save successfully.");
			
		}else{
			logger.info("POST: New link not save, because incorrect url address "+link.getLinkFullURL());
		}
		
		return "/author/authorpage";
	}
	
	@RequestMapping(value ="/link/updateLink", method = RequestMethod.POST)
	public @ResponseBody String updateLink(@RequestBody Link link) {

		logger.info("POST: Update link.");
		
		Boolean isURLAddress= linkService.isUrlAddress(link.getLinkFullURL());
		logger.info("POST: Link contain correct url address="+isURLAddress);
		
		if(isURLAddress){
			linkService.updateLink(link);
			logger.info("POST: Link update successfully.");
			
		}else{
			logger.info("POST: Link, which update have incorrect url address "+link.getLinkFullURL());
		}
		
		return "/author/authorpage";
	}
	
	@RequestMapping(value ="/link/removeLink/{idAuthor}", method = RequestMethod.POST)
	public String removeLink(ModelMap modelMap, @PathVariable("idLink") Long idLink) {
		
		logger.info("POST: Delete link.");
		
		linkService.removeLink(idLink);
		logger.info("POST: Link delete successfully.");
		
		return "/author/authorpage";
	}
	
	
	@RequestMapping(value ="link/tagpage/{urlTag}")
	public @ResponseBody List<Link> getAllLinksList(@PathVariable("urlTag") String urlTag) {
		logger.info("POST: List of links by tag="+urlTag+" load successfully");
		return linkService.getLinkListByTag(urlTag);
	}
	
	@RequestMapping(value ="link/tagpage/{urlTag}", method= RequestMethod.GET)
	public String getTagPage(ModelMap modelMap, @PathVariable("urlTag") String urlTag) {
		logger.info("POST: Page with list of links by tag= "+urlTag);
	
		return "/link/tagpage";
	}

}
