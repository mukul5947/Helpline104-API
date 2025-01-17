package com.iemr.helpline104.repository.report;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.report.FeedbackReport;

@Repository
@RestResource(exported = false)
public interface FeedbackReportRepository extends CrudRepository<FeedbackReport, Long>
{

	@Query("select t.feedbackID, t.requestID, t.beneficiaryRegID, t.benCallID, t.feedbackAgainst, t.designation, t.institutionName, t.stateName, "
			+ "t.districtName, t.blockName, t.districtBranchName, t.instituteTypeName, t.severityName, t.feedbackTypeName, t.feedbackNatureName, t.feedbackStatusName, t.feedback, t.userID, t.smsPhoneNo, t.serviceAvailDate, t.createdDate, b.beneficiaryID, b.firstName, b.lastName, b.healthCareWorker, b.gender, b.dob, b.permVillage, b.permSubDistrict, b.permDistrict, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+ "from FeedbackReport t "
			+ "LEFT JOIN t.beneficiaryReport b " + " LEFT JOIN t.bencallReport c "
			+ "left join c.userReportObj user "	
			+ "where t.providerServiceMapID=:providerServiceMapID "
			+ "and t.createdDate > :startDateTime " + "and t.createdDate < :endDateTime " + "order by t.createdDate desc")
	public List<Objects[]> getFeedbackReportByDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime);
	
	@Query("select t.feedbackID, t.requestID, t.beneficiaryRegID, t.benCallID, t.feedbackAgainst, t.designation, t.institutionName, t.stateName, "
			+ "t.districtName, t.blockName, t.districtBranchName, t.instituteTypeName, t.severityName, t.feedbackTypeName, t.feedbackNatureName, t.feedbackStatusName, t.feedback, t.userID, t.smsPhoneNo, t.serviceAvailDate, t.createdDate, b.beneficiaryID, b.firstName, b.lastName, b.healthCareWorker, b.gender, b.dob, b.permVillage, b.permSubDistrict, b.permDistrict, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+ "from FeedbackReport t "
			+ "LEFT JOIN t.beneficiaryReport b " + " LEFT JOIN t.bencallReport c "
			+ "left join c.userReportObj user "	
			+ "where t.providerServiceMapID=:providerServiceMapID " + "and c.agentID =:agentID "
			+ "and t.createdDate > :startDateTime " + "and t.createdDate < :endDateTime " + "order by t.createdDate desc")
	public List<Objects[]> getFeedbackReportByAgentIDAndDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("agentID") String agentID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime);
	
	@Query("select t.feedbackID, t.requestID, t.beneficiaryRegID, t.benCallID, t.feedbackAgainst, t.designation, t.institutionName, t.stateName, "
			+ "t.districtName, t.blockName, t.districtBranchName, t.instituteTypeName, t.severityName, t.feedbackTypeName, t.feedbackNatureName, t.feedbackStatusName, t.feedback, t.userID, t.smsPhoneNo, t.serviceAvailDate, t.createdDate, b.beneficiaryID, b.firstName, b.lastName, b.healthCareWorker, b.gender, b.dob, b.permVillage, b.permSubDistrict, b.permDistrict, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+ "from FeedbackReport t "
			+ "LEFT JOIN t.beneficiaryReport b " + " LEFT JOIN t.bencallReport c "
			+ "left join c.userReportObj user "	
			+ "where t.providerServiceMapID=:providerServiceMapID "+ "and t.feedbackTypeID=:feedbackTypeID "
			+ "and t.createdDate > :startDateTime " + "and t.createdDate < :endDateTime " + "order by t.createdDate desc")
	public List<Objects[]> getFeedbackReportByTypeAndDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime, @Param("feedbackTypeID") Short feedbackTypeID);
	
	@Query("select t.feedbackID, t.requestID, t.beneficiaryRegID, t.benCallID, t.feedbackAgainst, t.designation, t.institutionName, t.stateName, "
			+ "t.districtName, t.blockName, t.districtBranchName, t.instituteTypeName, t.severityName, t.feedbackTypeName, t.feedbackNatureName, t.feedbackStatusName, t.feedback, t.userID, t.smsPhoneNo, t.serviceAvailDate, t.createdDate, b.beneficiaryID, b.firstName, b.lastName, b.healthCareWorker, b.gender, b.dob, b.permVillage, b.permSubDistrict, b.permDistrict, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+ "from FeedbackReport t "
			+ "LEFT JOIN t.beneficiaryReport b " + " LEFT JOIN t.bencallReport c "
			+ "left join c.userReportObj user "	
			+ "where t.providerServiceMapID=:providerServiceMapID "+ "and c.agentID =:agentID " + "and t.feedbackTypeID=:feedbackTypeID "
			+ "and t.createdDate > :startDateTime " + "and t.createdDate < :endDateTime " + "order by t.createdDate desc")
	public List<Objects[]> getFeedbackReportByAgendIDTypeAndDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("agentID") String agentID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime, @Param("feedbackTypeID") Short feedbackTypeID);

}
