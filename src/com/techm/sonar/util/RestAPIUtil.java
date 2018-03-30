package com.techm.sonar.util;
import java.util.Properties;

	import com.sun.jersey.api.client.Client;
	import com.sun.jersey.api.client.ClientResponse;
	import com.sun.jersey.api.client.WebResource;
	import com.sun.jersey.core.util.Base64;

	public class RestAPIUtil {
		PropertiesUtil pUtil;
		public RestAPIUtil(Properties toolProperties) {
			 pUtil = new PropertiesUtil(toolProperties);	
		}

	public ClientResponse postSONARDataToRestAPI(String RestAPIURL, String data){	
		Client client=new Client();
		String credentials=pUtil.getUser()+":"+pUtil.getPassword();
		String auth = new String(Base64.encode(credentials));
		client=Client.create();
		
		WebResource webResource = client.resource(RestAPIURL);
		ClientResponse response = webResource.header("Authorization", "Basic " + auth).type("application/json").accept("application/json").post(ClientResponse.class,data);
		client.destroy();
		return response;
	}
	}

