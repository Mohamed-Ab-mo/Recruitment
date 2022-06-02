package com.intalio.studentsApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.intalio.studentsApp.exceptions.RestApisException;
import com.intalio.studentsApp.entities.Courses;
import com.intalio.studentsApp.entities.Steps;
import com.intalio.studentsApp.repositories.StepsRepository;

@Service
public class StepsServices {

	@Autowired
	StepsRepository repository;

	public List<Steps> getAllSteps() throws RestApisException {
		return (List<Steps>) repository.findAll();
	}

	public Steps getStepById(Long id) throws RestApisException {
		try {
			Steps step = repository.findById(id).orElse(null);
			if (step == null)
				throw new RestApisException(HttpStatus.NOT_FOUND, "Requested resource not found.");
			return step;
		} catch (Exception e) {
			throw new RestApisException(HttpStatus.INTERNAL_SERVER_ERROR, "Fetching process failed.");
		}
	}

	public void saveStep(Steps entity) throws RestApisException {
		repository.save(entity);
	}

	public void updateStep(Steps entity) throws RestApisException {
		repository.save(entity);
	}

	public void deleteStep(Long id) throws RestApisException {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RestApisException(HttpStatus.NOT_FOUND, "Requested resource not found for the operation.");

		}
	}

}
