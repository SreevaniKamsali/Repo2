package com.techm.service;

import java.io.IOException;


public interface SONARService {
	//public void create_project(String project_key,String pro_name,String pro_methodology,String project_description,String pro_lead,String release_date);
	public String sonar_project_creation(String project_key, String pro_name,
			 String qualifier) throws IOException;
	
	
}
