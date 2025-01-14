package com.iemr.helpline104.data.beneficiarycall;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_subservice")
public class M_subservice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private  Integer  subServiceID;
	private  String  subServiceName;
	private  String  subServiceDesc;
	private  Integer  providerServiceMapID;
	private  Boolean  deleted;
	private  Character  processed;
	private  String  createdBy;
	@Column(name = "CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable=false, updatable=false)
	private Date lastModDate;
	
	public M_subservice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public M_subservice(Integer subServiceID, String subServiceName, String subServiceDesc,
			Integer providerServiceMapID, Boolean deleted, Character processed) {
		super();
		this.subServiceID = subServiceID;
		this.subServiceName = subServiceName;
		this.subServiceDesc = subServiceDesc;
		this.providerServiceMapID = providerServiceMapID;
		this.deleted = deleted;
		this.processed = processed;
	}

	public Integer getSubServiceID() {
		return subServiceID;
	}

	public void setSubServiceID(Integer subServiceID) {
		this.subServiceID = subServiceID;
	}

	public String getSubServiceName() {
		return subServiceName;
	}

	public void setSubServiceName(String subServiceName) {
		this.subServiceName = subServiceName;
	}

	public String getSubServiceDesc() {
		return subServiceDesc;
	}

	public void setSubServiceDesc(String subServiceDesc) {
		this.subServiceDesc = subServiceDesc;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Character getProcessed() {
		return processed;
	}

	public void setProcessed(Character processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}
	
	public String toString() {
		return new Gson().toJson(this);
	}

}
