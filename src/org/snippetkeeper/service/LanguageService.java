package org.snippetkeeper.service;

import java.util.List;

import org.snippetkeeper.domain.Language;

public interface LanguageService {
	
	List<Language> findAll();

	Language getLanguage(String langName);

}
