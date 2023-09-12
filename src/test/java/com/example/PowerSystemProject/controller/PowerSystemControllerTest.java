package com.example.PowerSystemProject.controller;

import static org.mockito.Mockito.doNothing;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.PowerSystemProject.dao.PowerSystemDao;
import com.example.PowerSystemProject.dto.BatteryInfoDTO;
import com.example.PowerSystemProject.service.PowerSystemService;
import com.example.PowerSystemProject.util.PowerSystemUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class PowerSystemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
    private PowerSystemController powerSystemController;
	
	@MockBean
	private PowerSystemService powerSystemService;
	
	@Autowired
	private PowerSystemDao powerSystemDao;
	
	
	@Autowired
	PowerSystemUtil powerSystemUtil;
	
	ObjectMapper mapper=new ObjectMapper();
	
	 @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(powerSystemController).build();
	        mapper = new ObjectMapper();
	    }
	
	@Test
	void testsavebatteryInfo() throws Exception {
  	    String URI="/api/v1/save"; 
        List<BatteryInfoDTO> mockBatteryList = new ArrayList<>();

        BatteryInfoDTO batteryInfo1=new BatteryInfoDTO();
        batteryInfo1.setId(1);
        batteryInfo1.setName("Lithium Ion Battery");
        batteryInfo1.setCapacity(5000);
		batteryInfo1.setPostcode(6733);	
        mockBatteryList.add(batteryInfo1);   
 
        BatteryInfoDTO batteryInfo2=new BatteryInfoDTO();
        batteryInfo2.setId(2);
        batteryInfo2.setName("Lead Acid Battery");
        batteryInfo2.setCapacity(7500);
        batteryInfo2.setPostcode(2084);
		mockBatteryList.add(batteryInfo2);			
	
        
	   String inputjson=mapper.writeValueAsString(mockBatteryList);
  	    
	    doNothing().when(powerSystemService).savebatteryInfo(mockBatteryList);
	 	
	    org.springframework.test.web.servlet.RequestBuilder rb=MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(inputjson).contentType(MediaType.APPLICATION_JSON);
	    
	    MvcResult result=mockMvc.perform(rb).andReturn();
	    
	    MockHttpServletResponse response=result.getResponse();
	    
	  String outputInJson=response.getContentAsString();

	org.assertj.core.api.Assertions.assertThat(outputInJson).isEqualTo(inputjson);
	
//	assertEquals(org.springframework.http.HttpStatus.OK.value(),response.getStatus());       

    }
	
	
	@Test
	public void testfindListOfBatteryRange() throws Exception {

		 double postcodemin = 5000;
	     double postcodemax = 10000;
	     
	     double totalwattcapacity = 0;
	     double averagewattCapacity=0;
	     
		   List<BatteryInfoDTO> mockBatteryList = new ArrayList<>();
	  	    String URI="/api/v1/range/postcodemin/postcodemax"; 

	  	  BatteryInfoDTO batteryInfo1=new BatteryInfoDTO();
	  	batteryInfo1.setId(1);
			batteryInfo1.setName("Gold Coast Mc");
			batteryInfo1.setPostcode(9729);
			batteryInfo1.setCapacity(50000);	
	 
			BatteryInfoDTO batteryInfo2=new BatteryInfoDTO();
		  	batteryInfo2.setId(2);
			batteryInfo2.setName("Akunda Bay");
			batteryInfo2.setCapacity(13500);
			batteryInfo2.setPostcode(6084);
			
	        mockBatteryList.add(batteryInfo1);   
			mockBatteryList.add(batteryInfo2);	
			
			String expectedJSON=mapper.writeValueAsString(mockBatteryList);

			System.out.println(expectedJSON);
			
		  //  doNothing().when(powerSystemDao).savebatteryInfo(mockBatteryList);
		   
			powerSystemDao.savebatteryInfo(mockBatteryList);
			
			List<BatteryInfoDTO> listBatteryRange=powerSystemDao.findBatteryRange(postcodemin,postcodemax);	
			
			System.out.println("List Range"+listBatteryRange);
			
		    List<BatteryInfoDTO> sortedBattery=powerSystemUtil.returnSortedBatteryInfo(listBatteryRange);
			  
		    System.out.println("Sorted Batery"+sortedBattery);

      
      
	 org.springframework.test.web.servlet.RequestBuilder requestbuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
	 

     totalwattcapacity=powerSystemUtil.totalWattCapacity(sortedBattery);
    averagewattCapacity=powerSystemUtil.averageWattCapacity(totalwattcapacity,sortedBattery.size());
  
	MvcResult result=mockMvc.perform(requestbuilder).andReturn();
	
    String outputInjson=result.getResponse().getContentAsString();
         
	org.assertj.core.api.Assertions.assertThat(outputInjson).isLessThanOrEqualTo(expectedJSON);
	
	
   
	}
	
	
	}

