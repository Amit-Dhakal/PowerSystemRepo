package com.example.PowerSystemProject.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;
import com.example.PowerSystemProject.model.BatteryInfo;

@Repository
public class PowerSystemDaoImpl implements PowerSystemDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
    private BatteryInfo batteryInfo = new BatteryInfo();
    

	@Override
	@Transactional
	public void savebatteryInfo(List<BatteryInfoDTO> batteries) {
		// TODO Auto-generated method stub				

		  for (BatteryInfoDTO batteryInfoDto: batteries) {	  
			      
		        batteryInfo.setId(batteryInfoDto.getId());
		        batteryInfo.setName(batteryInfoDto.getName());
		        batteryInfo.setPostcode(batteryInfoDto.getPostcode());
		        batteryInfo.setCapacity(batteryInfoDto.getCapacity());
		        		        
			  if (batteryInfo.getId() != 0) {
		             entityManager.merge(batteryInfo);
		        }
			  
			  else {
		          entityManager.persist(batteryInfo);

			  }
			          	          
	        }		 
		  System.out.println("Saved");
	}
	

	@Override
	@Transactional
	public List<BatteryInfoDTO> findBatteryRange(double postcodemin, double postcodemax) {
		// TODO Auto-generated method stub
	List<BatteryInfoDTO> listBatteryInfoDTO=new ArrayList<BatteryInfoDTO>();

	
	Query query = entityManager.createQuery("SELECT b FROM BatteryInfo b WHERE b.postcode>:min AND b.postcode<:max",BatteryInfo.class)
			 .setParameter("min",postcodemin)
			 .setParameter("max",postcodemax);	 	
    List<BatteryInfo> batteryInfoList = query.getResultList();
    
   
    for(BatteryInfo binfo:batteryInfoList) {
    	
    	BatteryInfoDTO batteryInfoDTO=new BatteryInfoDTO();

    	batteryInfoDTO.setId(binfo.getId());
    	batteryInfoDTO.setName(binfo.getName());
    	batteryInfoDTO.setPostcode(binfo.getPostcode());
    	batteryInfoDTO.setCapacity(binfo.getCapacity());
    	listBatteryInfoDTO.add(batteryInfoDTO);
    }
	return listBatteryInfoDTO;
    		        		
}


	
	
	@Override
	public List<BatteryInfoDTO> findAll() {
		// TODO Auto-generated method stub
		
		List<BatteryInfoDTO> listBatteryInfoallDTO=new ArrayList<BatteryInfoDTO>();

		
		Query query = entityManager.createQuery("SELECT b FROM BatteryInfo b",BatteryInfo.class);
	    List<BatteryInfo> batteryInfoallList = query.getResultList();
	    
	   
	    for(BatteryInfo binfo:batteryInfoallList) {
	    	
	    	BatteryInfoDTO batteryInfoDTO=new BatteryInfoDTO();

	    	batteryInfoDTO.setId(binfo.getId());
	    	batteryInfoDTO.setName(binfo.getName());
	    	batteryInfoDTO.setPostcode(binfo.getPostcode());
	    	batteryInfoDTO.setCapacity(binfo.getCapacity());
	    	listBatteryInfoallDTO.add(batteryInfoDTO);
	    }
		return listBatteryInfoallDTO;
	}
	
	
	
	
}
