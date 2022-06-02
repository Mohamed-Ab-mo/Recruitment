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
public class Students {
	private Long id;
	private int age;
	private String name;
	
	private List<Courses> courses;
	
	public Students() {
		
	}

	public Students(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "STUDENTS_COURSES", joinColumns = @JoinColumn(name = "STUDENT_ID"), 
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Courses))
			return false;
		return this.id.equals(((Students) obj).getId());
	}
	
}
