package com.etnetera.hr.repository;

import com.etnetera.hr.data.JavaScriptFramework;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Spring data repository interface used for accessing the data in database.
 * 
 * @author Etnetera
 *
 */
public interface JavaScriptFrameworkRepository extends CrudRepository<JavaScriptFramework, Long> {

	JavaScriptFramework findFirstByNameIgnoreCase(String frameworkName);

	@Query("FROM JavaScriptFramework WHERE UPPER(name) LIKE %?#{[0].toUpperCase()}%")
	Iterable<JavaScriptFramework> findByStringInNameIgnoreCase(String frameworkName, Sort sort);
}
