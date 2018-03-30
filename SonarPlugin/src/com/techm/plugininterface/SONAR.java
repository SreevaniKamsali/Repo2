package com.techm.plugininterface;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.techm.ssap_interface.Plugin_interface;
import com.techm.util.PropertiesUtil;

public class SONAR implements Plugin_interface{


	public Properties prop = new Properties();
	@Override
	public Response initiate(SSAPropertyBean SSAPropertyBean, Properties toolProperty) {
		Response response=new Response();
		
			SONARService sonarService = new SONARServiceImpl();
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