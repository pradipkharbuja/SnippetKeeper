package org.snippetkeeper.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {

		Object userId = request.getSession().getAttribute("userId");

		System.out.println("User Id = " + userId);
		return "admin";
	}
}
