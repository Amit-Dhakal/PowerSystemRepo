package com.example.PowerSystemProject.service;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.PowerSystemProject.dao.PowerSystemDao;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;

@SpringBootTest
class PowerSystemServiceTest {

	@Autowired
	private PowerSystemService powerSystemService;
	
	@Autowired
	PowerSystemDao powerSystemDao;
	
	 private double postcodemin = 5000;
     private double postcodemax = 10000;
     
	@Test
	public void testsavebatteryInfo() {
				
		BatteryInfoDTO battery=new BatteryInfoDTO();	
		
		List<BatteryInfoDTO> list=new ArrayList<BatteryInfoDTO>();
	battery.setId(1);
		battery.setName("Lithium Ion Battery");
		battery.setCapacity(5000);
		battery.setPostcode(6733);
		list.add(battery);
		
		BatteryInfoDTO battery1=new BatteryInfoDTO();
		battery1.setId(2);
		battery1.setName("Lead Acid Battery");
		battery1.setCapacity(7500);
		battery1.setPostcode(2084);
		list.add(battery1);			
		
		powerSystemDao.savebatteryInfo(list);	

		
	    List<BatteryInfoDTO> binfoDTO = powerSystemDao.findAll();
	org.assertj.core.api.Assertions.assertThat(battery.getId()).isEqualTo(binfoDTO.get(0).getId());
		 //   Assert.assertEquals(employee.getId(), employees.get(0).getId());

	//	doNothing().when(powerSystemService).savebatteryInfo(list);
	// doNothing().when(powerSystemService).savebatteryInfo(list);
      //verify(powerSystemDao).savebatteryInfo(list);
        
		
	}
  
	
	
	@Test
	public void testfindListOfBatteryRange() {
			   
	List<BatteryInfoDTO> list=new ArrayList<BatteryInfoDTO>();
	
	BatteryInfoDTO battery=new BatteryInfoDTO();
	battery.setId(1);
	battery.setName("Lithium Ion Battery");
	battery.setCapacity(5000);
	battery.setPostcode(6733);
	  list.add(battery);

	   	
	   	BatteryInfoDTO battery1=new BatteryInfoDTO();
	   	
		battery1.setId(2);
		battery1.setName("Lead Acid Battery");
		battery1.setCapacity(7500);
		battery1.setPostcode(2084);
	   	
	   	   	
	   	list.add(battery1);
	 //	doNothing().when(powerSystemDao).savebatteryInfo(list);
	   	powerSystemDao.savebatteryInfo(list);		
	    List<BatteryInfoDTO> listBatteryInfo=powerSystemDao.findBatteryRange(postcodemin,postcodemax);	   
 	        
	    org.assertj.core.api.Assertions.assertThat(listBatteryInfo.size()).isGreaterThan(0);

	}
	
	
}
