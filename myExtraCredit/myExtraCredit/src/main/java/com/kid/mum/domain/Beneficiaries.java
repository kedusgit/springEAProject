package com.kid.mum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beneficiaries {

	@Id @GeneratedValue
	int id;
	String somenthing;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSomenthing() {
		return somenthing;
	}
	public void setSomenthing(String somenthing) {
		this.somenthing = somenthing;
	}
	
}
