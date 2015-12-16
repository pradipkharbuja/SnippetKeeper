package org.snippetkeeper.service;

import org.snippetkeeper.domain.User;

public interface UserService {

	public void addUser(User user);
	
	public boolean isExisted(String username);
}
