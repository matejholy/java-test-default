package com.etnetera.hr.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Simple data entity representing a JavaScript framework version.
 * 
 * @author Matej
 *
 */
@Entity
public class JavaScriptFrameworkVersion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 30)
	private String versionNumber;

	@ManyToOne
	@JoinColumn(name = "java_script_framework_id")
	@JsonIgnore
	private JavaScriptFramework javaScriptFramework;

	public JavaScriptFrameworkVersion() {
	}

	public JavaScriptFrameworkVersion(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public JavaScriptFramework getJavaScriptFramework() {
		return javaScriptFramework;
	}

	public void setJavaScriptFramework(JavaScriptFramework javaScriptFramework) {
		this.javaScriptFramework = javaScriptFramework;
	}

	@Override
	public String toString() {
		return "JavaScriptFramework version [id=" + id + ", versionNumber=" + versionNumber + "]";
	}

}
