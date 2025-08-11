package com.webage.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//	PART 3:
//	Use an annotation to mark this class as a JPA entity.
//	Use a separate annotation to override the table name to be "CUSTOMERS".
//	Use an annotation to mark the id field as the primary key.
//  Also mark it with @GeneratedValue(strategy=GenerationType.IDENTITY).
//	Use an annotation to override the column name to be "CUSTOMER_NAME".

@Entity
@Table(name="CUSTOMERS")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;

	@Column(name="CUSTOMER_NAME")
	String name;
	
	String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
