package org.snippetkeeper.service.impl;

import java.util.List;

import org.snippetkeeper.domain.Category;
import org.snippetkeeper.repository.CategoryRepository;
import org.snippetkeeper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategoriesByUser(Long userId) {
		return categoryRepository.getAllCateogoriesByUser(userId);
	}
	
	@Override
	public Category getCateogry(Long categoryId) {
		return categoryRepository.findOne(categoryId);
	}

}
