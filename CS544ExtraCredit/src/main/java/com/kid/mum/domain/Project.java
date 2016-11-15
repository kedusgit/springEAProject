package com.kid.mum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Project", catalog = "cs544spring")
public class Project {
	@Id
	@GeneratedValue
int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
