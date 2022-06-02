package com.intalio.studentsApp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Courses {
	private Long id;
	private String name;
	private String description;
	private List<Steps> steps;
	private List<Students> students;

	public Courses() {

	}

	public Courses(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "COURSES_STEPS", joinColumns = @JoinColumn(name = "COURSE_ID"), 
	inverseJoinColumns = @JoinColumn(name = "STEP_ID"))
	public List<Steps> getSteps() {
		return steps;
	}

	public void setSteps(List<Steps> steps) {
		this.steps = steps;
	}

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "STUDENTS_COURSES", joinColumns = @JoinColumn(name = "COURSE_ID"), 
	inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Courses))
			return false;
		return this.id.equals(((Courses) obj).getId());
	}
	
}
