package com.example.PowerSystemProject.util;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;


@Component
public class PowerSystemUtil {
	
	
	
	public double totalWattCapacity(List<BatteryInfoDTO> sortedBattery) {
			
		  double totalCapacity=0;
		     
		     for(BatteryInfoDTO b:sortedBattery) {
		    	 
		     if(b.getCapacity()!=0) {
		    		 
		    	 totalCapacity=totalCapacity+b.getCapacity();		 
		    	 }	    	  
		     }
	    // averageWattCapacity(sum,sortedBattery.size());     
        	return totalCapacity;	     
	}
	
	
public double averageWattCapacity(double totalCapacity,int size) {
		
	return totalCapacity/size;
		
	}
	

public List<BatteryInfoDTO> returnSortedBatteryInfo(List<BatteryInfoDTO> listBattery){
	
	return listBattery.stream().sorted((b1,b2)->b1.getName().compareTo(b2.getName())).collect(Collectors.toList());  

}
	
	

}
