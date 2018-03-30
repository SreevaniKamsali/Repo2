package com.techm.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

public class RestAPIUtil {
private PropertiesUtil pUtil = new PropertiesUtil();
public ClientResponse postDataToRestAPI(String RestAPIURL, String data){	
	Client client;
	String credentials=pUtil.getUser()+":"+pUtil.getPassword();
	System.out.println(credentials);
	String auth = new String(Base64.encode(credentials));
	client=Client.create();
	WebResource webResource = client.resource(RestAPIURL);
	ClientResponse response = webResource.header("Authorization", "Basic " + auth).type("application/json").accept("application/json").post(ClientResponse.class,data);
	return response;
}
}
