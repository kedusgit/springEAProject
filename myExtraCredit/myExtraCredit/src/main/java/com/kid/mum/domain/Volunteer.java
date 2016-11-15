package com.kid.mum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Volunteer {
	@Id
	@GeneratedValue
	private int idV;
	private String name;
	private String skill;
	public int getidV() {
		return idV;
	}
	public void setidV(int idV) {
		this.idV = idV;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}

}
