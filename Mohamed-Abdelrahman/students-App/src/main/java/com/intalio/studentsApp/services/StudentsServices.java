package com.intalio.studentsApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.intalio.studentsApp.entities.Students;
import com.intalio.studentsApp.exceptions.RestApisException;
import com.intalio.studentsApp.repositories.StudentsRepository;

@Service
public class StudentsServices {

	@Autowired
	StudentsRepository repository;

	public List<Students> getAllStudents() throws RestApisException {
		return (List<Students>) repository.findAll();
	}

	// @Transactional
	public Students getStudentById(Long id) throws RestApisException {
		try {
			Students student = repository.findById(id).orElse(null);
			if (student == null)
				throw new RestApisException(HttpStatus.NOT_FOUND, "Requested resource not found.");
			return student;
		} catch (Exception e) {
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Fetching process failed.");
		}
	}

	// @Transactional
	public void saveStudent(Students entity) throws RestApisException {
		repository.save(entity);
	}

	// @Transactional
	public void updateStudent(Students entity) throws RestApisException {
		repository.save(entity);
	}

	// @Transactional
	public void deleteStudent(Long id) throws RestApisException {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RestApisException(HttpStatus.NOT_FOUND, "Requested resource not found for the operation.");
		}
	}
}
