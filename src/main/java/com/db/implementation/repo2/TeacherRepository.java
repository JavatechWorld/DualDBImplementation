package com.db.implementation.repo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.implementation.entity2.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
