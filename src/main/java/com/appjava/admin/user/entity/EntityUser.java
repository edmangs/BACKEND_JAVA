package com.appjava.admin.user.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.appjava.core.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER")
public class EntityUser extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "ID", unique=true, nullable = false)
	private Long id;
	
	@Basic(optional = false)
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
