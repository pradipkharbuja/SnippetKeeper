package org.snippetkeeper.repository;

import java.util.List;

import org.snippetkeeper.domain.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
		
		@Query("SELECT c from Category c WHERE c.user.userId = :userId")
		public List<Category> getAllCateogoriesByUser(@Param("userId") Long userId);
}
