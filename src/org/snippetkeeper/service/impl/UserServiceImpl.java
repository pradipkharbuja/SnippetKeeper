package org.snippetkeeper.service.impl;

import org.snippetkeeper.domain.User;
import org.snippetkeeper.repository.UserRepository;
import org.snippetkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(User user) {		
		userRepository.save(user);
	}

	@Override
	public boolean isExisted(String username) {
		User user = userRepository.getUserByUsername(username);
		if(user == null){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public User getUserByUsername(String username) {		
		return userRepository.getUserByUsername(username);
	}

}
