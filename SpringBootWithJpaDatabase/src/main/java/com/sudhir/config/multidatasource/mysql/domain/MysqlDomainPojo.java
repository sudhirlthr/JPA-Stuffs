package com.sudhir.config.multidatasource.mysql.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mysqldomainpojo")
public class MysqlDomainPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String firstName;


	public MysqlDomainPojo() {}


	public MysqlDomainPojo(String fan) {
		this.firstName = fan;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFan() {
		return firstName;
	}


	public void setFan(String fan) {
		this.firstName = fan;
	}
}
