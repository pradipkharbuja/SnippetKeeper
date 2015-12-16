package org.snippetkeeper.service.impl;

import org.snippetkeeper.domain.Snippet;
import org.snippetkeeper.repository.SnippetRepository;
import org.snippetkeeper.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SnippetServiceImpl implements SnippetService {
	
	@Autowired
	SnippetRepository snippetRepository;
	
	@Override
	public void save(Snippet snippet) {
		snippetRepository.save(snippet);
	}

}
