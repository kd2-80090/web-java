package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
	
	//depcy : service layer 
	@Autowired
	private DepartmentService deptService;
	
     public DepartmentController() {
		// TODO Auto-generated constructor stub
    	 System.out.println("In default ctor of "+getClass());
	}
     
     //URL: http//host:port/ctx/departments/list
     //Method: Get
     @GetMapping("/list")
     public ModelAndView listAllDepts() {
    	 System.out.println("In listAllDepts() ");
 		//o.s.w.s.ModelAndView(String LVN,String modelAttrName,Object modelAttrVal
		return new ModelAndView("/departments/list", "dept_list",deptService.getAllDepartments());
    	 
     }
     
     /*
      * Handler-->MnV-->D.S
      * D.S.-->LVN-->V.R-->
      * AVN :/WEB-INF/views/departments/list.jsp
      * D.S Stores model attr under : request scope
      * forwards the request  to jsp based view layer
      * */
     
     
     
     
     
     
     
     
}
