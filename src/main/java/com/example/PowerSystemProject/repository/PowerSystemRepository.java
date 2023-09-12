package com.example.PowerSystemProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.PowerSystemProject.dao.PowerSystemDao;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;

@Repository
public class PowerSystemRepository implements PowerSystemRepo{

@Autowired
PowerSystemDao powerSystemDao;
	
	
public void savebatteryInfo(List<BatteryInfoDTO> batteries) {
			
	//	powerSystemRepo.saveAll(batteries);			
	powerSystemDao.savebatteryInfo(batteries);
	    
}


public List<BatteryInfoDTO> findBatteryRange(double postcodemin,double postcodemax) {
	
	List<BatteryInfoDTO> listBattery=powerSystemDao.findBatteryRange(postcodemin,postcodemax);
	return listBattery;
}


@Override
public List<BatteryInfoDTO> findAll() {
	// TODO Auto-generated method stub
	
	List<BatteryInfoDTO> listAllBattery=powerSystemDao.findAll();

	return listAllBattery;
}
	 
	
	
	
}
