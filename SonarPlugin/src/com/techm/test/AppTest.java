package com.techm.test;
/*
import com.techm.planning.JIRA;
import com.techm.util.PropertiesUtil;*/

import com.techm.util.PropertiesUtil;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public static void main(String[] args) {
		
		
		PropertiesUtil putil=new PropertiesUtil();
		//putil.setUser("admin");
		System.out.println(putil.getPassword());
	//	JIRA jira=new JIRA();
	//	jira.initiate("demo", "demo_now", "Agile", "ads", "admin", "2017-11-15");
	}
}
