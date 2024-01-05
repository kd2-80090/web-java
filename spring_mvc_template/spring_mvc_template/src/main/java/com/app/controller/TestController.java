package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//mandatory 
@RequestMapping("/test")//optional but recommended 
//for the reusable base pattern
public class TestController {
	
	public TestController() {
		// TODO Auto-generated constructor stub
		System.out.println("In ctor of "+getClass());
	}
	
	//URL :http//host:port/ctx/test/test1
	//method : get
	@GetMapping("/test1")//=@RequestMapping(methos=GET)
	//In handlerMapping bean
	//key: /test/test1
	//value :com.app.controller.TestController.testModelAnsView.
	public ModelAndView testModelAnsView() {
		System.out.println("In testModelAnsView()");
		//o.s.w.s.ModelAndView(String LVN,String modelAttrName,Object modelAttrVal
		
		return new ModelAndView("/test/test1", "server_ts", LocalDateTime.now());
		//we use ModelAndView bcoz we have to return result
	}
	/* 
	 * Handler rets ModelAndView --> D.S
	 * D.S -->LVN-->V.R-->AVN:/WEB-INF/views/test/test1.jsp
	 * D.S --> adds model attrs(results) under request scope
	 * forwards the client  to jsp based view layer
	 */
	

}
