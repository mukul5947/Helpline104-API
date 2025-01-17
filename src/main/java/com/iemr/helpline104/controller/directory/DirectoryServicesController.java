package com.iemr.helpline104.controller.directory;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.data.directory.Directoryservice;
import com.iemr.helpline104.service.directory.DirectoryServiceImpl;
import com.iemr.helpline104.utils.mapper.InputMapper;
import com.iemr.helpline104.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/beneficiary")
@RestController
public class DirectoryServicesController {
	InputMapper inputMapper = new InputMapper();
	private Logger logger = LoggerFactory.getLogger(DirectoryServicesController.class);

	@Autowired
	private DirectoryServiceImpl directoryServiceImpl;

	@CrossOrigin
	@ApiOperation(value = "retrives directory search history", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/getdirectorySearchHistory", method = RequestMethod.POST, headers = "Authorization")
	public String getBenDirectoryHistory(
			@ApiParam(value = "{\"beneficiaryRegID\":\"optional long\",  \"benCallID\":\" Optional long\"}") @RequestBody String request) {
		OutputResponse output = new OutputResponse();
		try {

			Directoryservice directoryService = inputMapper.gson().fromJson(request, Directoryservice.class);
			logger.info("getdirectorySearchHistory request " + directoryService.toString());

			List<Directoryservice> searchHistory = directoryServiceImpl
					.getDirectorySearchHistory(directoryService.getBeneficiaryRegID(),directoryService.getBenCallID());
			output.setResponse(searchHistory.toString());
			logger.info("getdirectorySearchHistory response: " + output);
		} catch (Exception e) {
			logger.error("getdirectorySearchHistory failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		return output.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "stores directory serach history", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/save/directorySearchHistory", method = RequestMethod.POST, headers = "Authorization")
	public String directorySearchHistory(
			@ApiParam(value = "[{\"beneficiaryRegID\":\"long\",\"benCallID\":\"long\",\"institutionID\":\"integer\",\"instituteDirectoryID\":\"integer\",\"instituteSubDirectoryID\":\"integer\","
					+ "\"providerServiceMapID\":\"integer\",\"remarks\":\"string\",\"createdBy\":\"string\"}]") @RequestBody String request) {
		OutputResponse output = new OutputResponse();
		try {
			Directoryservice[] directoryHistory = inputMapper.gson().fromJson(request, Directoryservice[].class);
			logger.info("save/directorySearchHistory request " + Arrays.toString(directoryHistory));

			String searchhistory = directoryServiceImpl.saveDirectorySearchHistory(directoryHistory);

			output.setResponse(searchhistory);
			logger.info("directorySearchHistory response: " + output);
		} catch (Exception e) {
			logger.error("save/directorySearchHistory failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		return output.toString();
	}
}
