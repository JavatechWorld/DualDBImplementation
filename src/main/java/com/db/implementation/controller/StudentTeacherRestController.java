package com.db.implementation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.implementation.builder.ObjectBuilder;
import com.db.implementation.entity1.Student;
import com.db.implementation.entity1.StudentDTO;
import com.db.implementation.entity2.Teacher;
import com.db.implementation.entity2.TeacherDTO;
import com.db.implementation.repo1.StudentRepository;
import com.db.implementation.repo2.TeacherRepository;

@RestController
public class StudentTeacherRestController {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	TeacherRepository teacherRepo;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody StudentDTO studentDTO) {
		Student student = ObjectBuilder.createStudentFromStudentDTO(studentDTO);
		return studentRepo.save(student);
	}
	
	@PostMapping("/saveTeacher")
	public Teacher saveTeacher(@RequestBody TeacherDTO teacherDTO) {
		Teacher teacher = ObjectBuilder.createTeacherFromTeacherDTO(teacherDTO);
		return teacherRepo.save(teacher);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/getAllTeachers")
	public List<Teacher> getAllTeachers(){
		return teacherRepo.findAll();
	}
}
