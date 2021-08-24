package com.etnetera.hr.mapper;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.data.JavaScriptFrameworkVersion;
import com.etnetera.hr.model.JavaScriptFrameworkRequestModel;

import java.util.Set;

/**
 * Converts REST model to database entity.
 */
final public class JavaScriptFrameworkModelToEntityMapper {

	public static JavaScriptFramework requestModelToEntity(JavaScriptFrameworkRequestModel model) {
		if (model == null)
			return null;
		else {
			JavaScriptFramework entity = new JavaScriptFramework();
			entity.setName(model.getName());
			entity.setDeprecationDate(model.getDeprecationDate());
			entity.setHypeLevel(model.getHypeLevel());

			if (model.getVersion() != null) {
				JavaScriptFrameworkVersion version = new JavaScriptFrameworkVersion();
				version.setJavaScriptFramework(entity);
				version.setVersionNumber(model.getVersion());
				entity.setVersion(Set.of(version));
			}

			return entity;
		}
	}

}
