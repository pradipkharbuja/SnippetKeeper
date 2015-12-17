package org.snippetkeeper.repository;

import org.snippetkeeper.domain.Snippet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends CrudRepository<Snippet, Long>{

}
