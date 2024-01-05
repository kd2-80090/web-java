package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//mandatory cls level annotation to tell SC ,
//following is a spring bean,having req handling methods 
//singleton and eager
public class HelloController {
	public HelloController() {
		// TODO Auto-generated constructor stub
		System.out.println("In ctor of"+getClass());
	}
	//add request handling method to display welcome mesg
	@RequestMapping("/hello")//mandatory method level annotation
	//to intercept any HTTP request(get|post|put|patch.....)
	public String sayHello(){
		System.out.println("In say hello");
		//ret LVN(Logical View Name) to D.S(DispatcherServlet)
		//-->to be resolved by V.R(ViewResolver)
		
		return "/welcome";//AVN:WEB-INF/views/welcome.jsp
		
	}
	
	
	

}
