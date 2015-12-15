package org.snippetkeeper.repository;

import org.snippetkeeper.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer>{

}
