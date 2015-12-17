package org.snippetkeeper.repository;

import org.snippetkeeper.domain.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, String> {

}
