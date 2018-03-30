package com.techm.analysis;

import java.util.Properties;
import com.techm.bean.Response;
import com.techm.bean.SSAPropertyBean;
import com.techm.service.SONARService;
import com.techm.service.impl.SONARServiceImpl;
import com.techm.ssap_interface.Plugin_interface;

public class SONAR implements Plugin_interface{
	
	public Properties prop = new Properties();
	
	@Override
	public Response initiate(SSAPropertyBean SSAPropertyBean, Properties toolProperty) {
		Response response=new Response();
		SONARService sonarService=new SONARServiceImpl();
		response=sonarService.sonar_project_creation( SSAPropertyBean,  toolProperty);
		return response;
	}
	public boolean isProceed(Response response){
		if(response.getStatusCode()==200)
			return true;
		else
			return false;
	}
		
				
			}
		
	
	





