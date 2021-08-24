package com.etnetera.hr.model;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class JavaScriptFrameworkRequestModel {
	@NotEmpty
	private String name;

	private String version;

	private LocalDate deprecationDate;

	private BigDecimal hypeLevel;

	public JavaScriptFrameworkRequestModel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public LocalDate getDeprecationDate() {
		return deprecationDate;
	}

	public void setDeprecationDate(LocalDate deprecationDate) {
		this.deprecationDate = deprecationDate;
	}

	public BigDecimal getHypeLevel() {
		return hypeLevel;
	}

	public void setHypeLevel(BigDecimal hypeLevel) {
		this.hypeLevel = hypeLevel;
	}
}
