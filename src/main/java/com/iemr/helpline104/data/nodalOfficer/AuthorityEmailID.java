package com.iemr.helpline104.data.nodalOfficer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline104.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_authorityemail")
public class AuthorityEmailID {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AuthorityEmailID")
	private Integer authorityEmailID;
	
	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;
	
	@Column(name = "EmailID")
	@Expose
	private String emailID;
	
	@Column(name = "Deleted")
	private Boolean deleted;
	@Column(name = "BlockID")
	@Expose
	private Integer blockID;
	@Column(name = "ContactNo")
	@Expose
	private String contactNo;
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Integer getAuthorityEmailID() {
		return authorityEmailID;
	}

	public void setAuthorityEmailID(Integer authorityEmailID) {
		this.authorityEmailID = authorityEmailID;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getBlockID() {
		return blockID;
	}

	public void setBlockID(Integer blockID) {
		this.blockID = blockID;
	}

	public OutputMapper getOutputMapper() {
		return outputMapper;
	}

	public void setOutputMapper(OutputMapper outputMapper) {
		this.outputMapper = outputMapper;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}