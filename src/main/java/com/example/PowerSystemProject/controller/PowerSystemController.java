package com.example.PowerSystemProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.PowerSystemProject.ExceptionHandling.ControllerException;
import com.example.PowerSystemProject.ExceptionHandling.CustomException;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;
import com.example.PowerSystemProject.service.PowerSystemService;
import com.example.PowerSystemProject.util.PowerSystemUtil;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class PowerSystemController {
	
	@Autowired
	PowerSystemService powerSystemService;
	
//	@Autowired
//	PowerSystemRepo powerSystemRepo;
	
	@Autowired
	PowerSystemUtil powerSystemUtil;
	
     @RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> savebatteryInfo(@RequestBody List<BatteryInfoDTO> batteries){		
    	 
    	 try {
	         powerSystemService.savebatteryInfo(batteries);
	         return new ResponseEntity<>(batteries,HttpStatus.CREATED);
	 
    				} catch(CustomException e) {
			// TODO: handle exception
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
		    return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}catch(Exception e) {	
			ControllerException ce=new ControllerException(611,"Something went wrong in controller !!");
		    return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	

	@RequestMapping(value ="/range/{postcodemin}/{postcodemax}", method = RequestMethod.GET)
	public ResponseEntity<?> batteryRange(@PathVariable double postcodemin,@PathVariable double postcodemax){	
		try {
			   List<BatteryInfoDTO> listBattery=powerSystemService.findBatteryRange(postcodemin,postcodemax);	 
			   //sorting list        
			    List<BatteryInfoDTO> sortedBatteryList=powerSystemUtil.returnSortedBatteryInfo(listBattery);
			    
			    System.out.println(sortedBatteryList);			    
			    System.out.println("Sorted List "+sortedBatteryList);
			    
		       //total watt capaacity and average watt capacity 
		       double totalWatt=powerSystemUtil.totalWattCapacity(sortedBatteryList);  
		       double avgWatt=powerSystemUtil.averageWattCapacity(totalWatt,sortedBatteryList.size());
		   	return new ResponseEntity<>(sortedBatteryList+"Total Watt : "+totalWatt+"Average Watt :"+avgWatt,HttpStatus.OK);	

		       
		} catch(CustomException e) {
			// TODO: handle exception
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
		    return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}catch(Exception e) {			
			ControllerException ce=new ControllerException(611,"Something went wrong in controller !!");
		    return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		    
		}
    	  		
		
	}
}
