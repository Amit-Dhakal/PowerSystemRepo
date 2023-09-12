package com.example.PowerSystemProject.repository;

import java.util.List;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;



//@Repository
public interface PowerSystemRepo{
	
public void savebatteryInfo(List<BatteryInfoDTO> battery);
public List<BatteryInfoDTO> findBatteryRange(double postcodemin,double postcodemax);

public List<BatteryInfoDTO> findAll();

} 
