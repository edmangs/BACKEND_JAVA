package com.appjava.admin.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.appjava.core.entity.BaseEntity;

import lombok.Builder;

@Builder
@Entity
@Table(name = "USER")
public class EntityUser extends BaseEntity {
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(255) NOT NULL")
    private String firstName;
	
	@Column(name = "LAST_NAME", columnDefinition = "VARCHAR(255) NOT NULL")
    private String lastName;
	
	@Column(name = "AGE")
    private Long age;
	
	@Column(name = "EMAIL", columnDefinition = "VARCHAR(255) NOT NULL")
    private String email;

	@Override
	public Long getId() {
		return id;
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

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
