package com.iemr.helpline104.repository.report;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.report.EpidemicoutbreakReport;

@Repository
@RestResource(exported = false)
public interface EpidemicoutbreakReportRepository extends CrudRepository<EpidemicoutbreakReport, Long>
{

	@Query("select t.outbreakComplaintID, t.requestID, t.beneficiaryRegID, t.benCallID, t.natureOfComplaint, t.totalPeopleAffected, t.affectedDistrictName, t.affectedDistrictBlockName, "
			+ "t.affectedDistrictBranchName, t.remarks, t.createdDate, b.beneficiaryID, b.firstName, b.lastName, b.healthCareWorker, b.gender, b.dob, b.permVillage, b.permSubDistrict, b.permDistrict, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+ "from EpidemicoutbreakReport t "
			+ "LEFT JOIN t.beneficiaryReport b " + " LEFT JOIN t.bencallReport c "
			+ "left join c.userReportObj user "			
			+ "where t.providerServiceMapID=:providerServiceMapID "
			+ "and t.createdDate > :startDateTime "
			+ "and t.createdDate < :endDateTime "
			+ "order by t.outbreakComplaintID desc")
	public List<Objects[]> getEpidemicoutbreakReportByDate(@Param("providerServiceMapID") Integer providerServiceMapID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime);

}
