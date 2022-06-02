package com.intalio.studentsApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.intalio.studentsApp.entities.Students;

@Service
public class LoginServices {
	
	@Autowired
	private StudentsServices studentsServices;
	
	public ModelAndView doLogin(String studentName, String password) {
		ModelAndView response = new ModelAndView();
		if((studentName.equalsIgnoreCase("firstStudent") && password.equals("firstStudentPass")) || 
				(studentName.equalsIgnoreCase("secondStudent") && password.equals("secondStudentPass"))) {
			List<Students> studentsList = studentsServices.getAllStudents();
			boolean showStudentsList = false;
			if(studentsList != null && !studentsList.isEmpty())
				showStudentsList = true;
			response.addObject("studentsList", studentsList);
			response.addObject("showStudentsList", showStudentsList);
			response.setViewName("students");
		} else {
			response.addObject("failedLogin", true);
			response.setViewName("login");
		}
		return response;
	}

}
