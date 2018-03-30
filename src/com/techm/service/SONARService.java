package com.techm.service;

import java.util.Properties;

import com.techm.bean.Response;
import com.techm.bean.SSAPropertyBean;


public interface SONARService {
	
	public Response sonar_project_creation(SSAPropertyBean SSAPropertyBean, Properties toolProperty);
	
}