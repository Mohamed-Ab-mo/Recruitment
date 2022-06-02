package com.intalio.studentsApp.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.intalio.studentsApp.entities.Students;
import com.intalio.studentsApp.repositories.CoursesRepository;
import com.intalio.studentsApp.repositories.StepsRepository;
import com.intalio.studentsApp.repositories.StudentsRepository;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RestApisControllerTest {

	@Autowired
	RestApisController restController;

	@Autowired
	StudentsRepository studentsRepository;
	@Autowired
	CoursesRepository coursesRepository;
	@Autowired
	StepsRepository stepsRepository;

	// @Autowired
	// MockMvc mockMvc;

	@BeforeEach
	public void setup() throws Exception {
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	void testGetAllStudents() {
		URI uri = UriComponentsBuilder.fromUriString("/apis/students").build().encode().toUri();
		List<Students> forObject = this.restTemplate.getForObject(uri, List.class);
		assertTrue(forObject.size() > 0);

	}

	@Test
	@Order(2)
	void testGetStudentById() throws Exception {
		Long id = 1L;
		URI uri = UriComponentsBuilder.fromUriString("/apis/students/{id}").buildAndExpand(id).encode().toUri();
		Students student = this.restTemplate.getForObject(uri, Students.class);
		assertEquals("Ahmed", student.getName());

		// RequestBuilder request = MockMvcRequestBuilders.get("students/1");
		// MvcResult result = mockMvc.perform(request).andReturn();
		// Students student = new Students("Ahmed", 16);
		// student.setId(new Long(1));
		// assertEquals(student, result);
	}

	@Test
	@Order(3)
	void testSaveStudent() {

		Students student = new Students("Zidan", 20);
		HttpEntity<Students> request = new HttpEntity<Students>(student);
		ResponseEntity<Void> result = restTemplate.postForEntity("/apis/students", request, Void.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	@Order(4)
	void testUpdateStudent() {
		Long id = 3L;
		Students student = new Students("Zidan", 20);
		student.setId(id);
		HttpEntity<Students> request = new HttpEntity<Students>(student);
		URI uri = UriComponentsBuilder.fromUriString("/apis/students").build().encode().toUri();
		restTemplate.put("/apis/students", request);
		assertEquals(student.getName(), studentsRepository.findById(id).get().getName());
	}

	@Test
	@Order(5)
	void testDeleteStudent() {
		Long id = 1L;
		URI uri = UriComponentsBuilder.fromUriString("/apis/students/{id}").buildAndExpand(id).encode().toUri();

		restTemplate.delete(uri);
		assertNull(studentsRepository.findById(id).orElse(null));

	}
	//
	// @Test
	// void testGetAllCourses() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testGetCourseById() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testSaveCourse() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testUpdateCourse() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testDeleteCourse() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testGetAllSteps() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testGetStepById() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testSaveStep() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testUpdateStep() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testDeleteStep() {
	// fail("Not yet implemented");
	// }
	
}