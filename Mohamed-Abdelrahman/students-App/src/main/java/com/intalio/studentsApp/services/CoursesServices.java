package com.intalio.studentsApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.intalio.studentsApp.exceptions.RestApisException;
import com.intalio.studentsApp.entities.Courses;
import com.intalio.studentsApp.entities.Students;
import com.intalio.studentsApp.repositories.CoursesRepository;

@Service
public class CoursesServices {

	@Autowired
	CoursesRepository repository;

	public List<Courses> getAllCourses() throws RestApisException {
		return (List<Courses>) repository.findAll();
	}

	public Courses getCourseById(Long id) throws RestApisException {
		try {
			Courses course = repository.findById(id).orElse(null);
			if (course == null)
				throw new RestApisException(HttpStatus.NOT_FOUND, "Requested resource not found.");
			return course;
		} catch (Exception e) {
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Fetching process failed.");
		}
	}

	public void saveCourse(Courses entity) throws RestApisException {
		repository.save(entity);
	}

	public void updateCourse(Courses entity) throws RestApisException {
		repository.save(entity);
	}

	public void deleteCourse(Long id) throws RestApisException {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new RestApisException(HttpStatus.NOT_FOUND, "Requested resource not found for the operation.");
		}
	}

}
