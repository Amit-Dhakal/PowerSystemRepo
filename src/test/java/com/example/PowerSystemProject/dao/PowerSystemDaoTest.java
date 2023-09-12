package com.example.PowerSystemProject.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.PowerSystemProject.dto.BatteryInfoDTO;

@SpringBootTest
class PowerSystemDaoTest {

	
	@Autowired
	PowerSystemDao powerSystemDao;
	
	@Test
	void testsavebatteryInfo() {
		
     BatteryInfoDTO battery=new BatteryInfoDTO();	
		
		List<BatteryInfoDTO> listBatteryInfo=new ArrayList<BatteryInfoDTO>();
		
	    battery.setId(1);
		battery.setName("Lithium Ion Battery");
		battery.setCapacity(5000);
		battery.setPostcode(6733);
		listBatteryInfo.add(battery);
		
		BatteryInfoDTO battery1=new BatteryInfoDTO();
		battery1.setId(2);
		battery1.setName("Lead Acid Battery");
		battery1.setCapacity(7500);
		battery1.setPostcode(2084);
		listBatteryInfo.add(battery1);			
		
		powerSystemDao.savebatteryInfo(listBatteryInfo);
		
		
		listBatteryInfo=powerSystemDao.findAll();
		System.out.println(listBatteryInfo);
		
		org.assertj.core.api.Assertions.assertThat(battery.getId()).isEqualTo(listBatteryInfo.get(0).getId());
	
	}

	
	@Test
	public void testfindListOfBatteryRange() {

		  double postcodemin = 1000;
	      double postcodemax = 3000;
	     
		List<BatteryInfoDTO> listBatteryInfo=new ArrayList<BatteryInfoDTO>();
		
		BatteryInfoDTO battery=new BatteryInfoDTO();
		battery.setId(1);
		battery.setName("Lithium Ion Battery");
		battery.setCapacity(5000);
		battery.setPostcode(6733);
		listBatteryInfo.add(battery);

		   	
		   	BatteryInfoDTO battery1=new BatteryInfoDTO();
		   	
			battery1.setId(2);
			battery1.setName("Lead Acid Battery");
			battery1.setCapacity(7500);
			battery1.setPostcode(2084);
		   	   	
			listBatteryInfo.add(battery1);
		 //	doNothing().when(powerSystemDao).savebatteryInfo(list);
		   	powerSystemDao.savebatteryInfo(listBatteryInfo);	
		   	
		    List<BatteryInfoDTO> listBatteryInfoRange=powerSystemDao.findBatteryRange(postcodemin,postcodemax);	   
	 	        
		    org.assertj.core.api.Assertions.assertThat(listBatteryInfoRange.size()).isGreaterThan(0);
		
		
	
	}
	
	
}
