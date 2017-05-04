package com.revature.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
		m.addAttribute("person",new Person());
		return "personInfo";
	}
	
	@RequestMapping(value="/addInfo",method=RequestMethod.POST)
	public String addPerson(@Valid Person person, BindingResult br,Model m){
		if (br.hasErrors()){
			Object errors = br.getAllErrors();
			m.addAttribute("errors",errors);
			return "personInfo";
		}else{
			m.addAttribute("firstName",person.getFirstName());
			m.addAttribute("lastName",person.getLastName());
			m.addAttribute("dateOfBirth",person.getDateOfBirth());
		}
		
		//create (for a login) a loginService class 
		//call authUser 
		return "result";
	}
}
