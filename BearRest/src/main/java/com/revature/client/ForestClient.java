package com.revature.client;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Cave;

public class ForestClient {
	
	SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	RestTemplate restTemplate = new RestTemplate(requestFactory);
	
	String resourceUrl
	  = "http://localhost:8083/SpringDataDemo";
	
	public Cave getCaveByName(String name){
		  return restTemplate.getForObject(resourceUrl+"/cave/"+name,Cave.class);
	}
	 
	public ArrayList<Cave> getCaves(){
		ResponseEntity<? extends ArrayList<Cave>> response = 
				restTemplate.getForEntity(resourceUrl+"/cave/all/", (Class <? extends ArrayList<Cave>>)ArrayList.class);
		return response.getBody();
	}
	
	public Cave saveCave(Cave cave){
		HttpEntity<Cave> request = new HttpEntity<Cave>(cave);
		return restTemplate.postForObject(resourceUrl+"/cave", request, Cave.class);
	}
	
	
	

}
