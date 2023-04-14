package com.db.implementation.repo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.implementation.entity1.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
