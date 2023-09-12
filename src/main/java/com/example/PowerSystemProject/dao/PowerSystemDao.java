package com.example.PowerSystemProject.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;
import com.example.PowerSystemProject.model.BatteryInfo;

@Repository
public interface PowerSystemDao{
	
	public void savebatteryInfo(List<BatteryInfoDTO> batteryInfo);
	
	public List<BatteryInfoDTO> findBatteryRange(double postcodemin,double postcodemax);
	
	
	public List<BatteryInfoDTO> findAll();
	
    
}




//@Query(value = "SELECT * FROM battery_info WHERE postcode BETWEEN ?1 AND ?2",nativeQuery = true)
// @Query(value = "SELECT * FROM battery_info WHERE postcode>:postcodemin AND postcode<=:postcodemax",nativeQuery = true)
// public List<BatteryInfo> getBatteryRange(double postcodemin,double postcodemax);
   