/**
 * 
 */
package com.sudhir.model;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "userdb")
public class Userdb implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "address")
	private String address;

	public Userdb(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
