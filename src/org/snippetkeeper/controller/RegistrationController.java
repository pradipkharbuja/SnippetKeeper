package org.snippetkeeper.controller;

import javax.validation.Valid;

import org.snippetkeeper.domain.User;
import org.snippetkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/registration")
@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(@ModelAttribute("user") User user) {
		return "registration";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String indexPost(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "registration";
		}
		userService.addUser(user);
		return "registration";
	}
}