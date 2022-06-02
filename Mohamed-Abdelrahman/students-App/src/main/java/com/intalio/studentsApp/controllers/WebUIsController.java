package com.intalio.studentsApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.intalio.studentsApp.services.LoginServices;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebUIsController {
	@Autowired
	private LoginServices loginServices;
	
	@RequestMapping("/login")
	public ModelAndView doLogin(String studentName, String password) {
		return loginServices.doLogin(studentName, password);		
	}

}
