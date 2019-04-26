/**
 * 
 */
package com.sudhir.config.multidatasource.postgres.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sudhirk
 *
 */
@Entity
@Table(name = "postgresdomainpojo")
public class PostgresDomainPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String lastName;

	public PostgresDomainPojo() {
	}

	public PostgresDomainPojo(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
