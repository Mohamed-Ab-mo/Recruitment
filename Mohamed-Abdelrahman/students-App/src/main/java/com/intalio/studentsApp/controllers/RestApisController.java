package com.intalio.studentsApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intalio.studentsApp.entities.Courses;
import com.intalio.studentsApp.entities.Steps;
import com.intalio.studentsApp.entities.Students;
import com.intalio.studentsApp.exceptions.RestApisException;
import com.intalio.studentsApp.services.CoursesServices;
import com.intalio.studentsApp.services.StepsServices;
import com.intalio.studentsApp.services.StudentsServices;

@RestController
@RequestMapping("/apis")
public class RestApisController {
	
	@Autowired
	private StudentsServices studentsServices;
	@Autowired
	private CoursesServices coursesServices;
	@Autowired
	private StepsServices stepsServices;

	@GetMapping("/students")
	public List<Students> getAllStudents() {

		try {
			return studentsServices.getAllStudents();
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@GetMapping("/students/{id}")
	public Students getStudentById(@PathVariable Long id) {
		try {
			return studentsServices.getStudentById(id);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}


	}

	@PostMapping("/students")
	public void saveStudent(@RequestBody Students student) {

		try {
			studentsServices.saveStudent(student);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@PutMapping("/students")
	public void updateStudent(@RequestBody Students student) {

		try {
			studentsServices.updateStudent(student);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable Long id) {

		try {
			studentsServices.deleteStudent(id);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@GetMapping("/courses")
	public List<Courses> getAllCourses() {

		try {
			return coursesServices.getAllCourses();
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@GetMapping("/courses/{id}")
	public Courses getCourseById(@PathVariable Long id) {

		try {
			return coursesServices.getCourseById(id);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@PostMapping("/courses")
	public void saveCourse(@RequestBody Courses course) {

		try {
			coursesServices.saveCourse(course);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@PutMapping("/courses")
	public void updateCourse(@RequestBody Courses course) {

		try {
			coursesServices.updateCourse(course);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable Long id) {

		try {
			coursesServices.deleteCourse(id);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@GetMapping("/steps")
	public List<Steps> getAllSteps() {

		try {
			return stepsServices.getAllSteps();
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@GetMapping("/steps/{id}")
	public Steps getStepById(@PathVariable Long id) {
		try {
			return stepsServices.getStepById(id);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@PostMapping("/steps")
	public void saveStep(@RequestBody Steps step) {

		try {
			stepsServices.saveStep(step);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@PutMapping("/steps")
	public void updateStep(@RequestBody Steps step) {

		try {
			stepsServices.updateStep(step);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

	@DeleteMapping("/steps/{id}")
	public void deleteStep(@PathVariable Long id) {

		try {
			stepsServices.deleteStep(id);
		} catch (RestApisException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry internal error please try again latter.");
		} finally {

		}

	}

}
