package com.example.PowerSystemProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PowerSystemProject.ExceptionHandling.CustomException;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;
import com.example.PowerSystemProject.model.BatteryInfo;
import com.example.PowerSystemProject.repository.PowerSystemRepository;

@Service
public class PowerSystemServiceImpl implements PowerSystemService {

	@Autowired
	PowerSystemRepository powerSystemRepo;
	
	@Override
	public void savebatteryInfo(List<BatteryInfoDTO> batteries) {
				
try {
	if( batteries.isEmpty() || batteries.size()==0) {		
		throw new CustomException(601,"List value cannot be null !!");
	}

} catch(IllegalArgumentException e) {
	// TODO: handle exception
	throw new CustomException(602,"Input list value is null "+e.getMessage());
	
}catch (Exception e) {
	// TODO: handle exception
throw new CustomException(603,"something went wrong in service layer please check "+e.getMessage());

}

powerSystemRepo.savebatteryInfo(batteries);

}
	
	
	@Override
	public List<BatteryInfoDTO> findBatteryRange(double postcodemin,double postcodemax) {
		
		try {	
			if(postcodemin>postcodemax) {	
				throw new CustomException(601,"postcode minimum values should be less than postcode maximum value");
			}
		} catch (IllegalArgumentException iex) {
			throw new CustomException(602,"postcode minimum values and postcode maximum value should not be empty "+iex.getMessage());
	
		}catch (Exception e) {
			// TODO: handle exception	
			throw new CustomException(603,"Someting went wrong on service layer  "+e.getMessage());
		}
		
		List<BatteryInfoDTO> listBattery=powerSystemRepo.findBatteryRange(postcodemin,postcodemax);
     	return listBattery;
		
	}


	@Override
	public List<BatteryInfoDTO> findAll() {
		// TODO Auto-generated method stub
		List<BatteryInfoDTO> listAllBattery=powerSystemRepo.findAll();
		return listAllBattery;	}
		 
	

}
