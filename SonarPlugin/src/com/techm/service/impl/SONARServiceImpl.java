package com.techm.service.impl;

import java.io.IOException;

import javax.naming.AuthenticationException;

import com.sun.jersey.api.client.ClientResponse;
import com.techm.service.SONARService;
import com.techm.util.PropertiesUtil;
import com.techm.util.RestAPIUtil;

public class SONARServiceImpl implements SONARService{
	
	private PropertiesUtil pUtil = new PropertiesUtil();
	private String projectkey;
	private RestAPIUtil restAPIUtil=new RestAPIUtil();
	public String sonar_project_creation(String project_key, String pro_name,
			 String qualifier) throws IOException{
		String data = "{\"key\":\""+project_key.toUpperCase()+"\",\"name\":\""+pro_name.toUpperCase()+"\",\"projectqualifier\":\"TRK\"}";

		
	 	ClientResponse response = restAPIUtil.postDataToRestAPI(pUtil.getCreateProjectUrl(), data);
	 	System.out.println(response.toString());
	 	if(response!=null){
	 		 int statusCode = response.getStatus();
	 		System.out.println(response.getLocation());
	 		System.out.println(response.getProperties());
	 		String location = response.getLocation().toString();
	 		projectkey = location.substring(location.indexOf("project/")+8, location.length());
             System.out.println("statusCode=="+statusCode);
             if (statusCode == 401) {
                 try {
					throw new AuthenticationException("Invalid Username or Password");
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
             if(statusCode == 201){
                 //createFile(number,Constant.JIRAFILENAME);
          /*       
                 System.out.println("project created");
                 System.out.println(response);
                 */
     }
	 	}
	/* 	System.out.println("project id : "+projectId);
		System.out.println(projectId);*/
		return projectkey;
	}
	
	
	
}
