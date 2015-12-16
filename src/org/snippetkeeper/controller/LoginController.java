package org.snippetkeeper.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snippetkeeper.domain.Role;
import org.snippetkeeper.domain.User;
import org.snippetkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private UserService UserService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String loginSuccess(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = UserService.getUserByUsername(auth.getName());
		if (user == null) {
			return "redirect:/login";
		}

		request.getSession().setAttribute("userId", user.getUserId());

		if (request.isUserInRole(Role.ROLE_ADMIN.toString())) {
			return "redirect:/admin";
		} else {
			return "redirect:/user";
		}
	}
}
