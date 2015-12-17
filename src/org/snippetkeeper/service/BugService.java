package org.snippetkeeper.service;

import java.util.List;

import org.snippetkeeper.domain.Bug;

public interface BugService {
	
	void saveBug(Bug bug);
	
	List<Bug> findAll();
	
	Bug findById(long id);
}
