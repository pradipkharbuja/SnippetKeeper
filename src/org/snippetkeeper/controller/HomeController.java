package org.snippetkeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/home", "/index" }, method = RequestMethod.GET)
	public String index() {
		return "home";
	}

}
