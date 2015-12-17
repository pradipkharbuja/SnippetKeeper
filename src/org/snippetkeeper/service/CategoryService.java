package org.snippetkeeper.service;

import java.util.List;

import org.snippetkeeper.domain.Category;

public interface CategoryService {
	
	List<Category> getCategoriesByUser(Long userId);

	Category getCateogry(Long categoryId);

	void saveCategory(Category category);

}
