package com.iemr.helpline104.service.directory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.directory.Directory;
import com.iemr.helpline104.data.directory.Directoryservice;
import com.iemr.helpline104.repository.beneficiarycall.BenCallRepository;
import com.iemr.helpline104.repository.directory.DirectoryRepository;
import com.iemr.helpline104.repository.directory.DirectoryserviceRepository;

@Service
public class DirectoryServiceImpl implements DirectoryServiceService
{
	private DirectoryRepository directoryRepository;

	@Autowired
	public void setDirectoryRepository(DirectoryRepository directoryRepository)
	{
		this.directoryRepository = directoryRepository;
	}

	@Autowired
	private DirectoryserviceRepository directoryserviceRepository;
	
	@Autowired
	private BenCallRepository benCallRepository;

	@Override
	public List<Directoryservice> getDirectorySearchHistory(Long benificiaryRegID, Long benCallID)
	{

		List<Directoryservice> directoryServiceList = new ArrayList<Directoryservice>();

		List<Objects[]> directoryServices = null;

		if (benificiaryRegID != null)
			directoryServices = directoryserviceRepository.getBenSearchHistory(benificiaryRegID);
		else if (benCallID != null)
			directoryServices = directoryserviceRepository.getBenSearchHistoryByBenCallID(benCallID);

		Directoryservice dService;
		
		for (Object[] objects : directoryServices)
		{
			if (objects != null && objects.length > 0)
			{
				/*
				 * directoryServiceList.add(new Directoryservice((Long) objects[0], (String) objects[1], (String)
				 * objects[2], (String) objects[3],(Integer) objects[4],(String) objects[5],(Integer)
				 * objects[6],(String) objects[7],(Integer) objects[8],(String) objects[9]));
				 */	
				
				dService = new Directoryservice((Long) objects[0], (String) objects[1], (String) objects[2], (String) objects[3], (String) objects[4]);
				
				if (benCallID != null)
					dService.setBenCall(benCallRepository.findByBenCallID(benCallID));
				
				directoryServiceList.add(dService);
			}
		}

		return directoryServiceList;
	}

	@Override
	public String saveDirectorySearchHistory(Directoryservice[] directoryservice)
	{
		Iterable<Directoryservice> savedDirectoryserviceResponse = directoryserviceRepository.save(Arrays.asList(directoryservice));
		return savedDirectoryserviceResponse.toString();
	}

	@Override
	public List<Directory> getDirectories()
	{
		ArrayList<Directory> directories = new ArrayList<Directory>();
		Set<Objects[]> directoryResult = directoryRepository.findAciveDirectories();
		for (Object[] objects : directoryResult)
		{
			if (objects != null && objects.length == 2)
			{
				directories.add(new Directory((Integer) objects[0], (String) objects[1]));
			}
		}
		return directories;
	}

}
