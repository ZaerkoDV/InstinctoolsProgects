package com.instinctools.reducerlinks.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instinctools.reducerlinks.model.Link;
import com.instinctools.reducerlinks.service.LinkService;
import com.instinctools.reducerlinks.service.UserService;

@Controller(value="linkController")
@RequestMapping("/link")
public class LinkController {

	@Inject
	private UserService userService;

	@Inject
	private LinkService linkService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
	
	@RequestMapping("/links")//value="/links",
	public String getLinksPage(ModelMap modelMap) {
		return "link/links";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/linkslist.json")
	public @ResponseBody List<Link> getLinkList(){
		List<Link> allLinks=(List)linkService.getAllEntity(Link.class);
		return allLinks;
	}
}
