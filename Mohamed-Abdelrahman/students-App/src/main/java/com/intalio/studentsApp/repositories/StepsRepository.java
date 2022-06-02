package com.intalio.studentsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intalio.studentsApp.entities.Steps;

@Repository
public interface StepsRepository extends JpaRepository<Steps, Long> {

}
