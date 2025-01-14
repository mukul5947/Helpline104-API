package com.iemr.helpline104.controller.callqamapping;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.callqamapping.CallqaMappings;
import com.iemr.helpline104.data.callqamapping.M_104callqamapping;
import com.iemr.helpline104.service.callqamapping.CallqamappingServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CallqamappingControllerTest {

	
	@InjectMocks
	CallqamappingController callqamappingController;
	
	@Mock
	CallqamappingServiceImpl callqamappingServiceImpl;
	
	@Test
	public void saveCallqamappingTest()
	{
		CallqaMappings  callqaMappings=new CallqaMappings();
		
		M_104callqamapping m_104callqamapping=new M_104callqamapping();
		m_104callqamapping.setBeneficiaryRegID(new Long("101"));
		
		List<M_104callqamapping> mapList=Lists.newArrayList();
		mapList.add(m_104callqamapping);
		
		callqaMappings.setM_104callqamapping(mapList);
		
		try {
			doReturn(mapList).when(callqamappingServiceImpl).save(Mockito.anyObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=callqamappingController.saveCallqamapping(callqaMappings.toString());
		assertTrue(response.contains("\"beneficiaryRegID\":101"));	
		
	}
	
	@Test
	public void saveCallqamappingExceptionTest()
	{
		CallqaMappings  callqaMappings=new CallqaMappings();
		
		try {
			doThrow(Exception.class).when(callqamappingServiceImpl).save(Mockito.anyObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=callqamappingController.saveCallqamapping(callqaMappings.toString());
		assertFalse(response.contains("\"beneficiaryRegID\":101"));	}

	@Test
	public void getCDIqamappingTest()
	{
		M_104callqamapping m_104callqamapping=new M_104callqamapping();
		m_104callqamapping.setBeneficiaryRegID(new Long("101"));

		List<M_104callqamapping> list=Lists.newArrayList();
		list.add(m_104callqamapping);
		
		try {
			doReturn(list).when(callqamappingServiceImpl).getCDIQuestionScores(Mockito.anyObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=callqamappingController.getCDIqamapping(m_104callqamapping.toString());
		assertTrue(response.contains("\"beneficiaryRegID\":101"));	
		
	}
	@Test
	public void getCDIqamappingExceptionTest()
	{
		M_104callqamapping m_104callqamapping=new M_104callqamapping();
		m_104callqamapping.setBeneficiaryRegID(new Long("101"));
		try {
			doThrow(Exception.class).when(callqamappingServiceImpl).getCDIQuestionScores(Mockito.anyObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=callqamappingController.getCDIqamapping(m_104callqamapping.toString());
		assertFalse(response.contains("\"beneficiaryRegID\":101"));	
		
	}

	}


	
