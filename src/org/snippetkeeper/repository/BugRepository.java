package org.snippetkeeper.repository;

import org.jboss.logging.Param;
import org.snippetkeeper.domain.Bug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long>{
//	@Query("select b from Bug b where b.id = :num")
//	Bug findBugById(@Param("num") int id);
}
