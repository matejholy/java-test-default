package com.etnetera.hr.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

/**
 * Simple data entity describing basic properties of every JavaScript framework.
 *
 * @author Etnetera
 */
@Entity
public class JavaScriptFramework {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;

	@OneToMany(mappedBy = "javaScriptFramework", cascade = CascadeType.ALL)
	private Set<JavaScriptFrameworkVersion> version;

	@Column
	private LocalDate deprecationDate;

	@Column
	private BigDecimal hypeLevel;

	public JavaScriptFramework() {
	}

	public JavaScriptFramework(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<JavaScriptFrameworkVersion> getVersion() {
		return version;
	}

	public void setVersion(Set<JavaScriptFrameworkVersion> version) {
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

	@Override
	public String toString() {
		return "JavaScriptFramework [id=" + id + ", name=" + name + ", deprecationDate=" + deprecationDate + ", hypeLevel=" + hypeLevel + "]";
	}

}
