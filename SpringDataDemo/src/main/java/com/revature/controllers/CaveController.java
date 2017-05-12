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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.service.ForestService;

@RestController
@RequestMapping(value="/cave")
public class CaveController {
	
	@Autowired 
	ForestService fs;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public @ResponseBody List<Cave> getCaves(){
		return fs.getCaves();
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Object> getCaveByName(@PathVariable("name") String name){
		return ResponseEntity.ok(fs.getCaveByName(name));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String createCave(@RequestBody Cave cave){
		if (fs.addCave(cave)) {
			return "Cave created!";
		}else{
			return "Cave not created";
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Boolean deleteCave(@PathVariable("id") int id){
		System.out.println("trying to delete cave with id: "+id);
		//ResponseEntity<Object> response = new ResponseEntity<Object>(null);
		return fs.deleteCave(id);
	}
	


}
