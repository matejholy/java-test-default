package com.etnetera.hr.repository;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.data.JavaScriptFrameworkVersion;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring data repository interface used for accessing the framework version data in database.
 * 
 * @author Etnetera
 *
 */
public interface JavaScriptFrameworkVersionRepository extends CrudRepository<JavaScriptFrameworkVersion, Long> {

	JavaScriptFrameworkVersion findFirstByJavaScriptFrameworkAndVersionNumber(JavaScriptFramework framework, String versionNumber);

}
