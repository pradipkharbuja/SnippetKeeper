package org.snippetkeeper.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.snippetkeeper.domain.Category;
import org.snippetkeeper.domain.User;
import org.snippetkeeper.service.CategoryService;
import org.snippetkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public @ResponseBody Category saveCategory(@Valid @RequestBody Category category, HttpServletRequest request) {
		Object userId = request.getSession().getAttribute("userId");
		Long uId = (Long) userId;
		System.out.println(uId);
		User user = userService.getUser(uId);
		category.setUser(user);

		categoryService.saveCategory(category);
		return category;
	}
}
