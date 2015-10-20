package com.instinctools.reducerlinks.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.model.LinkHistory;
import com.instinctools.reducerlinks.model.User;
import com.instinctools.reducerlinks.model.UserSecurity;
import com.instinctools.reducerlinks.service.LinkHistoryService;
import com.instinctools.reducerlinks.service.LinkService;
import com.instinctools.reducerlinks.service.UserService;

@Controller(value="linkController")
@RequestMapping("/link")
public class LinkController {

	@Inject
	@Qualifier(value="userService")
	private UserService userService;

	@Inject
	@Qualifier(value="linkService")
	private LinkService linkService;
	
	@Inject
	@Qualifier(value="linkHistoryService")
	private LinkHistoryService linkHistoryService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
	
	public void setLinkHistoryService(LinkHistoryService linkHistoryService) {
		this.linkHistoryService = linkHistoryService;
	}

	@RequestMapping("/links")
	public String getLinksPage(ModelMap modelMap) {
		return "link/links";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/linkslist.json")
	public @ResponseBody List<Link> getLinkList(){
		List<Link> allLinks=(List)linkService.getAllEntity(Link.class);
		return allLinks;
	}

	@RequestMapping("/tags")
	public String getTagsPage(ModelMap modelMap) {
		return "link/tags";
	}

	@RequestMapping("/tagslist.json")
	public @ResponseBody List<String> getTagList(){
		List<String> allTags=linkService.getListUniqueTag();
		return allTags;
	}

	@RequestMapping(value = "/searchTag/{tag}/searchTagResult.json", method = RequestMethod.GET)
	public @ResponseBody List<Link> searchTag(@PathVariable("tag") String tag) {
		return linkService.getListLinkByTagSortByDate(tag);
	}
	
	@RequestMapping(value = "/searchAuthor/{idUser}/searchAuthorResult.json", method = RequestMethod.GET)
	public @ResponseBody List<Link> searchAuthor(@PathVariable("idUser") Long idUser) {
		return userService.getUserLinksSortByRecency(idUser);
	}

	
	//как образатывать запрос на другом контроллере	
	@RequestMapping("/newLink")
	public String getNewLinkPage(ModelMap modelMap) {
		return "link/newLink";
	}
 	
	@RequestMapping(value="/newLink", method = RequestMethod.POST)
	public @ResponseBody void saveLink(@RequestBody LinkHistory linkHistory) {

		Long idUser=linkHistory.getLink().getUser().getIdUser();
		User user=(User) userService.getEntityById(User.class, idUser);
		
		//save link
		Link link=linkHistory.getLink();
		String shortUrl=linkService.reduceURL(link.getFullUrl());
		link.setShortUrl(shortUrl);
		link.setUser(user);
		linkService.saveEntity(link);
		
		//save link history
		linkHistory.setIpAddress("ipAddress");
		linkHistory.setLastCreate(new Date());
		linkHistory.setSumClick((long)0);
		linkHistory.setLink(link);
		linkHistoryService.saveEntity(linkHistory);
	}
	
	@RequestMapping("/userLinks")
	public String getUserLinksPage(ModelMap modelMap) {
		return "link/userLinks";
	}
	
}
