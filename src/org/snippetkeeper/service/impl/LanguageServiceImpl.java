package org.snippetkeeper.service.impl;

import java.util.List;

import org.snippetkeeper.domain.Language;
import org.snippetkeeper.repository.LanguageRepository;
import org.snippetkeeper.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Override
	public List<Language> findAll() {
		return (List<Language>) languageRepository.findAll();
	}
	
	@Override
	public Language getLanguage(String langName) {
		return languageRepository.findOne(langName);
	}

}
