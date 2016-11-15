package com.kid.mum.domain;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {
	@Id
	 @GeneratedValue
	private int pId;
	private String name;
	private String description;
	private String status;
	private Date startDate;
	private Date endDate;
	
	private List<Beneficiary>ben;
	public int getProjectId() {
		return pId;
	}
	public void setProjectId(int pId) {
		this.pId =pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "startdate", nullable = false, length = 19)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "enddate", nullable = false, length = 19)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="project")
	public List<Beneficiary> getBeneficiaries() {
		return ben;
	}
	@OneToMany(fetch = FetchType.EAGER,mappedBy="project")
	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.ben = beneficiaries;
	}

}
