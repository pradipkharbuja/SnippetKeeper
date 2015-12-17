package org.snippetkeeper.service.impl;

import java.util.List;

import org.snippetkeeper.domain.Bug;
import org.snippetkeeper.repository.BugRepository;
import org.snippetkeeper.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BugServiceImpl implements BugService{
	
	@Autowired
	private BugRepository bugRepository;
	
	@Override
	public void saveBug(Bug bug) {
		// TODO Auto-generated method stub
		bugRepository.save(bug);
		
	}

	@Override
	public List<Bug> findAll() {
		// TODO Auto-generated method stub
		return (List<Bug>) bugRepository.findAll();
	}

	@Override
	public Bug findById(long id) {
		// TODO Auto-generated method stub
		return bugRepository.findOne(id);
	}

}
