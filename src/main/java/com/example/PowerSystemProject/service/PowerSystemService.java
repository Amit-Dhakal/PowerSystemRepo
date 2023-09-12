package com.example.PowerSystemProject.service;

import java.util.List;

import com.example.PowerSystemProject.dto.BatteryInfoDTO;
import com.example.PowerSystemProject.model.BatteryInfo;



public interface PowerSystemService {
	
	public void savebatteryInfo(List<BatteryInfoDTO> battery);
	
   	public List<BatteryInfoDTO> findBatteryRange(double postcodemin,double postcodemax);
   	public List<BatteryInfoDTO> findAll();

	
}
