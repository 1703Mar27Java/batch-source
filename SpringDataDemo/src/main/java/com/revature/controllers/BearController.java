package com.revature.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Bear;
import com.revature.service.ForestService;

@RestController
@RequestMapping(value="/bear")
public class BearController {
	
	@Autowired 
	ForestService fs;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<Object> getBears(){
		List<Bear> allBears = fs.getBears();
		return ResponseEntity.ok(allBears);
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Object> getBearByName(@PathVariable("name") String name){
		return ResponseEntity.ok(fs.getBearByName(name));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createBear(@RequestBody Bear bear){
		ResponseEntity<Object> response = new ResponseEntity<Object>(null);
		if (fs.addBear(bear)) {
			return response.ok("Bear created!");
		}else{
			return (ResponseEntity<Object>) response.status(HttpStatus.PRECONDITION_FAILED);
		}
	}
	

}