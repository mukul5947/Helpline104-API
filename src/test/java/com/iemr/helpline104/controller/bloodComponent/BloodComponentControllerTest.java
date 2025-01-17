package com.iemr.helpline104.controller.bloodComponent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.helpline104.data.bloodComponent.M_Component;
import com.iemr.helpline104.service.bloodComponent.BloodComponentServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class BloodComponentControllerTest {
	
	@InjectMocks
	BloodComponentController bloodComponentController;
	
	@Mock
	BloodComponentServiceImpl bloodComponentServiceImpl;
	

	
	@Test
	public void saveBloodComponentDetailsTest()
	{
		M_Component m_component=new M_Component();
		m_component.setComponent("component");
		//Mockito.when(bloodComponentServiceImpl.save(Mockito.anyObject())).thenReturn(m_component);
		doReturn(m_component).when(bloodComponentServiceImpl).save(Mockito.any());
		//Mockito.when(m_component1.toString()).thenReturn("hello");
		String response=bloodComponentController.saveBloodComponentDetails(m_component.toString()); 
		assertTrue(response.contains("\"component\":\"component\""));
		
	}
	@Test
	public void saveBloodComponentDetailsExceptionTest()
	{
		M_Component m_component=new M_Component();
		m_component.setComponent("component");
		//Mockito.when(bloodComponentServiceImpl.save(Mockito.anyObject())).thenReturn(m_component);
		doThrow(Exception.class).when(bloodComponentServiceImpl).save(Mockito.any());
		//Mockito.when(m_component1.toString()).thenReturn("hello");
		String response=bloodComponentController.saveBloodComponentDetails(m_component.toString()); 
		assertFalse(response.contains("\"component\":\"component\""));
		
	}
	@Test
	public void getBloodComponentDetailsTest()
	{
		M_Component m_component=new M_Component();
		m_component.setComponent("component");
		List<M_Component> bloodComponent =Lists.newArrayList();
		bloodComponent.add(m_component);
		try {
			doReturn(bloodComponent).when(bloodComponentServiceImpl).getBloodComponents(Mockito.anyInt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=bloodComponentController.getBloodComponentDetails(m_component.toString());
		assertTrue(response.contains("\"component\":\"component\""));
		
	}
	
	@Test
	public void getBloodComponentDetailsExceptionTest()
	{
		M_Component m_component=new M_Component();
		m_component.setComponent("component");
		List<M_Component> bloodComponent =Lists.newArrayList();
		bloodComponent.add(m_component);
		try {
			doThrow(Exception.class).when(bloodComponentServiceImpl).getBloodComponents(Mockito.anyInt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=bloodComponentController.getBloodComponentDetails(m_component.toString());
		assertFalse(response.contains("\"component\":\"component\""));
		
	}
}
