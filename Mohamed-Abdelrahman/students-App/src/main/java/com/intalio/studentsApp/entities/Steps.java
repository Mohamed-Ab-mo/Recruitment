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
public class Steps {
	private Long id;
	private String name;
	
	private List<Courses> courses;
	
	public Steps() {
		
	}

	public Steps(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STEP_ID")
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

	@JsonIgnore
	@JoinTable(name = "COURSES_STEPS", joinColumns = @JoinColumn(name = "STEP_ID"), 
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || ! (obj instanceof Steps))
			return false;
		return this.id.equals(((Steps) obj).getId());
	}
	
}
