package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
		
	@RequestMapping(value="/{firstName}/{lastName}",method=RequestMethod.GET)
	public String getPerson(@PathVariable String firstName, @PathVariable String lastName, Model m) {
		m.addAttribute("firstName",firstName);
		m.addAttribute("lastName",lastName);
		return "person";
	}
	
	@RequestMapping(value="/addInfo",method=RequestMethod.GET)
	public String enterPersonInfo(Model m){
		m.addAttribute("command",new Person());
		return "personInfo";
	}
	
	@RequestMapping(value="/addPerson",method=RequestMethod.POST)
	public String addPerson(@ModelAttribute("command") Person p,Model m){
		m.addAttribute("firstName",p.getFirstName());
		m.addAttribute("lastName",p.getLastName());
		m.addAttribute("age",p.getAge());
		return "result";
	}
}
