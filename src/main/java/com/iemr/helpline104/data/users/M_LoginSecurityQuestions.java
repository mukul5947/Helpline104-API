package com.iemr.helpline104.data.users;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "m_loginsecurityquestions")
public class M_LoginSecurityQuestions {
	@Id
	@Column(name = "QuestionID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer QuestionID;
	private String Question;
	private Boolean Deleted;
	private String CreatedBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date CreatedDate;
	private String ModifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date LastModDate;

	@OneToOne(mappedBy = "m_LoginSecurityQuestions")
	@PrimaryKeyJoinColumn
	private M_UserSecurityQMapping m_UserSecurityQMapping;

	protected M_LoginSecurityQuestions() {

	}

	public M_LoginSecurityQuestions(Integer questionID, String question, Boolean deleted, String createdBy,
			Date createdDate, String modifiedBy, Date lastModDate) {
		super();
		QuestionID = questionID;
		Question = question;
		Deleted = deleted;
		CreatedBy = createdBy;
		CreatedDate = createdDate;
		ModifiedBy = modifiedBy;
		LastModDate = lastModDate;
	}

	public Integer getQuestionID() {
		return QuestionID;
	}

	public String getQuestion() {
		return Question;
	}

	public Boolean getDeleted() {
		return Deleted;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public Date getLastModDate() {
		return LastModDate;
	}

	public M_UserSecurityQMapping getM_UserSecurityQMapping() {
		return m_UserSecurityQMapping;
	}

	public void setQuestionID(Integer questionID) {
		QuestionID = questionID;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public void setDeleted(Boolean deleted) {
		Deleted = deleted;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public void setLastModDate(Date lastModDate) {
		LastModDate = lastModDate;
	}

	public void setM_UserSecurityQMapping(M_UserSecurityQMapping m_UserSecurityQMapping) {
		this.m_UserSecurityQMapping = m_UserSecurityQMapping;
	}

	/**
	 * wasim constructor wit parameter
	 * 
	 * @param questionID
	 * @param question
	 */
	public M_LoginSecurityQuestions(Integer questionID, String question) {

		QuestionID = questionID;
		Question = question;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
