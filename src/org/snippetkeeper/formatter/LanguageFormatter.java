package org.snippetkeeper.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.snippetkeeper.domain.Language;
import org.snippetkeeper.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

public class LanguageFormatter implements Formatter<Language> {

	@Autowired
	LanguageService langaugeService;
	
	@Override
	public String print(Language category, Locale locale) {
		return category.getLangName();
	}

	@Override
	public Language parse(String source, Locale locale) throws ParseException {
		Language language = null;
		try {
			language = langaugeService.getLanguage(source);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return language;
	}

}
