package com.intalio.studentsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intalio.studentsApp.entities.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
