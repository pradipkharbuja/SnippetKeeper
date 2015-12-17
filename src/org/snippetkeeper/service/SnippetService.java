package org.snippetkeeper.service;

import java.util.List;

import org.snippetkeeper.domain.Snippet;

public interface SnippetService {
	
	void save(Snippet snippet);
	
	List<Snippet> getSnippet();

	Snippet getSnippet(Long snippetId);

	void delete(Long id);

}
