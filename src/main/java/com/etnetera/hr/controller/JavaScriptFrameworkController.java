package com.etnetera.hr.controller;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.data.JavaScriptFrameworkVersion;
import com.etnetera.hr.mapper.JavaScriptFrameworkModelToEntityMapper;
import com.etnetera.hr.model.JavaScriptFrameworkRequestModel;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import com.etnetera.hr.repository.JavaScriptFrameworkVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Simple REST controller for accessing application logic.
 *
 * @author Etnetera
 */
@RestController
@RequestMapping("/frameworks")
public class JavaScriptFrameworkController {

	private final JavaScriptFrameworkRepository frameWorkRepository;
	private final JavaScriptFrameworkVersionRepository versionRepository;

	@Autowired
	public JavaScriptFrameworkController(JavaScriptFrameworkRepository repository, JavaScriptFrameworkVersionRepository versionRepository) {
		this.frameWorkRepository = repository;
		this.versionRepository = versionRepository;
	}

	@GetMapping
	public Iterable<JavaScriptFramework> frameworks() {
		return frameWorkRepository.findAll();
	}

	@PostMapping
	public JavaScriptFramework createFramework(@Validated @RequestBody JavaScriptFrameworkRequestModel requestModel) {
		// does the framework already exist?
		JavaScriptFramework framework = frameWorkRepository.findFirstByNameIgnoreCase(requestModel.getName());

		if (framework == null) {
			framework = JavaScriptFrameworkModelToEntityMapper.requestModelToEntity(requestModel);
			framework = frameWorkRepository.save(framework);
		} else if (requestModel.getVersion() != null) {
			// insert version only, if present in request but not in database
			JavaScriptFrameworkVersion version = versionRepository.findFirstByJavaScriptFrameworkAndVersionNumber(framework, requestModel.getVersion());
			if (version == null) {
				version = new JavaScriptFrameworkVersion();
				version.setJavaScriptFramework(framework);
				version.setVersionNumber(requestModel.getVersion());
				framework.getVersion().add(version);
				framework = frameWorkRepository.save(framework);
			}

			// TODO return error when request contains other attributes than name and version
		}

		return framework;
	}

	@PutMapping("/{id}")
	public ResponseEntity<JavaScriptFramework> updateFramework(@PathVariable Long id,
															   @Validated(JavaScriptFrameworkRequestModel.UPDATE.class)
															   @RequestBody JavaScriptFrameworkRequestModel requestModel) {
		Optional<JavaScriptFramework> frameworkOptional = frameWorkRepository.findById(id);

		if (frameworkOptional.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			JavaScriptFramework framework = frameworkOptional.get();
			framework.setName(requestModel.getName());
			framework.setDeprecationDate(requestModel.getDeprecationDate());
			framework.setHypeLevel(requestModel.getHypeLevel());
			return ResponseEntity.ok(frameWorkRepository.save(framework));
		}
	}
}
