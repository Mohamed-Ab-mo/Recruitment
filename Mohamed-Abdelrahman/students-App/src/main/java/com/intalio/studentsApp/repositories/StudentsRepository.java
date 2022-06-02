package com.intalio.studentsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intalio.studentsApp.entities.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {

}
