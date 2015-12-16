package org.snippetkeeper.controller;

import java.util.List;

import javax.validation.Valid;

import org.snippetkeeper.domain.Category;
import org.snippetkeeper.domain.Language;
import org.snippetkeeper.domain.Snippet;
import org.snippetkeeper.service.CategoryService;
import org.snippetkeeper.service.LanguageService;
import org.snippetkeeper.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/snippet")
public class SnippetController {

	@Autowired
	private SnippetService snippetService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSnippet(@ModelAttribute("newSnippet") Snippet snippet, Model model) {
		List<Language> languages = languageService.findAll();
		model.addAttribute("languagesAvilable", languages);

		List<Category> avilableCategories = categoryService.getCategoriesByUser(1l);
		model.addAttribute("formCategories", avilableCategories);
		return "addSnippet";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSnippet(@Valid @ModelAttribute("newSnippet") Snippet snippet, BindingResult result) {
		if (result.hasErrors()) {
			return "forward:/add";
		}

		snippetService.save(snippet);
		return "addSnippet";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[]{"user"});
	}
}
