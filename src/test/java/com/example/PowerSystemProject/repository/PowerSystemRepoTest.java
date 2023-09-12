package com.example.PowerSystemProject.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.PowerSystemProject.dao.PowerSystemDao;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;

@SpringBootTest
class PowerSystemRepoTest {

	@Autowired
	private PowerSystemRepo powerSystemRepo;
	
	@Autowired
	PowerSystemDao powerSystemDao;
	
	@Test
	void savebatteryInfo() {
		List<BatteryInfoDTO> list=new ArrayList<BatteryInfoDTO>();

		BatteryInfoDTO battery=new BatteryInfoDTO();
	
		battery.setId(1);
		battery.setName("Lithium Ion Battery");
		battery.setCapacity(5000);
		battery.setPostcode(6733);
	
	System.out.println(battery);
	list.add(battery);
	
	BatteryInfoDTO battery1=new BatteryInfoDTO();
	battery1.setId(2);
	battery1.setName("Lead Acid Battery");
	battery1.setCapacity(7500);
	battery1.setPostcode(2084);
	System.out.println(battery1);
	list.add(battery1);

	powerSystemDao.savebatteryInfo(list);
	
	   org.assertj.core.api.Assertions.assertThat(battery.getId()).isGreaterThan(0);
    }

	  
		
	@Test
	public void getListOfBatteryRange() {
		
		   double postcodemin = 5000;
		   double postcodemax = 10000;
		   
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
	   	
	   	System.out.println(list);

	   	
	   	powerSystemDao.savebatteryInfo(list);
	   	
	   	
	 // powerSystemRepo.save(battery);
	// powerSystemRepo.save(battery1);
	   	
	   	  
	  List<BatteryInfoDTO> listBatteryInfo=powerSystemDao.findBatteryRange(postcodemin,postcodemax);
	   	  
	      
       org.assertj.core.api.Assertions.assertThat(listBatteryInfo.size()).isGreaterThan(0);
		//assertNotNull(listBatteryInfo.size()>count);
	}
	

}