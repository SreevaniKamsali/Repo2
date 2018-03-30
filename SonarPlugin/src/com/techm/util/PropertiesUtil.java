package com.techm.util;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;



public class PropertiesUtil {
	private String createProjectUrl;
	private String URL;
	private String user;
	private String password;
	
	public PropertiesUtil(){
	loadProperties();
}
public Properties prop = new Properties();

public void loadProperties(){
	InputStream input = null;
	try {

		input=new FileInputStream("SONAR.properties");
		prop.load(input);
		createProjectUrl=prop.getProperty("create.project.url");
		
		URL= prop.getProperty("sonar.url");
		user=prop.getProperty("user");
		password=prop.getProperty("password");
		System.out.println(password);
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
public void writeProperty(){
	Properties prop = new Properties();
	OutputStream output = null;

	try {

		output = new FileOutputStream("JIRA.properties");

		// set the properties value
		prop.setProperty("create.project.url",createProjectUrl );
		prop.setProperty("sonar.url",URL);
		prop.setProperty("user", user);
		prop.setProperty("password",password );

		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

public String getURL() {
	
	return URL;
}

public void setURL(String URL) {
	this.URL= URL;
}

public String getCreateProjectUrl() {
	
	return createProjectUrl;
}

public void setCreateProjectUrl(String createProjectUrl) {
	this.createProjectUrl = createProjectUrl;
	writeProperty();
}





public String getUser() {

	return user;
}


public void setUser(String user) {
	this.user = user;
	writeProperty();
}


public String getPassword() {

	return password;
}


public void setPassword(String password) {
	this.password = password;
	writeProperty();
}

}
