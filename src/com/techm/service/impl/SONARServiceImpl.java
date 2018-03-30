package com.techm.service.impl;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.sun.jersey.api.client.ClientResponse;
import com.techm.bean.Response;
import com.techm.bean.SSAPropertyBean;
import com.techm.service.SONARService;
import com.techm.sonar.util.PropertiesUtil;
import com.techm.sonar.util.RestAPIUtil;






public  class SONARServiceImpl implements SONARService{
	
	private PropertiesUtil pUtil;

	private RestAPIUtil restAPIUtil;

	private Response response;
	
	@SuppressWarnings("unused")
	private String Projectkey;
	
	String message="\n";
	public Response sonar_project_creation(SSAPropertyBean SSAPropertyBean, Properties toolProperty) {
		
		
		int statusCode;
		response = new Response();
		pUtil = new PropertiesUtil(toolProperty);
		restAPIUtil=new RestAPIUtil(toolProperty);
	
		String key = removeSpecialChars(SSAPropertyBean.getProj_name()).toUpperCase();
		String name = SSAPropertyBean.getProj_name();
	
		
		
		String data = "";
		
	 	ClientResponse clientResponse = restAPIUtil.postSONARDataToRestAPI(pUtil.getCreateProjectUrl()+"key="+key+"&name="+name, data);
	 	System.out.println(response.toString());
		 statusCode = clientResponse.getStatus();
		 
			
		 if(statusCode==200){
			 message=message+"SONAR Project Created !\n" ;
		 }
		 else if(statusCode==400)
			 message=message+"SONAR Invalid request, Project already exists !\n";
		 else if(statusCode==401)
			 message=message+"SONAR Credentials are invalid\n";
		 else if(statusCode==403)
			 message=message+"SONAR user does not have permission to create projects\n";
	
		 else if(statusCode==500){
			 
			 message=message+"SONAR Unable to create project due to Internal Server Error,Check SonarQube\n";
		 }
		
			 
		 response.setMessage(message);
		 if(statusCode==201){
		 response.setStatus("success");
		 response.setStatusCode(200);
		 }
		 else{
			 response.setStatus("failure");
		 response.setStatusCode(400);
		 }
	 		return response;
	}
		 
	

	
	public String removeSpecialChars(String str) {
		Pattern pattern = Pattern.compile("[^a-z A-Z 0-9]|\\s");
		Matcher matcher = pattern.matcher(str);
		String key = matcher.replaceAll("");
		return key.toUpperCase();
	 }

}