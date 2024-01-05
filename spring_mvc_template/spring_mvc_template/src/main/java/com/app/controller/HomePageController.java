package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
   public HomePageController() {
	// TODO Auto-generated constructor stub
		System.out.println("In ctor of"+getClass());

}
   
   @RequestMapping("/")//mandatory method level annotation
	//to intercept any HTTP request(get|post|put|patch.....)
	public String index(){
		System.out.println("In index");
		//ret LVN(Logical View Name) to D.S(DispatcherServlet)
		//-->to be resolved by V.R(ViewResolver)
		
		return "/index";//Handler is returning==>LVN==>D.S==>V.R==>
		//==>AVN:WEB-INF/views/index.jsp 
		//D.S forwards the client to jsp page
	}
   
   
   
}
