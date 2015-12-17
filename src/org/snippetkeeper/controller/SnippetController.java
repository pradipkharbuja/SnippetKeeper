package org.snippetkeeper.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.snippetkeeper.domain.Category;
import org.snippetkeeper.domain.Language;
import org.snippetkeeper.domain.Snippet;
import org.snippetkeeper.domain.User;
import org.snippetkeeper.exception.SnippetNotFoundException;
import org.snippetkeeper.service.CategoryService;
import org.snippetkeeper.service.LanguageService;
import org.snippetkeeper.service.SnippetService;
import org.snippetkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/snippet")
public class SnippetController {

	@Autowired
	private SnippetService snippetService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String listSnippets(Model model) {
		List<Snippet> snippets = snippetService.getSnippet();
		if (snippets.isEmpty()) {
			model.addAttribute("noSnippets", true);
		} else {
			model.addAttribute("snippets", snippets);
		}
		return "snippets";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSnippet(@ModelAttribute("newSnippet") Snippet snippet, Model model) {
		// TODO - keep this is model attribute
		List<Language> languages = languageService.findAll();
		model.addAttribute("languagesAvilable", languages);

		List<Category> avilableCategories = categoryService.getCategoriesByUser(1l);
		model.addAttribute("formCategories", avilableCategories);
		return "addSnippet";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSnippet(@Valid @ModelAttribute("newSnippet") Snippet snippet, BindingResult result,
			HttpServletRequest request) {

		Object userId = request.getSession().getAttribute("userId");
		Long uId = (Long) userId;
		User user = userService.getUser(uId);
		snippet.setUser(user);

		if (result.hasErrors()) {
			return "addSnippet";
		}

		snippetService.save(snippet);
		return "addSnippet";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showSnippet(@PathVariable Long id, HttpServletRequest request, Model model) {
		Snippet snippet = snippetService.getSnippet(id);
		// get current user
		Object userId = request.getSession().getAttribute("userId");
		Long uId = (Long) userId;
		User user = userService.getUser(uId);
		if(snippet != null) {
			if (user.getUserId() == snippet.getUser().getUserId()) {
				model.addAttribute("snippet", snippet);
				return "snippetDetail";
			}
		}
		throw new SnippetNotFoundException(String.valueOf(id));
	}

	@ExceptionHandler(SnippetNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, SnippetNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", exception.getMessage());
		mav.setViewName("/error-pages/page-not-found");
		return mav;
	}

}
