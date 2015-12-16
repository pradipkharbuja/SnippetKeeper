package org.snippetkeeper.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.snippetkeeper.domain.Category;
import org.snippetkeeper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

public class CategoryFormatter implements Formatter<Category> {

	@Autowired
	CategoryService categoryService;
	
	@Override
	public String print(Category category, Locale locale) {
		return category.getCategoryName();
	}

	@Override
	public Category parse(String source, Locale locale) throws ParseException {
		Category category = null;
		try {
			Long id = Long.parseLong(source);
			category = categoryService.getCateogry(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return category;
	}

}
