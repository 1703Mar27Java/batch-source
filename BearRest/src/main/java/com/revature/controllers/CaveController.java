package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Cave;

@RestController
@RequestMapping(value="/cave")
public class CaveController {
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<Object> getCaves(){
		List<Cave> allCaves = new ArrayList();
		allCaves.add(new Cave("caveThree"));
		allCaves.add(new Cave("caveFour"));
		return ResponseEntity.ok(allCaves);
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Object> getCaveByName(@PathVariable("name") String name){
		return ResponseEntity.ok(new Cave(name));
	}

}
